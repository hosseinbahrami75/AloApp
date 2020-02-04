package com.android.aloapp.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.aloapp.R
import com.android.aloapp.fragments.Page1Fragment
import com.android.aloapp.fragments.Page2Fragment
import com.android.aloapp.fragments.Page3Fragment
import com.android.aloapp.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigationBottom()
    }

    //Initialize BottomNavigationView with FrameLayout
    private fun initNavigationBottom() {
        navigation.itemIconTintList = null
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page1 -> {
                    replaceFragment(Page1Fragment())
//                    changeFragment(Page1Fragment())
                }
                R.id.page2 -> {
                    replaceFragment(Page2Fragment())
//                    changeFragment(Page2Fragment())
                }
                R.id.page3 -> {
                    replaceFragment(Page3Fragment())
//                    changeFragment(Page3Fragment())
                }
            }
            true
        }
        navigation.selectedItemId = R.id.page1
    }

    private fun replaceFragment(fragment: Fragment) {
        var fragment = fragment
        val tag = fragment.javaClass.simpleName
        val tr = supportFragmentManager.beginTransaction()
        val curFrag = supportFragmentManager.primaryNavigationFragment
        val cacheFrag = supportFragmentManager.findFragmentByTag(tag)
        if (curFrag != null) {
            tr.hide(curFrag)
        }
        if (cacheFrag == null) {
            tr.add(R.id.frame_layout, fragment, tag)
        } else {
            tr.show(cacheFrag)
            fragment = cacheFrag
        }
        tr.setPrimaryNavigationFragment(fragment)
        tr.addToBackStack(tag)
        tr.commit()
    }


}
