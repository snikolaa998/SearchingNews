package com.example.searchingnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.searchingnews.R
import com.example.searchingnews.db.ArticleDatabase
import com.example.searchingnews.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val db = ArticleDatabase(this)
        val newsRepo = NewsRepository(db)
        val viewModelFactory = NewsViewModelProviderFactory(newsRepo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        //Povezivanje navigacije sa menijem
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}