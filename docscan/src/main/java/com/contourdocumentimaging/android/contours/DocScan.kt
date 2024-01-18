package com.contourdocumentimaging.android.contours

import com.contourdocumentimaging.android.contours.a.Scan
import com.contourdocumentimaging.android.contours.b.CaptureHelper
import com.contourdocumentimaging.android.contours.c.CScanHelper
import com.contourdocumentimaging.android.contours.d.DScanHelper
import com.contourdocumentimaging.android.contours.scan.ScanHelper
import com.contourdocumentimaging.android.contours.util.CheckCaptureHelper
import com.contourdocumentimaging.android.contours.util.ContoursPreference

class DocScan {

    companion object {
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

}