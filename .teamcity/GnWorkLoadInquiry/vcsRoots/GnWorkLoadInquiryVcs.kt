package GnWorkLoadInquiry.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object GnWorkLoadInquiryVcs : GitVcsRoot({
    name = "http://teamcity@172.16.8.80:8080/r/jinxiaoxian/GN.WorkLoad.Inquiry.git#refs/heads/dev"
    url = "http://teamcity@172.16.8.80:8080/r/jinxiaoxian/GN.WorkLoad.Inquiry.git"
    branch = "refs/heads/dev"
    authMethod = password {
        userName = "teamcity"
        password = "1q2w3e4R"
    }
})
