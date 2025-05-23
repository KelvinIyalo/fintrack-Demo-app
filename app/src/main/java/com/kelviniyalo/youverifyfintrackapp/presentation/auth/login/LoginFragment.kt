package com.kelviniyalo.youverifyfintrackapp.presentation.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentLoginBinding
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentOtpVerificationBinding
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentRegistrationBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.continueButton.setOnClickListener {
        val directions = LoginFragmentDirections.actionLoginFragmentToOtpVerificationFragment(binding.emailEt.text.toString())
            findNavController().navigate(directions)
        }

        binding.alternateAccount.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(findNavController().graph.startDestinationId, inclusive = true)
                .build()
            val directions = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            findNavController().navigate(directions,navOptions)
        }
    }

}