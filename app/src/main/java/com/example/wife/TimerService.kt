package com.example.wife

import android.app.*
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.Duration

class TimerService : Service() {

    private val channelId = "wife_timer"

    private val d1 = LocalDateTime.of(2025, 3, 19, 0, 0)
    private val d2 = LocalDateTime.of(2021, 10, 3, 0, 0)
    private val d3 = LocalDateTime.of(2024, 4, 3, 0, 0)

    override fun onCreate() {
        super.onCreate()
        createChannel()
        startForeground(1, notification())
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun notification(): Notification {
        val now = LocalDateTime.now(ZoneId.systemDefault())

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("WIFE Timer Running")
            .setContentText("Tracking elapsed time")
            .setSmallIcon(android.R.drawable.ic_popup_sync)
            .build()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val ch = NotificationChannel(
                channelId,
                "WIFE Monitor",
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java).createNotificationChannel(ch)
        }
    }
}
