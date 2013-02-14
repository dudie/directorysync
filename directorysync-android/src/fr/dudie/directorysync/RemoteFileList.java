package fr.dudie.directorysync;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import fr.dudie.directorysync.service.FileExplorerServiceMock;

@EActivity(R.layout.act_remote_file_list)
public class RemoteFileList extends FragmentActivity {

    @Bean
    protected FileExplorerServiceMock fileExplorer;

    @ViewById(R.id.remote_files)
    protected ListView remoteFilesList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

        onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(final Bundle savedInstanceState) {
       loadRemoteFiles();
    }

    @Background
    protected void loadRemoteFiles() {
        showLoad();
        fileExplorer.list();
        hideLoad();
    }

    @UiThread
    protected void hideLoad() {
        // TODO Auto-generated method stub
        
    }

    @UiThread
    protected void showLoad() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_remote_file_list, menu);
        return true;
    }

}
