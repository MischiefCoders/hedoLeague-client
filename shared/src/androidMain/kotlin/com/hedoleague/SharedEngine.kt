package com.hedoleague

import android.content.Context
import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.koinApplication
import org.koin.dsl.module

actual class SharedEngine(appContext: Context) {
    private val repository: TablesRepository
    init {
        val koinApp = koinApplication { module }.modules(module { single { appContext } })
        repository = koinApp.koin.get()
    }
    actual fun getTables(): Flow<List<RankInfo>> {
        return repository.getTables()
    }
}