package com.derandecker.githubprofileandstarredrepos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubProfile constructor(
    @PrimaryKey
    val id: Long,
    val login: String,
    val name: String? = "",
    val bio: String? = "",
    val avatar_url: String? = "",

    )