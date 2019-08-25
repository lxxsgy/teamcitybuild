package patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the project with id = 'GnWorkLoadInquiry'
accordingly, and delete the patch script.
*/
changeProject(RelativeId("GnWorkLoadInquiry")) {
    features {
        add {
            dockerRegistry {
                id = "PROJECT_EXT_4"
                name = "https://sgylxx@registry.cn-beijing.aliyuncs.com"
                url = "https://sgylxx@registry.cn-beijing.aliyuncs.com"
                userName = "sgylxx"
                password = "credentialsJSON:f47a1892-d19f-4134-bfef-0c8c796290c0"
            }
        }
    }
}
