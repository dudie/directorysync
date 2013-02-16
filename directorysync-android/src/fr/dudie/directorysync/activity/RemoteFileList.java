package fr.dudie.directorysync.activity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import fr.dudie.directorysync.R;
import fr.dudie.directorysync.R.id;
import fr.dudie.directorysync.R.layout;
import fr.dudie.directorysync.R.menu;
import fr.dudie.directorysync.service.FileExplorerServiceMock;

@EActivity(R.layout.act_remote_file_list)
public class RemoteFileList extends FragmentActivity {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteFileList.class);
    
    @Bean
    protected FileExplorerServiceMock fileExplorer;

    @ViewById(R.id.loading)
    protected View loadingView;

    @ViewById(R.id.remote_files)
    protected ListView remoteFilesList;
    
    private FileListAdapter remoteFileListAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @AfterViews
    protected void setup() {
        remoteFileListAdapter = new FileListAdapter(this);
        remoteFilesList.setAdapter(remoteFileListAdapter);
        loadRemoteFiles();
    }

    @Background
    protected void loadRemoteFiles() {
        LOGGER.debug("load remote files.start");
        
        final List<String> files = fileExplorer.list();
        remoteFileListAdapter.setFiles(files);
        hideLoad();

        LOGGER.debug("load remote files.end");
    }

    @UiThread
    protected void hideLoad() {
        remoteFileListAdapter.notifyDataSetChanged();
        loadingView.setVisibility(View.GONE);
        remoteFilesList.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.act_remote_file_list, menu);
        return true;
    }

    private static class FileListAdapter extends BaseAdapter {

        private final Context context;
        private List<String> files;

        public FileListAdapter(Context context) {
            this.context = context;
            this.files = new ArrayList<String>(0);
        }

        public void setFiles(List<String> files) {
            if (null != files) {
                this.files = files;
            } else {
                files = new ArrayList<String>(0);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final LinearLayout line;
            if (null == convertView) {
                line = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.li_file, null);
            } else {
                line = (LinearLayout) convertView;
            }
            final TextView filename = (TextView) line.findViewById(R.id.li_file_name);
            filename.setText(files.get(position));
            return line;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return files.get(position);
        }

        @Override
        public int getCount() {
            return files.size();
        }
    }

}
