package com.hedoleague.data

import com.hedoleague.domain.data.RankInfo

interface TablesDataSource {
    suspend fun getTables(): List<RankInfo>
}