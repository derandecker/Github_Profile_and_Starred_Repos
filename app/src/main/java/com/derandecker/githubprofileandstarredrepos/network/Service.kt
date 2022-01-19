package com.derandecker.githubprofileandstarredrepos.network

import com.derandecker.githubprofileandstarredrepos.GithubProfile
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

/*    two more GET functions will be added
      one for starred repos
      one for the individual starred repo
*/

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object Network {
    private val client = OkHttpClient.Builder()
//        .connectTimeout(1, TimeUnit.MINUTES) //debug purposes. Past issues with emulator timing
//        .readTimeout(1, TimeUnit.MINUTES)    //out on network calls.
        .build()

    private val retrofitProfile = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    val profile: NetworkGithubService = retrofitProfile.create(NetworkGithubService::class.java)
}