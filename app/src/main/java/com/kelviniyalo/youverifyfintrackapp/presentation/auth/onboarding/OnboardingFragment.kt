package com.kelviniyalo.youverifyfintrackapp.presentation.auth.onboarding

import android.graphics.Path.Direction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.data.model.onBoardingItemsList
import com.kelviniyalo.youverifyfintrackapp.databinding.FragmentOnboardingBinding
import com.kelviniyalo.youverifyfintrackapp.presentation.auth.register.RegistrationFragmentDirections
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {
    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var onboardingAdapter: OnboardingAdapter
    private var autoScrollJob: Job? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboardingBinding.bind(view)
        val items = onBoardingItemsList
        setupIndicators(items.size)

        binding.continueButton.setOnClickListener { bottomSheetManager() }
        binding.viewpager.apply {
            onboardingAdapter = OnboardingAdapter(items)
            adapter = onboardingAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicator(position)
                }
            })
        }

        binding.alternateAccount.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(findNavController().graph.startDestinationId, inclusive = true)
                .build()
            val directions =
                OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            findNavController().navigate(directions, navOptions)
        }
    }

    private fun setupIndicators(count: Int) {
        val indicators = arrayOfNulls<ImageView>(count)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(16, 0, 16, 0)
        }

        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext()).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.inactive_indicator
                    )
                )
                this.layoutParams = layoutParams
            }
            binding.indicatorLayout.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorLayout.getChildAt(i) as ImageView
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    if (i == index) R.drawable.active_indicator else R.drawable.inactive_indicator
                )
            )
        }
    }


    private fun startAutoScroll(viewPager: ViewPager2, itemCount: Int) {
        autoScrollJob = lifecycleScope.launch {
            var page = 0
            while (isActive) {
                delay(3000L)
                if (page == itemCount) page = 0
                viewPager.setCurrentItem(page++, true)
            }
        }
    }

    private fun stopAutoScroll() {
        autoScrollJob?.cancel()
    }

    private fun bottomSheetManager() {
        TermsAndConditionBottomDialog(onContinueClicked = {
            val direction =
                OnboardingFragmentDirections.actionOnboardingFragmentToRegistrationFragment()
            findNavController().navigate(direction)
        }).show(childFragmentManager, tag)
    }


    override fun onResume() {
        super.onResume()
        startAutoScroll(binding.viewpager, onBoardingItemsList.size)
    }

    override fun onPause() {
        super.onPause()
        stopAutoScroll()
    }
}