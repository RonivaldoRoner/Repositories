plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Config.compileSdkVersion)
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "gitHub", "\"https://api.github.com/\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dependency.kotlin)
    implementation(Dependency.coreKtx)
    implementation(Dependency.appCompat)
    implementation(Dependency.material)
    implementation(Dependency.constraintLayout)
    implementation(Dependency.navigationFragment)
    implementation(Dependency.navigationUi)

    // Inject Dependencies
    implementation(Dependency.koinCore)
    implementation(Dependency.koinAndroid)
    implementation(Dependency.koinViewModel)
    implementation(Dependency.koinAndroidX)

    // Http Request
    implementation(Dependency.okhttp)
    implementation(Dependency.loggingInteceptor)
    implementation(Dependency.retrofit)
    implementation(Dependency.gson)
    implementation(Dependency.legacySupport)

    //Glide
    implementation(Dependency.glide)
    annotationProcessor(Dependency.glideCompile)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("org.jetbrains.kotlin:kotlin-script-runtime")
    compileOnly("com.pinterest.ktlint:ktlint-core:0.34.2")
}