package com.derandecker.githubprofileandstarredrepos.network

import com.derandecker.githubprofileandstarredrepos.model.GithubProfile
import com.derandecker.githubprofileandstarredrepos.model.IndividualStarredRepo
import com.derandecker.githubprofileandstarredrepos.model.StarredRepo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.github.com"

interface NetworkGithubService {
    @GET("users/{usernamePath}")
    suspend fun getUserProfile(@Path("usernamePath") username: String): GithubProfile

    @GET("users/{gitHubUsername}/starred")
    suspend fun getStarredRepos(@Path("gitHubUsername") username: String): List<StarredRepo>

    @GET("repos/{owner}/{name}")
    suspend fun getIndividualStarredRepo(
        @Path("owner") owner: String,
        @Path("name") name: String
    ): IndividualStarredRepo

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object Network {
    private val client = OkHttpClient.Builder()
        .build()

    private val retrofitProfile = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    val profile: NetworkGithubService = retrofitProfile.create(NetworkGithubService::class.java)
}