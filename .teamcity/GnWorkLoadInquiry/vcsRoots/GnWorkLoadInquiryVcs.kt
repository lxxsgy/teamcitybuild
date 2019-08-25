package GnWorkLoadInquiry.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object GnWorkLoadInquiryVcs : GitVcsRoot({
    name = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry/#refs/heads/master"
    url = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry.git"
    authMethod = password {
        userName = "lxxsgy"
        password = "credentialsJSON:f47a1892-d19f-4134-bfef-0c8c796290c0"
    }
})
