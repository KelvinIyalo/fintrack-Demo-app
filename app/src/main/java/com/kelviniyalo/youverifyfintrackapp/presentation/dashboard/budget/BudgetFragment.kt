package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.budget

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.budgetItemList
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentBudgetBinding

class BudgetFragment : Fragment(R.layout.fragment_budget) {
  lateinit var binding: FragmentBudgetBinding
    private lateinit var budgetsAdapter: BudgetsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBudgetBinding.bind(view)
        setUpAdapter()
        budgetsAdapter.submitList(budgetItemList)

    }

    private fun setUpAdapter() {
        budgetsAdapter = BudgetsAdapter(onItemClicked = {

        })

        binding.budgetRv.apply {
            adapter = budgetsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }
}