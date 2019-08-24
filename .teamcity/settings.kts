import jetbrains.buildServer.configs.kotlin.v2018_2.*

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.2"

project {
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
            id = "PROJECT_EXT_5"
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
}
