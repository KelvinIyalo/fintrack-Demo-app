package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.savings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.savingsItemList
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentSavingsBinding


class SavingsFragment : Fragment(R.layout.fragment_savings) {
    private lateinit var binding: FragmentSavingsBinding
    private lateinit var savingsAdapter: SavingsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavingsBinding.bind(view)
        setUpAdapter()
        savingsAdapter.submitList(savingsItemList)

    }

    private fun setUpAdapter() {
        savingsAdapter = SavingsAdapter(onItemClicked = {

        })

        binding.savingsRv.apply {
            adapter = savingsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

}