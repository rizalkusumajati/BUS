package com.riztech.bus.presentation.scan

import android.Manifest
import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.ResultPoint
import com.google.zxing.client.android.BeepManager
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.riztech.bus.R
import com.riztech.bus.util.showDialogResult
import kotlinx.android.synthetic.main.fragment_scan.*

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [ScanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScanFragment : Fragment(),
    DialogResult.OnClickDialogButton {
    lateinit var beepManager: BeepManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val callback: BarcodeCallback = object : BarcodeCallback {
        override fun barcodeResult(result: BarcodeResult) {
            zxingBarcodeScanner.pause()
            beepManager.playBeepSoundAndVibrate()
            Log.d("RESULT", result.text)

            showDialogResult("Success", "description success : ${result.text}", this@ScanFragment)
//            val action = ScannerFragmentDirections.goToDetail(result.text)
//            findNavController().navigate(action)
//            Handler().post(Runnable { returnResult(result) })
        }

        override fun possibleResultPoints(resultPoints: List<ResultPoint>) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        beepManager = BeepManager(requireActivity())

        zxingBarcodeScanner.initializeFromIntent(Intent())
        zxingBarcodeScanner.decodeSingle(callback)

        val color = Color.argb(100, 0, 0,0)
        zxingBarcodeScanner.viewFinder.setMaskColor(color)
    }


    override fun onResume() {
        if (Build.VERSION.SDK_INT >= 23) {
            openCameraWithPermission()
        } else {
            zxingBarcodeScanner.resume()
        }
        super.onResume()
    }

    override fun onPause() {
        zxingBarcodeScanner.pauseAndWait()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private var askedPermission = false

    @TargetApi(23)
    private fun openCameraWithPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            zxingBarcodeScanner.resume()
        } else if (!askedPermission) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.CAMERA),
                250
            )
            askedPermission = true
        } // else wait for permission result
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 250) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted
                zxingBarcodeScanner.resume()
            } else {
//                setMissingCameraPermissionResult()
//                if (showDialogIfMissingCameraPermission) {
//                    displayFrameworkBugMessageAndExit(missingCameraPermissionDialogMessage)
//                } else {
//                    closeAndFinish()
//                }
            }
        }
    }

    override fun onClickScan() {

    }

    override fun onClickHome() {

    }
}