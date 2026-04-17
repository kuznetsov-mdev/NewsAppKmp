package ru.kuznetsov.newsappkmp.notifications

import ru.kuznetsov.newsappkmp.notifications.api.PlatformNotifier
import ru.kuznetsov.newsappkmp.notifications.api.PushNotificationManager
import ru.kuznetsov.newsappkmp.notifications.data.NotificationPayload
import ru.kuznetsov.newsappkmp.notifications.data.PushNotificationResult

class NotificationManagerImpl(
    private val platformNotifier: PlatformNotifier
) : PushNotificationManager {

    private var notificationHandler: ((NotificationPayload) -> Unit)? = null

    override suspend fun registerForPushNotifications(): PushNotificationResult {
        return try {
            PushNotificationResult.Success(platformNotifier.register())
        } catch (e: Exception) {
            PushNotificationResult.Failure(e)
        }
    }

    override suspend fun unregisterForPushNotifications() {
        platformNotifier.unregister()
    }

    override suspend fun getToken(): PushNotificationResult {
        return try {
            PushNotificationResult.Success(platformNotifier.getToken())
        } catch (e: Exception) {
            PushNotificationResult.Failure(e)
        }
    }

    override fun setNotificationHandler(handler: (NotificationPayload) -> Unit) {
        notificationHandler = handler
    }

    fun handleNotification(payload: NotificationPayload) {
        notificationHandler?.invoke(payload)
    }
}