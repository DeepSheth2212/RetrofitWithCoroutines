package com.example.retrofitwithcoroutines.Repository

import com.example.retrofitwithcoroutines.Model.Post
import com.example.retrofitwithcoroutines.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost() : List<Post> = RetrofitBuilder.api.getPost()
}