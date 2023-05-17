package com.hedoleague.domain.repository

import com.hedoleague.domain.data.RankInfo
import kotlinx.coroutines.flow.Flow

interface TablesRepository {
    fun getTables(): Flow<List<RankInfo>>
}