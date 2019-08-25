package _Self

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.dockerRegistry

object Project : Project({
    description = "Contains all other projects"

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "coverage.zip!index.html")
            param("title", "Code Coverage")
            param("type", "BuildReportTab")
        }
        dockerRegistry {
            id = "PROJECT_EXT_29"
            name = "Docker Registry"
            url = "https://registry.cn-beijing.aliyuncs.com"
            userName = "lei.zhang@gatherresource.com"
            password = "credentialsJSON:a496943b-0ead-4106-996d-c99ab1fd48db"
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }

 
    subProject(GnWorkLoadInquiry.Project)
})
