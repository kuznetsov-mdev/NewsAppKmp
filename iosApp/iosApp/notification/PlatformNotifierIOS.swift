import Foundation
import UIKit
import UserNotifications
import ComposeApp

public class PlatformNotifierIOS: NSObject, PlatformNotifier {
    private var deviceToken: String = ""

    public func register(completionHandler: @escaping (String?, Error?) -> Void) {
        UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .sound, .badge]) { granted, error in
            if let error = error {
                completionHandler(nil, error)
                return
            }

            guard granted else {
                completionHandler(nil, NSError(domain: "Notifications", code: 1))
                return
            }

            DispatchQueue.main.async {
                UIApplication.shared.registerForRemoteNotifications()
            }

            completionHandler("", nil)
        }
    }

    public func unregister(completionHandler: @escaping (Error?) -> Void) {
        UNUserNotificationCenter.current().removeAllDeliveredNotifications()
        completionHandler(nil)
    }

    public func getToken() -> String {
        return deviceToken
    }

    public func setDeviceToken(_ token: String) {
        self.deviceToken = token
    }
}