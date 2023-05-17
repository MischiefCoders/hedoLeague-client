package com.hedoleague

import com.hedoleague.data.TablesDataSource
import com.hedoleague.data.TablesRepositoryImpl
import com.hedoleague.data.network.TablesApi
import com.hedoleague.data.network.TablesRemoteDataSource
import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.qualifier.named
import org.koin.dsl.module

expect class SharedEngine {
    fun getTables(): Flow<List<RankInfo>>
}

val module = module {
    single<TablesRepository> {
        TablesRepositoryImpl(
            get(qualifier = named("remote"))
        )
    }
    factory<TablesDataSource>(named("remote")) { TablesRemoteDataSource(get()) }
    factory { TablesApi() }
}