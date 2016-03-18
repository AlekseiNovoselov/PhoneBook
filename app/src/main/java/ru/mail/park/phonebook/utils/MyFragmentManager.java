package ru.mail.park.phonebook.utils;

import android.support.v4.app.Fragment;
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

    private Screen currentScreen = Screen.CONTACTS;

    public enum Screen {
        CONTACTS, SETTINGS, ABOUT
    }

    public MyFragmentManager(MainActivity activity, Toolbar toolbar) {
        this.activity = activity;
        this.toolbar = toolbar;
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public void addFragment(Screen value) {
        currentScreen = value;
        switch (currentScreen) {
            case CONTACTS:
                // TODO при первом отображении на toolbar "Phonebook" вместо "Контакты"
                addFragment(R.string.toolbar_contacts_item, ContactsFragment.newInstance(), Screen.CONTACTS);
                break;
            case SETTINGS:
                addFragment(R.string.toolbar_settings_item, SettingsFragment.newInstance(), Screen.SETTINGS);
                break;
            case ABOUT:
                addFragment(R.string.toolbar_about_item, AboutFragment.newInstance(), Screen.ABOUT);
                break;
            default:
                addFragment(R.string.toolbar_contacts_item, ContactsFragment.newInstance(), Screen.CONTACTS);
        }
    }

    private void addFragment(int title, Fragment fragment, Screen screen) {
        toolbar.setTitle(title);
        FragmentTransaction fTran = activity.getSupportFragmentManager().beginTransaction();
        fTran.replace(R.id.mainLayout, fragment);
        fTran.commit();
        currentScreen = screen;
    }
}
