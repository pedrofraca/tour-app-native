import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

group = "io.github.pedrofraca"
version = "0.0.10-SNAPSHOT"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/pedrofraca/tour-app-native")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

kotlin {
    //select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = "usecase"
            }
        }
    }

    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":domain"))
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
            }
        }

        val commonTest by getting {
            dependencies {
            implementation(kotlin("test-junit"))
            implementation("io.mockk:mockk:1.9.3")
            }
        }
    }
}


val packForXcode by tasks.creating(Sync::class) {
    group = "build"

    //selecting the right configuration for the iOS framework depending on the Xcode environment variables
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>("ios").binaries.getFramework(mode)

    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)

    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\nexport 'JAVA_HOME=${System.getProperty("java.home")}'\ncd '${rootProject.rootDir}'\n./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)
