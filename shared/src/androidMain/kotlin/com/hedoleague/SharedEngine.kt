package com.hedoleague

import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository
import kotlinx.coroutines.flow.Flow

actual class SharedEngine(
    val repository: TablesRepository
) {
    actual fun getTables(): Flow<List<RankInfo>> {
        return repository.getTables()
    }
}