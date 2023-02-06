package com.example.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.R

class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}