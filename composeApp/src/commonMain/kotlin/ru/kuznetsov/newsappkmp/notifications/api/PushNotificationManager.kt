package ru.kuznetsov.newsappkmp.notifications.api

import ru.kuznetsov.newsappkmp.notifications.data.NotificationPayload
import ru.kuznetsov.newsappkmp.notifications.data.PushNotificationResult

interface PushNotificationManager {
    suspend fun registerForPushNotifications(): PushNotificationResult
    suspend fun unregisterForPushNotifications()
    suspend fun getToken(): PushNotificationResult
    fun setNotificationHandler(handler: (NotificationPayload) -> Unit)
}