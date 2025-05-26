package com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentAccountBinding


class AccountFragment : Fragment(R.layout.fragment_account) {
    private lateinit var binding: FragmentAccountBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountBinding.bind(view)

    }
}