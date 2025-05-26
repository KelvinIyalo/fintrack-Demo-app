package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.expense

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.expensesItemList
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentExpenseBinding


class ExpenseFragment : Fragment(R.layout.fragment_expense) {
    private lateinit var binding: FragmentExpenseBinding
    private lateinit var expensesAdapter: ExpensesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExpenseBinding.bind(view)
        setUpAdapter()
        expensesAdapter.submitList(expensesItemList)

    }

    private fun setUpAdapter() {
        expensesAdapter = ExpensesAdapter(onItemClicked = {

        })

        binding.expenseRv.apply {
            adapter = expensesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }
}