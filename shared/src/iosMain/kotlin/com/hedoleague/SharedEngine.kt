package com.hedoleague

import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository
import com.hedoleague.utils.CFlow
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.koinApplication

actual class SharedEngine() {
    private val repository: TablesRepository
    init {
        val koinApp =
            koinApplication { modules(tablesModule) }
        repository = koinApp.koin.get()
    }

    actual fun getTables(): Flow<List<RankInfo>> = CFlow(repository.getTables())
}