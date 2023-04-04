package com.weiran.graphql.common

import java.util.*

data class LogResponse(
    var teamId: Int? = null,
    var pickGroup: String = "",
    var time: Date = Date()
)
