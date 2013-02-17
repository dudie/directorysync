package fr.dudie.directorysync.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.ViewById;

import fr.dudie.directorysync.R;
import fr.dudie.directorysync.service.model.RemoteFile;

@EActivity(R.layout.act_customize_sync)
public class CustomizeSyncActivity extends FragmentActivity {

    public static Intent intent(Context context, RemoteFile file) {
        final Intent i = new Intent(context, CustomizeSyncActivity_.class);
        i.putExtra("file", file);
        return i;
    }

    @ViewById(R.id.act_customize_sync_filename)
    protected TextView filenameView;

    @Extra
    protected RemoteFile file;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @AfterViews
    protected void setup() {
        filenameView.setText(file.getName());
    }
}
