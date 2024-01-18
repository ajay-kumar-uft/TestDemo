package com.uft.testdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.document.android.contours.DocScan

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DocScan().init()
    }
}
