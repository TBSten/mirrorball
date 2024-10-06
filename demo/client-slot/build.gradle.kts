plugins {
    id("me.tbsten.compose.dom.bow") version "0.0.1"
}

bow {
    entryProjects {
        clientPage(projects.demo.clientSlot.client, "")
        server(projects.demo.clientSlot.server)
    }
}
