//引用插件
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

//安卓属性
android {
    compileSdkVersion(29)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    //签名类型
    signingConfigs {
        register("release") {
            //别名
            keyAlias = "ai"
            //别名密码
            keyPassword = "123456"
            //路径
            storeFile = file("D:\\jks\\ai\\ai.jks")
            //密码
            storePassword = "123456"
        }
    }
    //编译类型
    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled = false
            //自动签名打包
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    //输出类型
    android.applicationVariants.all {
        //编译类型
        val buildType = this.buildType.name
        outputs.all {
            //输出APK
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                if (buildType == "release") {
                    this.outputFileName = "AI_V${defaultConfig.versionName}_$buildType.apk"
                }
            }
        }
    }
    //依赖操作
    compileOptions() {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

//依赖
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation(project(":lib_base"))

    if (!ModuleConfig.isApp) {
        implementation(project(":mould_app_manager"))
        implementation(project(":mould_constellation"))
        implementation(project(":mould_developer"))
        implementation(project(":mould_joke"))
        implementation(project(":mould_map"))
        implementation(project(":mould_setting"))
        implementation(project(":mould_voice_setting"))
        implementation(project(":mould_weather"))
    }
}