package com.derandecker.githubprofileandstarredrepos.model



data class IndividualStarredRepo constructor(
    val full_name: String,
    val description: String? = "",
    val stargazers_count: Int,
    val owner: RepoOwner,
    val watchers_count: Int,
    val forks_count: Int,

    )

data class RepoOwner constructor(
    val login: String,
    val avatar_url: String,
)
