package GnWorkLoadInquiry.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object GnWorkLoadInquiryVcs : GitVcsRoot({
<<<<<<< HEAD
    name = "https://github.com/lxxsgy//GN.WorkLoad.Inquiry.git#refs/heads/master"
    url = "https://github.com/lxxsgy//GN.WorkLoad.Inquiry.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "lxxsgy"
        password = "sgylxx520"
=======
    name = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry/#refs/heads/master"
    url = "https://github.com/lxxsgy/GN.WorkLoad.Inquiry.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "lxxsgy"
        password = "credentialsJSON:f47a1892-d19f-4134-bfef-0c8c796290c0"
>>>>>>> eaf0f698f11d076b2e02671941204d4c598427e0
    }
})
