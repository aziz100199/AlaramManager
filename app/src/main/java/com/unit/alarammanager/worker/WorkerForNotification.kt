package com.unit.alarammanager.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.unit.alarammanager.BaseApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkerForNotification(val context: Context, params: WorkerParameters) :
    Worker(context, params) {
    override fun doWork(): Result {
        CoroutineScope(Dispatchers.IO).launch {
            val repository = (context as BaseApplication).mainActivity
            repository.alramManager()
        }
        return Result.success()


    }
}