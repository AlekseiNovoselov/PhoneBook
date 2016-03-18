package ru.mail.park.phonebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mail.park.phonebook.R;

public class SettingsFragment extends Fragment {

    public static SettingsFragment newInstance() {
        SettingsFragment settingsFragment = new SettingsFragment();
        Bundle arguments = new Bundle();
        settingsFragment.setArguments(arguments);
        return settingsFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, null);
        return v;
    }

}
