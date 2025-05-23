package com.kelviniyalo.youverifyfintrackapp.presentation.auth.otp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentOtpVerificationBinding
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentRegistrationBinding
import com.kelviniyalo.youverifyfintrackapp.presentation.dashboard.host.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class OtpVerificationFragment : Fragment(R.layout.fragment_otp_verification) {
    private lateinit var binding: FragmentOtpVerificationBinding
    private val args: OtpVerificationFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOtpVerificationBinding.bind(view)
        binding.continueButton.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }

        binding.body1.text = getString(
            R.string.otp_message,
            args.email
        )
        startCountdown()
    }

    private fun startCountdown() {
        lifecycleScope.launch {
            binding.otpTimer.apply {
                for (time in 60 downTo 0) {
                    text = context.getString(R.string.resend_code_in_s, time.toString())
                    binding.otpTimer.setTextColor(requireContext().getColor(R.color.fintrack_blue))
                    delay(1000L)
                }
                text = context.getString(R.string.resend_code)
                setTextColor(requireContext().getColor(R.color.fintrack_green))
                setOnClickListener { startCountdown() }
            }

        }
    }
}