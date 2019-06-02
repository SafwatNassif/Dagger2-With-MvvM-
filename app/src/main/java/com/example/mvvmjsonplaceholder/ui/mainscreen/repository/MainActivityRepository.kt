package com.example.mvvmjsonplaceholder.repository

import com.example.mvvmjsonplaceholder.model.Post
import com.example.mvvmjsonplaceholder.network.PostApi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivityRepository @Inject
constructor(private val retrofit: Retrofit) {

    fun loadPostList(onSuccess: (List<Post>) -> Unit, onError: (Throwable) -> Unit) {
        val request = retrofit.create(PostApi::class.java).getPostList()

        request.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Post>> {
                override fun onSuccess(t: List<Post>) {
                    onSuccess(t)
                }

                override fun onSubscribe(d: Disposable) {
                    //pass
                }

                override fun onError(e: Throwable) {
                    onError(e)
                }
            })
    }
}