package com.hedoleague.data.network.response

import com.hedoleague.domain.data.RankInfo

data class TablesResponse(
    val code: Int,
    val message: String,
    val table: List<RankInfo>
)