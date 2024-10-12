plugins {
    id("me.tbsten.mirrorball.bow") version "0.0.1"
}

bow {
    entryProjects {
        clientScript(projects.demo.bow.client.top, "")
        clientScript(projects.demo.bow.client.clientSlot, "client-slot")
        server(projects.demo.bow.server)
    }
}
