package com.hedoleague.data

import com.hedoleague.data.network.TablesRemoteDataSource
import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.repository.TablesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TablesRepositoryImpl(
    private val remoteDataSource: TablesRemoteDataSource
): TablesRepository {
    override fun getTables(): Flow<List<RankInfo>> {
        return flow {
            emit(remoteDataSource.getTables())
        }
    }
}