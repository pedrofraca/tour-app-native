import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "io.github.pedrofraca"
version = "0.0.12-SNAPSHOT"

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
//    publications {
//        register("gpr") {
//            from(components["java"])
//        }
//    }
}

kotlin {
    iosX64("ios") {
        binaries {
            framework {
                baseName = "data"
            }
        }
    }

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":domain"))
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("io.mockk:mockk:1.9.3")
            }
        }

//        val iosMain by getting {
//            dependencies {
//
//            }
//        }
    }

    
}
