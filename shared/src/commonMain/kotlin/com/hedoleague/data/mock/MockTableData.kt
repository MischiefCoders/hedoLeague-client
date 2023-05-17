package com.hedoleague.data.mock

import com.hedoleague.data.network.response.TablesResponse
import com.hedoleague.domain.data.RankInfo
import com.hedoleague.domain.data.Team

class MockTableData {
    companion object {
        val response = TablesResponse(
            200,
            "OK",
            listOf(
                RankInfo(
                    1,
                    Team(
                        65,
                        "Manchester CITY FC",
                        "Man City",
                        "MCI",
                        "https://crests.football-data.org/65.png"
                    ),
                    37,
                    28,
                    6,
                    3,
                    90,
                    96,
                    24,
                    72
                ),
                RankInfo(
                    2,
                    Team(
                        64,
                        "Liverpool FC",
                        "Liverpool",
                        "LIV",
                        "https://crests.football-data.org/64.png"
                    ),
                    36,
                    26,
                    8,
                    2,
                    86,
                    89,
                    24,
                    65
                ),
                RankInfo(
                    3,
                    Team(
                        61,
                        "Chelsea FC",
                        "Chelsea",
                        "CHE",
                        "https://crests.football-data.org/61.png"
                    ),
                    36,
                    20,
                    10,
                    6,
                    70,
                    73,
                    31,
                    42
                )
            )
        )
    }
}