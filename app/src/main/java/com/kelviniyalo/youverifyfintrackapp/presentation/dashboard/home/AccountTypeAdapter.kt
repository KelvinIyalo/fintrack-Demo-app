package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.home

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.AccountTypes
import com.kelviniyalo.youverifyfintrackapp.data.model.OnboardingItems
import com.kelviniyalo.youverifyfintrackapp.databinding.HomeLayoutItemBinding

class AccountTypeAdapter(
    private val items: List<AccountTypes>
) : RecyclerView.Adapter<AccountTypeAdapter.AccountTypeViewHolder>() {

    inner class AccountTypeViewHolder(private val binding: HomeLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AccountTypes) {
            with(binding) {
                image.setImageResource(item.bgImage)
                title.text = item.tittle
                message.text = item.message
                actionBtn.text = item.actionMessage
                actionBtn.setTextColor(binding.root.context.getColor(item.bgColor))
                message.setTextColor(binding.root.context.getColor(item.textColor))
                title.setTextColor(binding.root.context.getColor(item.textColor))
                balance.setTextColor(binding.root.context.getColor(item.textColor))
                progressBar.progressTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        binding.root.context,
                        item.progressColor
                    )
                )
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        item.bgColor
                    )
                )
                balance.text = item.balance
                progressBar.visibility = if (item.isProgress) View.VISIBLE else View.INVISIBLE
                actionBtn.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        binding.root.context,
                        item.actionColor
                    )
                )


                val drawables = actionBtn.compoundDrawablesRelative
                val endDrawable = drawables[2]  // drawableEnd is index 2

                endDrawable?.let {
                    val wrappedDrawable = DrawableCompat.wrap(it).mutate()
                    DrawableCompat.setTint(
                        wrappedDrawable,
                        ContextCompat.getColor(binding.root.context, item.bgColor)
                    )
                    actionBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        drawables[0],
                        drawables[1],
                        wrappedDrawable,
                        drawables[3]
                    )
                }

            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountTypeViewHolder {
        val binding = HomeLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AccountTypeViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AccountTypeViewHolder, position: Int) {
        holder.bind(items[position])
    }
}