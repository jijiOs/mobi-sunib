package com.example.voter2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ItemAdapter (
    private val items: List<Item>,
    private val listener: HomeActivity
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    interface OnItemClickListener {

        fun onItemClicked()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        Glide.with(holder.itemView.context)
            .load(currentItem.value)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.imageVote)
        holder.nameVote.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageVote: ImageView = itemView.findViewById(R.id.imageVote)
        val nameVote: TextView = itemView.findViewById(R.id.nameVote)

        init {
            itemView.setOnClickListener {
                listener.onItemClicked()
            }
        }
    }
}