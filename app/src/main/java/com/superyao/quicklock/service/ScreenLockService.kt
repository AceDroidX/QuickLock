package com.superyao.quicklock.service

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
import android.view.accessibility.AccessibilityEvent

class ScreenLockService : AccessibilityService() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (!performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)) {
            startActivity(Intent(ACTION_ACCESSIBILITY_SETTINGS)
                    .addFlags(Intent.FLAG_RECEIVER_FOREGROUND))
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // No-op
    }

    override fun onInterrupt() {
        // No-op
    }

    companion object {
        fun start(context: Context) {
            context.startService(Intent(context, ScreenLockService::class.java))
        }
    }
}