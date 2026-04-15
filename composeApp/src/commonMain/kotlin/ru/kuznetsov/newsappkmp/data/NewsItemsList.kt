package ru.kuznetsov.newsappkmp.data

data class NewsItemsList(
    val totalResults: Int,
    val articles: List<NewsItem>
)
