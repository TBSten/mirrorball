package me.tbsten.compose.dom.bow

// TODO
// BowBuildOutputDir is unknown from framework code
//fun Application.bowRouting(configuration: Routing.() -> Unit) =
//    routing {
//        staticFiles(
//            "/",
//            BowBuildOutputDir,
//        ) {
//            preCompressed(CompressedFileType.BROTLI, CompressedFileType.GZIP)
//        }
//        configuration()
//    }.also {
//        // TODO handling static generation
//        // https://youtrack.jetbrains.com/issue/KTOR-7510/Is-There-list-routing-path-in-ktor-server
//        println("TODO: Handling Static Generation.")
//        val routes = it.getAllRoutes()
//        println("      routes=$routes")
//    }
