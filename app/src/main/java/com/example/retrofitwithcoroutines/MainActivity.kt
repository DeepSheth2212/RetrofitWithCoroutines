package com.example.retrofitwithcoroutines

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithcoroutines.Adapter.PostAdapter
import com.example.retrofitwithcoroutines.Model.Post
import com.example.retrofitwithcoroutines.Repository.PostRepository
import com.example.retrofitwithcoroutines.ViewModel.PostViewModel
import com.example.retrofitwithcoroutines.ViewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView :  RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        postAdapter = PostAdapter(this , ArrayList())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = postAdapter

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this , viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this , Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }
}