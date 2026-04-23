import Foundation
import UIKit
import UserNotifications
import ComposeApp

public class PlatformNotifierIOS: NSObject, PlatformNotifier {
    private var deviceToken: String = ""

    public func register() async throws -> String {
        let center = UNUserNotificationCenter.current()
        let granted = try await center.requestAuthorization(options: [.alert, .sound, .badge])
        if !granted {
            throw NSError(domain: "Notifications", code: 1)
        }

        DispatchQueue.main.async {
            UIApplication.shared.registerForRemoteNotifications()
        }
        return deviceToken
    }

    public func unregister() async throws {
        UNUserNotificationCenter.current().removeAllDeliveredNotifications()
    }

    public func getToken() -> String {
        return deviceToken
    }

    public func setDeviceToken(_ token: String) {
        self.deviceToken = token
    }
}