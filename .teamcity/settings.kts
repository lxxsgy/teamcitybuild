import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

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

    vcsRoot(HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster)
    }

    steps {
        dockerCommand {
            name = "bulid by Docker"
            commandType = build {
                source = path {
                    path = "Dockerfile"
                }
                namesAndTags = "registry.cn-hongkong.aliyuncs.com/lxxsgy/cpihcfataskservice:1.0.%build.counter%"
                commandArgs = "--pull"
            }
            param("dockerImage.platform", "linux")
        }
        dockerCommand {
            name = "Docker push"
            commandType = push {
                namesAndTags = "registry.cn-hongkong.aliyuncs.com/lxxsgy/cpihcfataskservice:1.0.%build.counter%"
            }
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        dockerSupport {
            loginToRegistry = on {
                dockerRegistryId = "PROJECT_EXT_36"
            }
        }
    }
})

object HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/lxxsgy/CPI.Hcfa.TaskService.git#refs/heads/master"
    url = "https://github.com/lxxsgy/CPI.Hcfa.TaskService.git"
    authMethod = password {
        userName = "lxxsgy"
        password = "credentialsJSON:49409194-1df1-423d-8ed3-c99a86e89c78"
    }
})
