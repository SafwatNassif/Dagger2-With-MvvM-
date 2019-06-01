package com.example.mvvmjsonplaceholder.network

import com.example.mvvmjsonplaceholder.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPostList(): Single<List<Post>>

}