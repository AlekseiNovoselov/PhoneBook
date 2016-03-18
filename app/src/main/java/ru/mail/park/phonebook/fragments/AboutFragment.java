package ru.mail.park.phonebook.fragments;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mail.park.phonebook.R;

public class AboutFragment extends Fragment {

    public static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";

    CustomTabsClient mClient;
    CustomTabsSession mCustomTabsSession;
    CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsIntent customTabsIntent;

    private static final String URL_NOVOSELOV_PARK_DIPLOMA = "https://park.mail.ru/alumni/11/417/";

    public static AboutFragment newInstance() {
        AboutFragment aboutFragment = new AboutFragment();
        Bundle arguments = new Bundle();
        aboutFragment.setArguments(arguments);
        return aboutFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            Setup Chrome Custom Tabs
         */
        mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {

                //Pre-warming
                mClient = customTabsClient;

                /* Such We can save up to 700 ms by opening a link with the Custom Tabs
                    by connecting to the service and pre-loading Chrome.
                    The loading happens as a low priority process,
                    meaning that it won’t have any negative performance impact on your application,
                    but will give a big performance boost when loading a link.
                */

                mClient.warmup(0L);
                //Initialize a session as soon as possible.
                mCustomTabsSession = mClient.newSession(null);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mClient = null;
            }
        };

        CustomTabsClient.bindCustomTabsService(getActivity(), CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);

        customTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setToolbarColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary))
                .setShowTitle(true)
                 // TODO - добавить анимации
                //.setStartAnimations(getContext(), R.anim.slide_in_right, R.anim.slide_in_left)
                .build();
        /*
            End custom tabs setup
         */

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, null);
        TextView aboutTextView = (TextView) v.findViewById(R.id.about_text_view);
        Spanned aboutText = Html.fromHtml(getString(R.string.about_text));
        aboutTextView.setText(aboutText);

        TextView tvLink = (TextView) v.findViewById(R.id.profile_link);
        Spanned tvLinkText = Html.fromHtml(getString(R.string.profile_link_text));
        tvLink.setText(tvLinkText);
        //tvLink.setMovementMethod(LinkMovementMethod.getInstance());

        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // http://blog.grafixartist.com/google-chrome-custom-tabs-android-tutorial/
                // Fallback? No problem!
                // The good news is, we just need to worry about launching the Chrome Custom Tab.
                // The support library takes care of the fallback for us.
                // Which means, if the user doesn’t have Chrome, it will load the same in a WebView. Neat!

                customTabsIntent.launchUrl(getActivity(), Uri.parse(URL_NOVOSELOV_PARK_DIPLOMA));
            }
        });

        return v;
    }
}
