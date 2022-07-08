package kr.young.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Handler

class NetworkUtil(
    context: Context,
    private val listener: NetworkListener
): ConnectivityManager.NetworkCallback() {

    private var networkRequest: NetworkRequest? = null
    private var connectivityManager: ConnectivityManager? = null
    private var network: Network? = null

    init {
        networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    fun register() {
        connectivityManager!!.registerNetworkCallback(networkRequest!!, this)
    }

    fun unregister() {
        connectivityManager!!.unregisterNetworkCallback(this)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        this.network = network

        this.listener.onDisconnected(network)
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        this.network = network

        this.listener.onConnected(connectivityManager, this.network!!)
    }

//    fun getActiveType(context: Context) {
//        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        var isWifiConn: Boolean = false
//        var isMobileConn: Boolean = false
//        connMgr.allNetworks.forEach { network ->
//            connMgr.getNetworkInfo(network)?.apply {
//                if (type == ConnectivityManager.TYPE_WIFI) {
//                    isWifiConn = isWifiConn or isConnected
//                }
//                if (type == ConnectivityManager.TYPE_MOBILE) {
//                    isMobileConn = isMobileConn or isConnected
//                }
//            }
//        }
//    }

    companion object {
        private const val TAG = "NetworkUtil"
    }
}