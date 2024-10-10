plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mirrorball.library)
}

kotlin {
    jvm()

    js {
        browser {
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(libs.kotlinx.html)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.kotlin.wrappers.css)
            implementation(projects.core.coreApi)
        }
    }
}

ktlint {
    filter {
        // 自動生成したファイルはチェックしない
        exclude("**/me/tbsten/compose/dom/generated/**")
    }
}
