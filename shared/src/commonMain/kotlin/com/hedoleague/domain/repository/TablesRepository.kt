package com.hedoleague.domain.repository

import com.hedoleague.domain.data.RankInfo

interface TablesRepository {
    suspend fun getTables(): List<RankInfo>
}