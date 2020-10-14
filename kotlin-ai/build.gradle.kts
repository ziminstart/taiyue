// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val gradle_version = "4.0.0"
    val kotlin_version = "1.3.72"
    repositories {
        google()
        jcenter()
        //阿里云
        maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

    }
}

allprojects {
    repositories {
        google()
        jcenter()

        maven { setUrl("https://jitpack.io") }
        //阿里云
        maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
        maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/jcenter") }
        maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/google") }
        maven { setUrl("http://maven.aliyun.com/nexus/content/repositories/gradle-plugin") }
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

