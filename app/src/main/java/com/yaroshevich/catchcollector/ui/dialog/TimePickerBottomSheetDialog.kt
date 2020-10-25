package com.yaroshevich.catchcollector.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yaroshevich.catchcollector.R


class TimePickerBottomSheetDialog : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = BottomSheetDialog(requireContext(), theme)

        dialog.setOnShowListener {
            val bottomSheet: FrameLayout? =
                dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)

            if (null != bottomSheet) {
                val behavior: BottomSheetBehavior<*> =
                    BottomSheetBehavior.from(bottomSheet)
                behavior.isHideable = false
            }
        }

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_time_picker, container, false)
    }
}


