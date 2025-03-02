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
    implementation("com.google.android.gms:play-services-maps:18.0.1")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    // JSON
    dependencies {
        implementation("com.github.amitshekhariitbhu.Fast-Android-Networking:android-networking:1.0.4")
        implementation("com.ramotion.cardslider:card-slider:0.3.1")
        implementation("com.github.bumptech.glide:glide:4.14.2")
        implementation("com.github.florent37:diagonallayout:1.0.7")
        implementation("com.github.ivbaranov:materialfavoritebutton:0.1.5")
        annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
        implementation("com.flaviofaria:kenburnsview:1.0.7")
        implementation ("androidx.recyclerview:recyclerview:1.2.1")
        implementation(libs.transport.api)
    }
    //Retrofitt
    implementation("com.github.ivbaranov:materialfavoritebutton:0.1.5")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("com.github.bumptech.glide:compiler:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.android.volley:volley:1.2.1")

}
