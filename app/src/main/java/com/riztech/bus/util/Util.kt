package com.riztech.bus.util

import androidx.fragment.app.Fragment
import com.riztech.bus.MainActivity
import com.riztech.bus.presentation.scan.DialogResult

fun Fragment.showDialogResult(title:String, desc:String, listener: DialogResult.OnClickDialogButton) = (requireActivity() as MainActivity).showDialog(title, desc, listener)