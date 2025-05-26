package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.savings

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.Budgets
import com.kelviniyalo.youverifyfintrackapp.data.model.Savings
import com.kelviniyalo.youverifyfintrackapp.databinding.BudgetLayoutItemBinding
import com.kelviniyalo.youverifyfintrackapp.databinding.SavingsLayoutItemBinding

class SavingsAdapter(
    private val onItemClicked: (itemAtPosition: Savings) -> Unit
) : ListAdapter<Savings, SavingsAdapter.TransactionTypeVH>(object :
    DiffUtil.ItemCallback<Savings>() {
    override fun areItemsTheSame(
        oldItem: Savings,
        newItem: Savings
    ): Boolean {
        return oldItem.totalGoal == newItem.totalGoal
    }

    override fun areContentsTheSame(
        oldItem: Savings,
        newItem: Savings
    ): Boolean {
        return oldItem == newItem
    }
}) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionTypeVH {
        val binding = SavingsLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionTypeVH(binding)
    }

    override fun getItemCount(): Int = currentList.size


    override fun onBindViewHolder(holder: TransactionTypeVH, position: Int) {
        val itemAtPosition = currentList[position]
        holder.bind(itemAtPosition)
    }


    inner class TransactionTypeVH(
        private val binding: SavingsLayoutItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(transactions: Savings) {
            with(binding) {
                cardView.setOnClickListener {
                    onItemClicked.invoke(transactions)
                }
                title.text = transactions.tittle
                savedBalance.text = transactions.savedGoal
                totalBalance.text = transactions.totalGoal
                image.setImageResource(transactions.bgImage)
                progressBar.progress = calculateSavedPercentage(
                    savedBalance = transactions.savedGoal,
                    goalBalance = transactions.totalGoal
                ).toInt()
                percentage.text = buildString {
                    append(
                        calculateSavedPercentage(
                            savedBalance = transactions.savedGoal,
                            goalBalance = transactions.totalGoal
                        ).toInt().toString()
                    )
                    append("%")
                }

            }
        }
    }

    private fun calculateSavedPercentage(savedBalance: String, goalBalance: String): Double {
        fun String.toCleanDouble(): Double {
            // Remove currency symbols, commas, and whitespace
            return this.replace(Regex("[₦,\\s]"), "").toDoubleOrNull() ?: 0.0
        }

        val saved = savedBalance.toCleanDouble()
        val goal = goalBalance.toCleanDouble()

        return if (goal > 0) (saved / goal) * 100 else 0.0
    }
}