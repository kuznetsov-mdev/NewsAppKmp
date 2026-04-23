package ru.kuznetsov.newsappkmp

import android.app.Application
import com.google.firebase.FirebaseApp
import ru.kuznetsov.newsappkmp.notification.api.PlatformNotifierAndroid
import ru.kuznetsov.newsappkmp.notifications.NotificationManagerImpl

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        val notificationManager = NotificationManagerImpl(
            PlatformNotifierAndroid()
        )

        notificationManager.setNotificationHandler { payload ->
            //handle notification here
        }
    }
}