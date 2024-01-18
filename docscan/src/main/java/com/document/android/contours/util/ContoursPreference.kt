package com.document.android.contours.util

import android.content.Context
import android.content.SharedPreferences

class ContoursPreference private constructor(context: Context) {

    private val CONTOURS_PREFERENCES = "ContoursPreference"
    private var sharedPreferences: SharedPreferences? = null

    fun shouldShowIntroScreen(screenNameKey: String): Boolean {
        return sharedPreferences!!.getBoolean(screenNameKey, true)
    }

    fun setIntroScreenVisibility(screenNameKey: String, value: Boolean? = true) {
        sharedPreferences!!.edit().putBoolean(screenNameKey, value?:true).apply()
    }

    fun setAESKey(hex: String) {
        sharedPreferences!!.edit().putString(AES_KEY, hex).apply()
    }

    fun getAESKey(): String {
        return sharedPreferences!!.getString(AES_KEY, "") ?: ""
    }

    fun setDeviceId(deviceId: String) {
        sharedPreferences!!.edit().putString(DEVICE_ID, deviceId).apply()
    }

    fun getDeviceId(): String {
        return sharedPreferences!!.getString(DEVICE_ID, "") ?: ""
    }

    fun setVersionNo(versionNo: String) {
        sharedPreferences!!.edit().putString(VERSION_NO, versionNo).apply()
    }

    fun getVersionNo(): String {
        return sharedPreferences!!.getString(VERSION_NO, "") ?: ""
    }

    fun setCountOfflineValidation(count: Int) {
        sharedPreferences!!.edit().putInt(COUNT_OFFLINE_VALIDATION, count).apply()
    }

    fun getCountOfflineValidation(): Int {
        return sharedPreferences!!.getInt(COUNT_OFFLINE_VALIDATION, 0) ?: 0
    }

    fun setContentLengthWeightFile(contentLength: Int) {
        sharedPreferences!!.edit().putInt(CONTENT_LENGTH_WEIGHT_FILE, contentLength).apply()
    }

    fun getContentLengthWeightFile(): Int {
        return sharedPreferences!!.getInt(CONTENT_LENGTH_WEIGHT_FILE, 0)
    }

    fun saveDraft(value: String) {
        sharedPreferences!!.edit().putString(DIAGNOSTIC_DATA, value).apply()
    }

    fun clearDraft() {
        sharedPreferences!!.edit().putString(DIAGNOSTIC_DATA, "{}").apply()
    }

    fun getDraftData(): String {
        return sharedPreferences!!.getString(DIAGNOSTIC_DATA, "{}") ?: "{}"
    }

    fun setSdkVersion(versionNo: String) {
        sharedPreferences!!.edit().putString(SDK_VERSION, versionNo).apply()
    }

    fun getSdkVersion(): String {
        return sharedPreferences!!.getString(SDK_VERSION, "") ?: ""
    }

    fun setOSVersion(versionNo: String) {
        sharedPreferences!!.edit().putString(OS_VERSION, versionNo).apply()
    }

    fun getOSVersion(): String {
        return sharedPreferences!!.getString(OS_VERSION, "") ?: ""
    }

    companion object {
        private var preference: ContoursPreference? = null
        val SHOW_TIPS_INTRO_SCREEN = "INTRO_SCREEN_TIPS"
        val SHOW_FOUR_CORNERS_INTRO_SCREEN = "INTRO_SCREEN_FOUR_CORNERS"
        val SHOW_ENDORSE_INTRO_SCREEN = "INTRO_SCREEN_ENDORSE"
        val AES_KEY = "AES_KEY"
        val DEVICE_ID = "DEVICE_ID"
        val VERSION_NO = "VERSION_NO"
        val SDK_VERSION = "SDK_VERSION"
        val OS_VERSION = "OS_VERSION"
        val COUNT_OFFLINE_VALIDATION = "COUNT_OFFLINE_VALIDATION"
        val CONTENT_LENGTH_WEIGHT_FILE = "CONTENT_LENGTH_WEIGHT_FILE"
        val DIAGNOSTIC_DATA = "DIAGNOSTIC_DATA"

        fun getInstance(context: Context): ContoursPreference {
            if (preference == null) {
                preference = ContoursPreference(context)
            }
            return preference!!
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences(CONTOURS_PREFERENCES, Context.MODE_PRIVATE)
    }
}
