plugins {
    id("me.tbsten.mirrorball.bow") version "0.0.1"
}

bow {
    entryProjects {
        clientPage(projects.demo.bow.client, "")
        server(projects.demo.bow.server)
    }
}
