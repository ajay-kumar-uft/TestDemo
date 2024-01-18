package com.document.android.contours.util

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class Utility {

    companion object {

        fun getSize(): String {
            return "50MB"
        }

        fun deviceType(context: Context): String {
            return if(isTablet(context)) {
                "Tablet"
            } else {
                "Phone"
            }
        }
        private fun isTablet(context: Context): Boolean {
            val xlarge = context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK === 4
            val large = context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK === Configuration.SCREENLAYOUT_SIZE_LARGE
            return xlarge || large
        }

        fun convertDpToPixel(dp: Int): Int {
            val metrics = Resources.getSystem().displayMetrics
            val px = dp * (metrics.densityDpi / 160f)
            return Math.round(px)
        }

        fun roundDecimal(d: Float): Double {
            return Math.round(d * 100.0)/100.0
        }

        fun roundDecimal(d: Double): Double {
            return Math.round(d * 100.0)/100.0
        }

        fun loadValueFromResource(context: Context, id: Int): Double {
            val typedValue = TypedValue()
            context.resources.getValue(id, typedValue, true)
            return roundDecimal(typedValue.float)
        }

        /**
         * calculating the openCV box percentage with compare to image resolution.
         */
        public fun calculatePercentage(value:Double, minValue:Double): Double{
            val v = minValue / value
            return v * 100.0
        }

        /**
         * calculating the values of layer with openCV percentage
         */
        public fun calculateValueInPercentage(value:Double, percentageVal:Double): Double{
            val v = value * percentageVal
            return v / 100.0
        }

        /**
         * This method is responsible for vibrating device. This method will be called when
         * haptic feedback is given to the user.
         * @param activity Activity instance.
         */
        fun vibrateDevice(activity: Activity, vibrateTime: Long = 200) {

        }

        /**
         * To check color is valid or not
         */
        fun isColorValid(color: Int): Boolean {
            return (color in 0..255)
        }

        fun changeCTAButtonBackgroundColor(ctaButton: View?, colorId: Int) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    ctaButton?.background?.colorFilter = BlendModeColorFilter(ContextCompat.getColor(ctaButton!!.context, colorId), BlendMode.SRC_ATOP)
                } else {
                    ctaButton?.background?.setColorFilter(ContextCompat.getColor(ctaButton.context, colorId), PorterDuff.Mode.SRC_ATOP)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun millisecondToSecond(millisecond: Long): Int {
            return (millisecond/1000).toInt()
        }

        fun getCurrentTimeStamp(): Long {
            return Date().time
        }

        fun getDateAndTime(): String {
            val df: DateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm", Locale.getDefault())
            return df.format(Calendar.getInstance().time)
        }

        fun deleteFileIfExist(context: Context, fileName: String) {
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                file.delete()
            }
        }

        /**
         * Deletes the file if exists
         */
        fun deleteFileIfExist(file: File) {
            if (file.exists()) {
                file.delete()
            }
        }

        private fun getMinimumSupportedOpenCVVersion(): String {
            return "4.5.0"
        }
    }
}