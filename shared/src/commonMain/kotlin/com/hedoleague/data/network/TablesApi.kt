package com.hedoleague.data.network

import com.hedoleague.data.network.response.TablesResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class TablesApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getTables(): TablesResponse {
        // TODO: link 변경 필요
        return httpClient.get("https://api.spacexdata.com/v5/launches").body()
    }
}