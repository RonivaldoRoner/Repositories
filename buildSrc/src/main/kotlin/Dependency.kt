object Dependency {
    object Version {
        const val agp = "4.1.3"
        const val kotlin = "1.4.32"

        const val appCompat = "1.3.0"
        const val material = "1.3.0"
        const val coreKtx = "1.5.0"
        const val lifecycle = "2.3.1"
        const val coroutines = "1.3.9"
        const val constraintLayout = "2.0.4"
        const val koin = "2.1.3"
        const val navigation = "2.3.5"
        const val okhttp3 = "4.2.1"
        const val retrofit = "2.6.2"
        const val legacySupport = "1.0.0"
        const val glide = "4.10.0"
    }

    object Plugins{
        const val application = "com.android.application"
        const val android = "android"
        const val kapt = "kapt"
        const val kotlinExtensions = "android.extensions"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycle}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"

    // Inject Dependencies
    const val koinCore = "org.koin:koin-core:${Version.koin}"
    const val koinAndroid = "org.koin:koin-android:${Version.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    const val koinAndroidX = "org.koin:koin-androidx-scope:${Version.koin}"

    // Http Request
    const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp3}"
    const val loggingInteceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Version.legacySupport}"

    //Glide
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glideCompile = "com.github.bumptech.glide:compiler:${Version.glide}"

    object ClassPath {
        const val agp = "com.android.tools.build:gradle:${Version.agp}"
        const val kgp = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
    }


}