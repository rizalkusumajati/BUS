package com.riztech.bus.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.riztech.bus.R
import kotlinx.android.synthetic.main.custom_dialog.*

class DialogResult(val title: String, val desc: String, val listener: OnClickDialogButton) : DialogFragment() {

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String, listener: OnClickDialogButton): DialogResult {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = DialogResult(title, subTitle, listener)
            fragment.arguments = args
            return fragment
        }

    }
    interface OnClickDialogButton{
        fun onClickScan()
        fun onClickHome()
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCancelable(false)
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvTitle.setText(title)
        tvDesc.setText(desc)

        btnScan.setOnClickListener {
            listener.onClickScan()
            dismiss()
        }

        btnHome.setOnClickListener {
            listener.onClickHome()
            dismiss()
        }
    }
}