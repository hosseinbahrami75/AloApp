package com.android.aloapp.utils

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //CheckInternet
    protected fun inNetworkConnected(): Boolean {
        return CheckNetwork.isNetworkAvailable(context!!)
    }

    protected fun showLongToast(message: String) {
        Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
    }

    protected fun showShortToast(message: String) {
        Toast.makeText(context!!, message, Toast.LENGTH_SHORT).show()
    }
}
