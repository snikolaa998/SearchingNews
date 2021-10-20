package com.example.searchingnews.repository

import com.example.searchingnews.api.RetrofitInstance
import com.example.searchingnews.db.ArticleDatabase
import com.example.searchingnews.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(query: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(query, pageNumber)

    suspend fun upsert(article: Article) =
            db.getArticleDao().upsertArticle(article)

    suspend fun deleteArticle(article: Article) =
            db.getArticleDao().deleteArticle(article)

    fun getAllArticles() = db.getArticleDao().getAllArticles()
}