package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.budget

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.Budgets
import com.kelviniyalo.youverifyfintrackapp.databinding.BudgetLayoutItemBinding

class BudgetsAdapter(
    private val onItemClicked: (itemAtPosition: Budgets) -> Unit
) : ListAdapter<Budgets, BudgetsAdapter.TransactionTypeVH>(object :
    DiffUtil.ItemCallback<Budgets>() {
    override fun areItemsTheSame(
        oldItem: Budgets,
        newItem: Budgets
    ): Boolean {
        return oldItem.isDefault == newItem.isDefault
    }

    override fun areContentsTheSame(
        oldItem: Budgets,
        newItem: Budgets
    ): Boolean {
        return oldItem == newItem
    }
}) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionTypeVH {
        val binding = BudgetLayoutItemBinding.inflate(
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
        private val binding: BudgetLayoutItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(transactions: Budgets) {
            with(binding) {
                cardView.setOnClickListener {
                    onItemClicked.invoke(transactions)
                }
                title.text = transactions.tittle
                balance.text = transactions.balance
                amountSpent.text = transactions.amountSpent
                totalBudgetAmount.text = transactions.budgetAmount
                date.text = transactions.date
                actionBtn.text = if (transactions.isDefault) "Default" else "Set as Default"
                actionBtn.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        binding.root.context,
                        if (transactions.isDefault) R.color.fintrack_green_light else R.color.fintrack_green
                    )
                )
                actionBtn.setTextColor(binding.root.context.getColor(if (transactions.isDefault) R.color.fintrack_green else R.color.white))


            }
        }
    }

}