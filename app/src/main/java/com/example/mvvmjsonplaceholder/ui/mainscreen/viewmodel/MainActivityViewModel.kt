package com.example.mvvmjsonplaceholder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmjsonplaceholder.model.Post
import com.example.mvvmjsonplaceholder.repository.MainActivityRepository
import io.reactivex.internal.disposables.DisposableContainer
import javax.inject.Inject

class MainActivityViewModel @Inject
constructor(private val repository: MainActivityRepository) : ViewModel() {

    var postList = MutableLiveData<List<Post>>()
    var errorMsg = MutableLiveData<Throwable>()

    fun loadPostList() {
        repository.loadPostList({
            postList.postValue(it)
        }, {
            errorMsg.value = it
        })
    }


    override fun onCleared() {
        super.onCleared()

    }
}