package com.kelviniyalo.youverifyfintrackapp.presentation.auth.onboarding

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelviniyalo.youverifyfintrackapp.R
import com.kelviniyalo.youverifyfintrackapp.databinding.LayoutTermsAndConditionBottomDialogBinding

class TermsAndConditionBottomDialog(private val onContinueClicked: () -> Unit) :
    BottomSheetDialogFragment(R.layout.layout_terms_and_condition_bottom_dialog) {

    private lateinit var binding: LayoutTermsAndConditionBottomDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LayoutTermsAndConditionBottomDialogBinding.bind(view)
        dialog?.setContentView(binding.root)
        dialog?.setCancelable(false)

        with(binding) {
            cancelBtn.setOnClickListener { dismiss() }
            continueButton.setOnClickListener {
                onContinueClicked.invoke()
                dismiss()
            }
        }


    }


}