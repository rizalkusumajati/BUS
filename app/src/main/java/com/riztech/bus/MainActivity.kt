package com.riztech.bus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riztech.bus.presentation.scan.DialogResult

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDialog(title: String, desc: String, listener: DialogResult.OnClickDialogButton){
        DialogResult(title, desc, listener)
            .show(supportFragmentManager, DialogResult.TAG)
    }

    
}