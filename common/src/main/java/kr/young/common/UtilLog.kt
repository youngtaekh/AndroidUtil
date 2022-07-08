package kr.young.common

import android.util.Log

class UtilLog {
    companion object {
        @JvmStatic var isModuleTAG = false
        private const val MODULE_TAG = "UtilLog"
        @JvmStatic
        fun v(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                if (isModuleTAG) {
                    Log.v(MODULE_TAG, message)
                } else {
                    Log.v(tag, message)
                }
            }
        }

        @JvmStatic
        fun d(tag: String, message:String) {
            if (BuildConfig.DEBUG) {
                if (isModuleTAG) {
                    Log.d(MODULE_TAG, message)
                } else {
                    Log.d(tag, message)
                }
            }
        }

        @JvmStatic
        fun i(tag: String, message:String) {
            if (BuildConfig.DEBUG) {
                if (isModuleTAG) {
                    Log.i(MODULE_TAG, message)
                } else {
                    Log.i(tag, message)
                }
            }
        }

        @JvmStatic
        fun w(tag: String, message:String) {
            if (BuildConfig.DEBUG) {
                if (isModuleTAG) {
                    Log.w(MODULE_TAG, message)
                } else {
                    Log.w(tag, message)
                }
            }
        }

        @JvmStatic
        fun e(tag: String, message:String) {
            if (BuildConfig.DEBUG) {
                if (isModuleTAG) {
                    Log.e(MODULE_TAG, message)
                } else {
                    Log.e(tag, message)
                }
            }
        }
    }
}