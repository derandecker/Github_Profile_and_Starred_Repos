package com.derandecker.githubprofileandstarredrepos.starredrepos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.derandecker.githubprofileandstarredrepos.databinding.RepoItemBinding
import com.derandecker.githubprofileandstarredrepos.model.StarredRepo

class StarredReposRecyclerViewAdapter (val clickListener: StarredRepoListener) : androidx.recyclerview.widget.ListAdapter<StarredRepo,
        StarredReposRecyclerViewAdapter.ReposViewHolder>(StarredRepoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    class ReposViewHolder private constructor(val binding: RepoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: StarredRepoListener, item: StarredRepo) {
            binding.starredrepo = item
            binding.clickListener = clickListener
        }
        companion object {
            fun from(parent: ViewGroup): ReposViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RepoItemBinding.inflate(layoutInflater, parent, false)

                return ReposViewHolder(binding)
            }
        }
    }
}

class StarredRepoDiffCallback : DiffUtil.ItemCallback<StarredRepo>() {
    override fun areItemsTheSame(oldItem: StarredRepo, newItem: StarredRepo): Boolean {
        return oldItem.full_name == newItem.full_name
    }

    override fun areContentsTheSame(oldItem: StarredRepo, newItem: StarredRepo): Boolean {
        return oldItem == newItem
    }

}

class StarredRepoListener(val clickListener: (starredrepo: StarredRepo) -> Unit) {
    fun onClick(starredrepo: StarredRepo) = clickListener(starredrepo)
}


