package com.amirdaryabak.mvvmnewsapp.repository

import com.amirdaryabak.mvvmnewsapp.api.RetrofitInstance
import com.amirdaryabak.mvvmnewsapp.db.ArticleDataBase
import com.amirdaryabak.mvvmnewsapp.models.Article

class NewsRepository(
    val db: ArticleDataBase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}