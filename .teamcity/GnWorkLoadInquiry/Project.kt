package GnWorkLoadInquiry

import GnWorkLoadInquiry.buildTypes.*
import GnWorkLoadInquiry.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("GnWorkLoadInquiry")
    name = "GN.WorkLoad.Inquiry"

    vcsRoot(GnWorkLoadInquiryVcs)

    buildType(GnWorkLoadInquiryBuild)
})
