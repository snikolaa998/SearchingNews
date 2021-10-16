package com.example.searchingnews.repository

import com.example.searchingnews.api.RetrofitInstance
import com.example.searchingnews.db.ArticleDatabase

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}