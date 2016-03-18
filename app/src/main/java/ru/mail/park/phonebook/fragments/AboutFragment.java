package ru.mail.park.phonebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mail.park.phonebook.R;

public class AboutFragment extends Fragment {

    public static AboutFragment newInstance() {
        AboutFragment aboutFragment = new AboutFragment();
        Bundle arguments = new Bundle();
        aboutFragment.setArguments(arguments);
        return aboutFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, null);
        return v;
    }
}
