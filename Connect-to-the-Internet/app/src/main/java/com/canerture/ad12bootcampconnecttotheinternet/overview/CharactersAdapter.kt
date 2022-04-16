package com.canerture.ad12bootcampconnecttotheinternet.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.canerture.ad12bootcampconnecttotheinternet.databinding.CharacterItemDesignBinding
import com.canerture.ad12bootcampconnecttotheinternet.network.CharacterModel

class CharactersAdapter :
    ListAdapter<CharacterModel, CharactersAdapter.CharactersViewHolder>(DiffCallBack) {

    var onClick: (CharacterModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            CharacterItemDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character, onClick)
    }

    class CharactersViewHolder(private val binding: CharacterItemDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterModel, onClick: (CharacterModel) -> Unit = {}) {
            binding.characterModel = character
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                onClick(character)
            }
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<CharacterModel>() {

        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }
    }
}