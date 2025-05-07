import com.android.sdklib.repository.AndroidSdkHandler

initVersions(file("project-versions.json"))
//国内使用腾讯镜像
System.setProperty(AndroidSdkHandler.SDK_TEST_BASE_URL_PROPERTY,"https://mirrors.cloud.tencent.com/AndroidSDK/")
plugins {
    id("com.google.devtools.ksp") version "$kotlin_version-1.0.20" apply false
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    extra.apply {
        set("kotlin_version", kotlin_version)
    }

    repositories {
        mavenLocal()
        //首选国外镜像加快github CI
        maven("https://maven.aliyun.com/repository/central")
        google { url = uri("https://maven.aliyun.com/repository/google") }
        mavenCentral { url = uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
        classpath(kotlin("gradle-plugin", version = kotlin_version))
        classpath("com.jakewharton:butterknife-gradle-plugin:10.2.3")
        classpath(libs.okhttp)
    }
}

allprojects {
    repositories {
        //mavenLocal()
        //首选国外镜像加快github CI
        maven { url= uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url= uri("https://maven.aliyun.com/repository/gradle-plugin/")}
        maven("https://www.jitpack.io")
        google()
        mavenCentral()
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.layout.buildDirectory)
}
