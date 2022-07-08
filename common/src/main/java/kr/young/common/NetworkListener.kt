package kr.young.common

import android.net.ConnectivityManager
import android.net.Network

interface NetworkListener {
    fun onDisconnected(network: Network)
    fun onConnected(connectivityManager: ConnectivityManager?, network: Network)
}