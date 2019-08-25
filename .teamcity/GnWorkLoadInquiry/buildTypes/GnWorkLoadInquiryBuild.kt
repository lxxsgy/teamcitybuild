package GnWorkLoadInquiry.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.helmDelete
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.helmInstall
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object GnWorkLoadInquiryBuild : BuildType({
    name = "Build GnWorkLoadInquiry"

    vcs {
        root(GnWorkLoadInquiry.vcsRoots.GnWorkLoadInquiryVcs)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = path {
                    path = "/GN.WorkLoad.Inquiry/Dockerfile"
                }
                contextDir = "/"
                namesAndTags = "registry.cn-beijing.aliyuncs.com/lxxsgy/gnworkloadinquiry:1.0.%build.counter%"
                commandArgs = "--pull"
            }
            param("dockerImage.platform", "linux")
        }
        dockerCommand {
            commandType = push {
                namesAndTags = "registry.cn-beijing.aliyuncs.com/lxxsgy/gnworkloadinquiry:1.0.%build.counter%"
            }
        }
        helmDelete {
            name = "delete gnworkloadinquiry"
            release = "gnworkloadinquiry"
            additionalFlags = "--purge"
            param("teamcity.helm.command", "helm-delete")
        }
        helmInstall {
            name = "install gnworkloadinquiry"
            chart = "GN.WorkLoad.Inquiry/charts/workloadinquiry"
            additionalFlags = "--name gnworkloadinquiry --set image.tag=1.0.%build.counter%"
            param("teamcity.helm.command", "helm-install")
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        dockerSupport {
            loginToRegistry = on {
                dockerRegistryId = "PROJECT_EXT_29"
            }
        }
    }
})
