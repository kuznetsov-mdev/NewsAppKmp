import Foundation
import UIKit
import ComposeApp

class AppDelegate: UIResponder, UIApplicationDelegate {

    var platformNotifier = PlatformNotifierIOS()
    var notificationManager: NotificationManagerImpl?

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {

        notificationManager = NotificationManagerImpl(platformNotifier: platformNotifier)

        notificationManager?.setNotificationHandler { payload in
            print("Получен push: \(payload.title)")
        }

        return true
    }

    func application(_ application: UIApplication,
                     didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {

        let tokenParts = deviceToken.map { data in
            String(format: "%02.2hhx", data)
        }
        let token = tokenParts.joined()

        print("Device Token: \(token)")

        platformNotifier.setDeviceToken(token)
    }

    func application(_ application: UIApplication,
                     didReceiveRemoteNotification userInfo: [AnyHashable: Any]) {

        let payload = NotificationPayload(
            title: userInfo["title"] as? String ?? "",
            body: userInfo["body"] as? String ?? "",
            data: userInfo as? [String: String] ?? [:]
        )

        notificationManager?.handleNotification(payload: payload)
    }
}