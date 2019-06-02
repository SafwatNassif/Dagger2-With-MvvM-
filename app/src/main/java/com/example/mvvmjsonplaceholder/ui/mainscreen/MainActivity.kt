package com.example.mvvmjsonplaceholder.ui.mainscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmjsonplaceholder.R
import com.example.mvvmjsonplaceholder.adapter.MainActivityAdapter
import com.example.mvvmjsonplaceholder.base.ViewModelFactory
import com.example.mvvmjsonplaceholder.viewmodel.MainActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    private lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var adapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        mainActivityViewModel = ViewModelProviders.of(this,viewModelFactory)
            .get(MainActivityViewModel::class.java)

        initRecyclerView()
        attachLiveData()
        mainActivityViewModel.loadPostList()

    }

    private fun initRecyclerView() {
        rv_post_list.layoutManager = LinearLayoutManager(this)
        adapter = MainActivityAdapter(arrayListOf())
        rv_post_list.adapter = adapter
    }

    private fun attachLiveData() {
        mainActivityViewModel.postList.observe(this, Observer {
            it.let { adapter.updateList(it) }
        })

        mainActivityViewModel.errorMsg.observe(this, Observer {
            it.let {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }
        })

    }


    override fun onDestroy() {
        super.onDestroy()
        mainActivityViewModel.postList.removeObservers(this)
        mainActivityViewModel.errorMsg.removeObservers(this)
    }

}

