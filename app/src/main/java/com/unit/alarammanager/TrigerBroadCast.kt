package com.unit.alarammanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings

class TrigerBroadCast : BroadcastReceiver() {
    var mediaPlayer = MediaPlayer()

    override fun onReceive(context: Context, intent: Intent) {
        mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_NOTIFICATION_URI)
        mediaPlayer.start()

    }
}