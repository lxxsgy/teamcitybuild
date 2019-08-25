package GnWorkLoadInquiry.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object GnWorkLoadInquiryVcs : GitVcsRoot({
    name = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry/#refs/heads/master"
    url = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "lxxsgy"
        password = "sgylxx520"
    }
})
