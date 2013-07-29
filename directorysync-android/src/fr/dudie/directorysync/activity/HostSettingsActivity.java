package fr.dudie.directorysync.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.googlecode.androidannotations.annotations.EActivity;

import fr.dudie.directorysync.R;

@EActivity
public class HostSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        addPreferencesFromResource(R.xml.pref_host);

    }
}
