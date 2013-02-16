package fr.dudie.directorysync.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import fr.dudie.directorysync.R;

@EActivity(R.layout.act_customize_sync)
public class CustomizeSyncActivity extends FragmentActivity {

    private static final String INTENT_EXTRA_FILENAME = "filename";

    public static Intent intent(Context context, String filename) {
        final Intent i = new Intent(context, CustomizeSyncActivity_.class);
        i.putExtra(INTENT_EXTRA_FILENAME, filename);
        return i;
    }

    @ViewById(R.id.act_customize_sync_filename)
    protected TextView filenameView;

    private String filename;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        filename = getIntent().getStringExtra(INTENT_EXTRA_FILENAME);
    }

    @AfterViews
    protected void setup() {
        filenameView.setText(filename);
    }
}
