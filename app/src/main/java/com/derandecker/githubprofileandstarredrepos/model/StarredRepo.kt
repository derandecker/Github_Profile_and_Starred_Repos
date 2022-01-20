package com.derandecker.githubprofileandstarredrepos.model


data class StarredRepo constructor(
    val full_name: String,
//    val description: String,
// GITHUB RETURNS NULL FOR BLANK DESCRIPTIONS AND
// THIS IS CAUSING MOSHI TO THROW AN ERROR
// WRITE SOME CODE TO HELP MOSHI DEAL WITH NULL DESCRIPTIONS

    )