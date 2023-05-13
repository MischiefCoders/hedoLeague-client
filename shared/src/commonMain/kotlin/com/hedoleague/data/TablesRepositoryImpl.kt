package com.hedoleague.data

import com.hedoleague.data.network.TablesRemoteDataSource
import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository

class TablesRepositoryImpl(
    private val remoteDataSource: TablesRemoteDataSource
): TablesRepository {
    override suspend fun getTables(): List<RankInfo> {
        return remoteDataSource.getTables()
    }
}