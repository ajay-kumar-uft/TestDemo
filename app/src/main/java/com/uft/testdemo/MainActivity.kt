package com.uft.testdemo

import android.os.Bundle
import android.util.Base64
import androidx.appcompat.app.AppCompatActivity
//import com.contourdocumentimaging.sdk.contour_rc.callbacks.IContourResultListener
//import com.contourdocumentimaging.sdk.contour_rc.modules.RCContour
//import com.contourdocumentimaging.sdk.contour_rc.modules.base.model.EnvironmentType
//import com.contourdocumentimaging.sdk.contour_rc.modules.base.model.RCContourModel
import com.document.android.contours.DocScan

//import com.document.android.contours.DocScan

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DocScan.init()
//        val contoursModel = ContoursModel()
//        val contourModel = RCContourModel()
//        val set = HashSet<String>()
//        set.add("test4")
//        set.add("test5")
//        contourModel.accountList = set
//        contourModel.clientId = "cyclops"
//        contourModel.token = generateToken()
//
//        RCContour.launchSdk(this, contourModel, object: IContourResultListener {
//            override fun onSDKClosed() {
//
//            }
//        })

//        val contourModel = RCContourModel()
//        contourModel.clientId = "rocket"
//        contourModel.token = ""
//        contourModel.environmentType = EnvironmentType.QA
//        contourModel.environmentId = ""
//        contourModel.isLocationEnabled = false
//        RCContour.launchSdk(this, contourModel, object: IContourResultListener {
//            override fun onSDKClosed() {
//
//            }
//        })
    }
    private fun generateToken(): String {
        val credentials = "ashish.uft:Test@123"
        return "Basic "+ Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
    }
}
