plugins {
    id("me.tbsten.mirrorball.bow") version "0.0.1"
}

bow {
    entryProjects {
        clientPage(projects.demo.clientSlot.client, "")
        server(projects.demo.clientSlot.server)
    }
}
