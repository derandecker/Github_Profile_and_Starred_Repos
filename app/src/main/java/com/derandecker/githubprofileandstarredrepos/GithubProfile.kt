package com.derandecker.githubprofileandstarredrepos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubProfile constructor(
    @PrimaryKey
    val id: Long,
    val login: String,
    val name: String,
    val bio: String,
    val avatarUrl: String,

)