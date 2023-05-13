package com.hedoleague.data.network

import com.hedoleague.data.TablesDataSource
import com.hedoleague.domain.data.RankInfo

class TablesRemoteDataSource(
    private val tablesApi: TablesApi
): TablesDataSource {
    override suspend fun getTables(): List<RankInfo> {
        return tablesApi.getTables().table
    }
}