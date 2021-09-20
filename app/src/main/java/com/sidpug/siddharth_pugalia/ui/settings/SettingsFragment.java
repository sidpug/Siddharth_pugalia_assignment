package com.sidpug.siddharth_pugalia.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.sidpug.siddharth_pugalia.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ListPreference mListPreference = (ListPreference) getPreferenceManager().findPreference("preference_key");
        assert mListPreference != null;
        mListPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            // your code here
            return true;
        });

        return inflater.inflate(R.layout.fragment_about, container, false);
    }
}
