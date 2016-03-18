package ru.mail.park.phonebook.utils;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import ru.mail.park.phonebook.MainActivity;
import ru.mail.park.phonebook.R;
import ru.mail.park.phonebook.fragments.AboutFragment;
import ru.mail.park.phonebook.fragments.ContactsFragment;
import ru.mail.park.phonebook.fragments.SettingsFragment;

public class MyFragmentManager {

    private MainActivity activity;
    private Toolbar toolbar = null;

    public MyFragmentManager(MainActivity activity, Toolbar toolbar) {
        this.activity = activity;
        this.toolbar = toolbar;
    }

    public void addContactsFragment() {

        //toolbar.setTitle(R.string.action_achievements);
        FragmentTransaction fTran = activity.getSupportFragmentManager().beginTransaction();
        ContactsFragment contactsFragment = ContactsFragment.newInstance();
        fTran.replace(R.id.mainLayout, contactsFragment);
        fTran.commit();
    }

    public void addSettingsFragment() {
        FragmentTransaction fTran = activity.getSupportFragmentManager().beginTransaction();
        SettingsFragment settingsFragment = SettingsFragment.newInstance();
        fTran.replace(R.id.mainLayout, settingsFragment);
        fTran.commit();
    }

    public void addAboutFragment() {
        FragmentTransaction fTran = activity.getSupportFragmentManager().beginTransaction();
        AboutFragment aboutFragment = AboutFragment.newInstance();
        fTran.replace(R.id.mainLayout, aboutFragment);
        fTran.commit();
    }
}
