package com.kelviniyalo.youverifyfintrackapp.presentation.auth.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.youverifyfintrackapp.data.model.OnboardingItems
import com.kelviniyalo.youverifyfintrackapp.databinding.ViewpageLayoutItemBinding

class OnboardingAdapter(
    private val items: List<OnboardingItems>
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(private val binding: ViewpageLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OnboardingItems) {
            binding.headerTitle.text = item.title
            binding.body.text = item.body
             binding.image.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ViewpageLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnboardingViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position])
    }
}