package com.github.lereena.txtcplugin.services

import com.github.lereena.txtcplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
