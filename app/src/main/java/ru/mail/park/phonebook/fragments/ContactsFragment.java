package ru.mail.park.phonebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mail.park.phonebook.R;

public class ContactsFragment extends Fragment {

    public static ContactsFragment newInstance() {
        ContactsFragment contactsFragment = new ContactsFragment();
        Bundle arguments = new Bundle();
        contactsFragment.setArguments(arguments);
        return contactsFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, null);
        return v;
    }
}
