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

version = "2019.1"

project {

    vcsRoot(HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster)

    buildType(Build)

    features {
        feature {
            id = "PROJECT_EXT_2"
            type = "OAuthProvider"
            param("secure:userPass", "zxxdf7b65d123ae6d20914e1d33e972a338")
            param("displayName", "Docker Registry")
            param("userName", "sgylxx")
            param("providerType", "Docker")
            param("repositoryUrl", "https://registry.cn-hongkong.aliyuncs.com")
        }
    }
}

object Build : BuildType({
    name = "Build"

    publishArtifacts = PublishMode.SUCCESSFUL

    vcs {
        root(HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster)
    }

    steps {
        step {
            name = "bulid by Docker"
            type = "DockerCommand"
            param("dockerfile.path", "dockerfile")
            param("docker.image.namesAndTags", "172.16.6.178:5000/cpihcfataskservice:1.0.%build.counter%")
            param("command.args", "--pull")
        }
        step {
            name = "Docker push"
            type = "DockerCommand"
            param("docker.command.type", "push")
            param("docker.image.namesAndTags", "172.16.6.178:5000/cpihcfataskservice:1.0.%build.counter%")
        }
        step {
            name = "helm delete"
            type = "jetbrains.helm"
            enabled = false
            param("helm-deleteteamcity.helm.additionalFlags", "--purge")
            param("teamcity.helm.command", "helm-delete")
            param("helm-deleteteamcity.helm.releaseName", "cpihcfataskservice")
        }
        step {
            name = "helm install cpihcfataskservice"
            type = "jetbrains.helm"
            param("helm-installteamcity.helm.additionalFlags", "--name taskservice -f CPI.Hcfa.TaskService/charts/cpihcfataskservice --set image.tag=1.0.%build.counter%")
            param("helm-installteamcity.helm.chart", "CPI.Hcfa.TaskService/charts/cpihcfataskservice")
            param("teamcity.helm.command", "helm-install")
        }
    }

    triggers {
        trigger {
            type = "vcsTrigger"
        }
    }

    features {
        feature {
            type = "DockerSupport"
            param("loginCheckbox", "on")
            param("login2registry", "PROJECT_EXT_2")
        }
    }
})

object HttpsGithubComLxxsgyCpiHcfaTaskServiceGitRefsHeadsMaster : VcsRoot({
    type = "jetbrains.git"
    name = "https://github.com/lxxsgy/CPI.Hcfa.TaskService.git#refs/heads/master"
    param("secure:password", "zxxdf7b65d123ae6d20914e1d33e972a338")
    param("authMethod", "PASSWORD")
    param("url", "https://github.com/lxxsgy/CPI.Hcfa.TaskService.git")
    param("username", "lxxsgy")
})
