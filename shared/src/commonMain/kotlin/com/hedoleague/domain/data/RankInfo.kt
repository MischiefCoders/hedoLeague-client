package com.hedoleague.domain.data

data class RankInfo(
    val position: Int,
    val team: Team,
    val playGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int
)