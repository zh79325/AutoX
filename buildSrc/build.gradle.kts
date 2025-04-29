import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    maven { url= uri("https://maven.aliyun.com/repository/gradle-plugin/")}
    maven { url= uri("https://maven.aliyun.com/repository/central") }
    maven { url = uri("https://maven.aliyun.com/repository/google") }
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    mavenCentral()
}

dependencies{
    implementation("com.google.code.gson:gson:2.9.1")
}