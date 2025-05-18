plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    namespace = "com.example.juegodcolores"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.juegodcolores"
        minSdk = 31
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}
dependencies {
    // Librerías básicas de AndroidX y Material Design
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navegación entre fragmentos con Jetpack Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Dependencia personalizada (probablemente definida en libs.versions.toml)
    implementation(libs.library)

    // Dependencias para pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Soporte adicional de vistas
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.gridlayout)

    // Necesario para usar DataBinding y Safe Args (procesador de anotaciones)
    kapt("androidx.databinding:databinding-compiler-common:8.10.0")
}

// Configuración para resolver conflictos entre versiones de dependencias
configurations.all {
    resolutionStrategy {
        // Forzar el uso de una versión específica de androidx.core
        force("androidx.core:core:1.16.0")
        // Excluir bibliotecas antiguas del grupo com.android.support
        exclude(group = "com.android.support")
    }
}