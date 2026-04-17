package ru.kuznetsov.newsappkmp.notifications.data

data class NotificationPayload(
    val title: String,
    val body: String,
    val data: Map<String, String>
) {
}