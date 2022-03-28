package com.unit.alarammanager

import android.app.Application
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.unit.alarammanager.worker.WorkerForNotification
import java.util.concurrent.TimeUnit

class BaseApplication : Application() {

    lateinit var mainActivity: MainActivity


    override fun onCreate() {
        super.onCreate()
        workerInstance()

    }

    private fun workerInstance() {
        val workerinstance =
            PeriodicWorkRequestBuilder<WorkerForNotification>(1, TimeUnit.SECONDS).build()
        WorkManager.getInstance(this).enqueue(workerinstance)
    }
}