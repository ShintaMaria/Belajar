//val implementation: Unit
//    get() {
//        TODO()
//    }

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.belajar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.belajar"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.mediarouter)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    implementation 'androidx.recyclerview:recyclerview:1.2.1'
//    implementation 'androidx.cardview:cardview:1.0.0'

//
//    // AndroidX RecyclerView library
//    implementation 'androidx.recyclerview:recyclerview:1.2.1'
//
//    // AndroidX CardView library
//    implementation 'androidx.cardview:cardview:1.0.0'
//
//    // AndroidX AppCompat library
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//
//    // Optional: KTX library for easier Kotlin usage
//    implementation 'androidx.core:core-ktx:1.6.0'

//    // Testing dependencies
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

}