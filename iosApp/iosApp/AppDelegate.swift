//
//  AppDelegate.swift
//  iosApp
//
//  Created by Gurpreet Singh on 06/02/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import UIKit
import ComposeApp

class AppDelegate : NSObject, UIApplicationDelegate {
    func application(
        _ application: UIApplication,
        didFinishLaunchWithOptionslaunchOptions:[UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
            
            #if DEBUG
                LoggingUtils.initialize()
            #endif
        return true
    }
}
