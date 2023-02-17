package com.example.retrofitwithcoroutines.Network

import com.example.retrofitwithcoroutines.Model.Post
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPost() : List<Post>
}