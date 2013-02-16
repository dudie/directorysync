package fr.dudie.directorysync.activity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import fr.dudie.directorysync.R;
import fr.dudie.directorysync.service.FileExplorerServiceMock;

@EActivity(R.layout.act_remote_file_list)
public class RemoteFileList extends FragmentActivity {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteFileList.class);

    @Bean
    protected FileExplorerServiceMock fileExplorer;

    @ViewById(R.id.loading)
    protected View loadingView;

    @ViewById(R.id.remote_files)
    protected ListView fileList;

    private FileListAdapter fileListAdapter;

    @AfterViews
    protected void setup() {
        fileListAdapter = new FileListAdapter(this);
        fileList.setOnItemClickListener(new OnFileListItemClick(this));
        fileList.setAdapter(fileListAdapter);
        loadRemoteFiles();
    }

    @Background
    protected void loadRemoteFiles() {
        LOGGER.debug("load remote files.start");

        final List<String> files = fileExplorer.list();
        fileListAdapter.setFiles(files);
        hideLoad();

        LOGGER.debug("load remote files.end");
    }

    @UiThread
    protected void hideLoad() {
        fileListAdapter.notifyDataSetChanged();
        loadingView.setVisibility(View.GONE);
        fileList.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.act_remote_file_list, menu);
        return true;
    }

    private static class OnFileListItemClick implements OnItemClickListener {
        
        private final Context context;
        public OnFileListItemClick(Context context) {
            this.context=context;
        }

        @Override
        public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
            final Intent i = new Intent(context, CustomizeSyncActivity_.class);
            context.startActivity(i);
        }

    }

    private static class FileListAdapter extends BaseAdapter {

        private static class FileViewHolder {

            TextView filename;
        }

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
        public View getView(int position, View v, ViewGroup parent) {
            
            final FileViewHolder holder;
            
            if (null == v) {
                v = LayoutInflater.from(context).inflate(R.layout.li_file, null);
                holder = new FileViewHolder();
                holder.filename = (TextView) v.findViewById(R.id.li_file_name);
                v.setTag(holder);
            } else {
                holder = (FileViewHolder) v.getTag();
            }

            holder.filename.setText(files.get(position));

            return v;
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
