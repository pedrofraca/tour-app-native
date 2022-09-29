import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

repositories {
    mavenCentral()
}

plugins {
    kotlin("multiplatform")
    `maven-publish`
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
}

kotlin {
    //select iOS target platform depending on the Xcode environment variables
    iosX64("ios") {
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
                api(project(":domain"))
                api(project(":data"))
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
            }
        }

        val jvmTest by getting {
            dependencies {
            implementation(kotlin("test-junit"))
            implementation("io.mockk:mockk:1.9.3")
            }
        }
    }
}

