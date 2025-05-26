package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.expense

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.youverifyfintrackapp.data.model.Expenses
import com.kelviniyalo.youverifyfintrackapp.databinding.ExpensesLayoutItemBinding
import com.kelviniyalo.youverifyfintrackapp.databinding.LayoutTransactionHistoryHeaderItemsBinding

class ExpensesAdapter(
    private val onItemClicked: (itemAtPosition: Expenses) -> Unit
) : ListAdapter<Expenses, RecyclerView.ViewHolder>(object :
    DiffUtil.ItemCallback<Expenses>() {
    override fun areItemsTheSame(
        oldItem: Expenses,
        newItem: Expenses
    ): Boolean {
        return oldItem.tittle == newItem.tittle
    }

    override fun areContentsTheSame(
        oldItem: Expenses,
        newItem: Expenses
    ): Boolean {
        return oldItem == newItem
    }
}) {

    override fun submitList(list: List<Expenses>?) {
        val adapterList: MutableList<Expenses> = mutableListOf()
        val dates = list?.map { it.date }?.distinct()
        dates?.forEach { date ->
            adapterList.add(Expenses(isHeader = true, date = date))
            adapterList.addAll(list.filter { it.date.equals(date) }.toList())
        }
        super.submitList(adapterList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null

        when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding =
                    LayoutTransactionHistoryHeaderItemsBinding.inflate(LayoutInflater.from(parent.context))
                viewHolder = HeaderVH(binding)
            }

            VIEW_TYPE_BANK_ITEM -> {
                val binding = ExpensesLayoutItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                viewHolder = TransactionHistoryVH(binding)
            }
        }
        return viewHolder!!
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].isHeader == true) VIEW_TYPE_HEADER else VIEW_TYPE_BANK_ITEM
    }

    override fun getItemCount(): Int = currentList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemAtPosition = currentList[position]
        if (itemAtPosition.isHeader == true) {
            (holder as HeaderVH).bind(itemAtPosition.date.toString())
        } else {
            (holder as TransactionHistoryVH).bind(itemAtPosition)
        }
    }


    inner class TransactionHistoryVH(
        private val binding: ExpensesLayoutItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(transactions: Expenses) {
            with(binding) {
                root.setOnClickListener {
                    onItemClicked.invoke(transactions)
                }
                title.text = transactions.tittle
                amount.text = transactions.amount
                image.setImageResource(transactions.bgImage!!)

            }
        }
    }

    inner class HeaderVH(private val binding: LayoutTransactionHistoryHeaderItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(date: String) {
            binding.headerDate.text = date
        }
    }


    companion object {
        var VIEW_TYPE_BANK_ITEM = 0
        var VIEW_TYPE_HEADER = 1

    }

}