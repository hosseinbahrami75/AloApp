package com.android.aloapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aloapp.R
import kotlinx.android.synthetic.main.page2.*


class FakePage2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fake_page2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext.setOnClickListener {
            val fakePage3 = FakePage3()
            activity!!.supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.activity_fade_in,
                    R.anim.activity_fade_out,
                    R.anim.activity_fade_in,
                    R.anim.activity_fade_out
                )
                .replace(R.id.frame_layout, fakePage3)
                .addToBackStack(null)
                .commit()
        }
    }


}
