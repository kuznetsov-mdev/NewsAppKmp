package ru.kuznetsov.newsappkmp.service

import ru.kuznetsov.newsappkmp.network.NetworkClient
import ru.kuznetsov.newsappkmp.storage.Storage

class NewsService constructor(
    private val networkClient: NetworkClient,
    private val storage: Storage
) {
    fun loadData() {
        //Todo: api queries
    }
}