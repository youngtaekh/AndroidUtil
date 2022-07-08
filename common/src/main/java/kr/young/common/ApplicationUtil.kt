package kr.young.common

import android.app.ActivityManager
import android.content.Context

class ApplicationUtil {
    companion object {
        @JvmStatic
        fun isAppOnForeground(context: Context): Boolean {
            val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val processes = manager.runningAppProcesses?: return false
            val packageName = context.packageName
            for (process in processes) {
                if (process.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                    && process.processName == packageName) {
                    return true
                }
            }
            return false
        }
    }
}