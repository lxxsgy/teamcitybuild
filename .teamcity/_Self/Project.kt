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
        feature {
            id = "PROJECT_EXT_3"
            type = "OAuthProvider"
            param("clientId", "lxxsgy")
            param("defaultTokenScope", "public_repo,repo,repo:status,write:repo_hook")
            param("secure:clientSecret", "credentialsJSON:52cecdf4-be91-49ec-822d-f14148b1e46f")
            param("displayName", "GitHub.com")
            param("gitHubUrl", "https://github.com/")
            param("providerType", "GitHub")
        }
        feature {
            id = "PROJECT_EXT_29"
            type = "OAuthProvider"
            param("secure:userPass", "credentialsJSON:52cecdf4-be91-49ec-822d-f14148b1e46f")
            param("displayName", "Docker Registry")
            param("userName", "sgylxx")
            param("providerType", "Docker")
            param("repositoryUrl", "https://registry.cn-hongkong.aliyuncs.com")
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }

    subProject(GnWorkLoadInquiry.Project)
})
