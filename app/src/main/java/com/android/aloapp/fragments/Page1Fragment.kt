package com.android.aloapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.android.aloapp.R
import com.android.aloapp.adapters.GameListAdapter
import com.android.aloapp.api.models.response.GameBean
import com.android.aloapp.databinding.Page1Binding
import com.android.aloapp.utils.BaseFragment
import com.android.aloapp.viewModels.GameListViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class Page1Fragment : BaseFragment() {

    private lateinit var gameListViewModel: GameListViewModel
    private var games = mutableListOf<GameBean>()
    private lateinit var gamesAdapter: RecyclerView.Adapter<*>
    private lateinit var binding: Page1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.page1, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameListViewModel = ViewModelProviders.of(this).get(GameListViewModel::class.java)
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this)

        initGamesAdapter()
        getData()
    }

    private fun getData() {
        gameListViewModel.getLiveGamesData(context!!).observe(this, Observer {
            if (games.isNullOrEmpty()) {
                games.addAll(it)
                binding.gameLisRecycler.adapter!!.notifyDataSetChanged()
            }
        })
    }

    private fun initGamesAdapter() {
        gamesAdapter = GameListAdapter(games)
        binding.gameLisRecycler.adapter = gamesAdapter
        binding.gameLisRecycler.adapter!!.notifyDataSetChanged()
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun gameClicked(game: GameBean) {
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
