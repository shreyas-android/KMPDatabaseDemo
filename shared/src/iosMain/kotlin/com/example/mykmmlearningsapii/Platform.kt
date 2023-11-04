package com.example.mykmmlearningsapii

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    AccountDatabase
}

actual fun getPlatform(): Platform = IOSPlatform()