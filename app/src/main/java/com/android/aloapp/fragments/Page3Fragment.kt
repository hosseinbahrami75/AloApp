package com.android.aloapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aloapp.R
import kotlinx.android.synthetic.main.page3.*


class Page3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page3, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext.setOnClickListener {
            val fakePage1 = FakePage1()
            activity!!.supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.activity_fade_in,
                    R.anim.activity_fade_out,
                    R.anim.activity_fade_in,
                    R.anim.activity_fade_out
                )
                .replace(R.id.frame_layout, fakePage1)
                .addToBackStack(null)
                .commit()
        }
    }


}
