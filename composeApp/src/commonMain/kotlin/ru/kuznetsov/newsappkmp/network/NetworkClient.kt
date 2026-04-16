package ru.kuznetsov.newsappkmp.network

import ru.kuznetsov.newsappkmp.data.NewsItemsList

class NetworkClient constructor(
    private val networkConfiguration: NetworkConfiguration
) {

    fun loadData(): NewsItemsList? {
        return null
    }
}