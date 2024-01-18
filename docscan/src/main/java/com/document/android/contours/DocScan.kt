package com.document.android.contours

import com.document.android.contours.a.Scan
import com.document.android.contours.b.CaptureHelper
import com.document.android.contours.c.CScanHelper
import com.document.android.contours.d.DScanHelper
import com.document.android.contours.scan.ScanHelper
import com.document.android.contours.util.CheckCaptureHelper
import com.document.android.contours.util.ContoursPreference

class DocScan {

    fun init() {
        val isGood = CheckCaptureHelper().isGood
        ScanHelper().isGood
        Scan().isGood
        CaptureHelper().isGood
        CScanHelper().isGood
        DScanHelper().isGood
        ContoursPreference.Companion.VERSION_NO
        ContoursStarterActivity().start()
        ContoursCryptoUtils().start()
    }

}