package com.sidpug.siddharth_pugalia.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.sidpug.siddharth_pugalia.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}