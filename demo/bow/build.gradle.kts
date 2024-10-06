plugins {
    id("me.tbsten.compose.dom.bow") version "0.0.1"
}

bow {
    entryProjects {
        clientPage(projects.demo.bow.client, "")
        clientPage(projects.demo.bow.client.top, "top")
        server(projects.demo.bow.server)
    }
}
