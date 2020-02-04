package com.android.aloapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.aloapp.api.models.response.GameBean
import com.android.aloapp.databinding.ItemGamesBinding
import org.greenrobot.eventbus.EventBus


class GameListAdapter(private var games: List<GameBean>) :
    RecyclerView.Adapter<GameListAdapter.GamesViewHolder>() {
    init {
        setHasStableIds(true)
    }

    inner class GamesViewHolder(
        private val binding: ItemGamesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GameBean) {
            binding.data = item
            binding.rate.rating = item.rate.toFloat()
            binding.playersCount.text = item.playerCount.toString()
            binding.game.setOnClickListener { EventBus.getDefault().post(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGamesBinding.inflate(inflater)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
    override fun getItemViewType(position: Int): Int = position
    override fun getItemId(position: Int): Long = games[position].id.toLong()

}