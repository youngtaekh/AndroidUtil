package kr.young.androidutil

import android.net.ConnectivityManager
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.young.common.NetworkListener
import kr.young.common.NetworkUtil
import kr.young.common.UtilLog

class MainActivity : AppCompatActivity() {

    private lateinit var networkUtil: NetworkUtil

    private val listener = object: NetworkListener {
        override fun onDisconnected(network: Network) {
            UtilLog.i(TAG, "onDisconnected")
        }

        override fun onConnected(connectivityManager: ConnectivityManager?, network: Network) {
            UtilLog.i(TAG, "onConnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UtilLog.i(TAG, "onCreate")

        networkUtil = NetworkUtil(this, listener)
    }

    override fun onResume() {
        super.onResume()
        UtilLog.i(TAG, "onResume")

        networkUtil.register()
    }

    override fun onPause() {
        super.onPause()
        UtilLog.i(TAG, "onPause")

        networkUtil.unregister()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}