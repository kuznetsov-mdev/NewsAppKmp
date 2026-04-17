package ru.kuznetsov.newsappkmp.notifications.api

interface PlatformNotifier {
    suspend fun register(): String
    suspend fun unregister()
    fun getToken(): String
}