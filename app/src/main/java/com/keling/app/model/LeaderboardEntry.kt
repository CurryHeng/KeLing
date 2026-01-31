package com.keling.app.model

data class LeaderboardEntry(
    val userId: String,
    val displayName: String,
    val avatarUrl: String? = null,
    val score: Int
)