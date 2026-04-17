package ru.kuznetsov.newsappkmp.notifications.data

sealed class PushNotificationResult {
    data class Success(val token: String) : PushNotificationResult()
    data class Failure(val error: Throwable) : PushNotificationResult()
}