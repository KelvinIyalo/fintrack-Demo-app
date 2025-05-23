package com.kelviniyalo.youverifyfintrackapp.presentation.auth.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentRegistrationBinding
import com.kelviniyalo.youverifyfintrackapp.presentation.auth.login.LoginFragmentDirections


class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private lateinit var binding: FragmentRegistrationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)
        binding.continueButton.setOnClickListener {
            val direction =
                RegistrationFragmentDirections.actionRegistrationFragmentToOtpVerificationFragment(
                    binding.emailEt.text.toString()
                )
            findNavController().navigate(direction)
        }

        binding.alternateAccount.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(findNavController().graph.startDestinationId, inclusive = true)
                .build()
            val directions =
                RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            findNavController().navigate(directions, navOptions)
        }
    }
}