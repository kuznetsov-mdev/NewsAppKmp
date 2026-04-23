package ru.kuznetsov.newsappkmp.notification.api

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import ru.kuznetsov.newsappkmp.notifications.api.PlatformNotifier

class PlatformNotifierAndroid constructor() : PlatformNotifier {

    private val firebaseMessaging = FirebaseMessaging.getInstance()

    override suspend fun register(): String {
        return firebaseMessaging.token.await()
    }

    override suspend fun unregister() {
        firebaseMessaging.deleteToken()
    }

    override fun getToken(): String {
        return firebaseMessaging.token.toString()
    }
}