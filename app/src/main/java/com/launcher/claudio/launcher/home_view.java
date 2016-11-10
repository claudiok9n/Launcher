package com.launcher.claudio.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.animation;

public class home_view extends AppCompatActivity {
    private PackageManager manager;
    private List<GridHomeDetail> apps;
    private Animation lala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        overridePendingTransition(R.anim.right_out, R.anim.right_out);
        lala = AnimationUtils.loadAnimation(this, R.anim.right_out);
        loadApps();
        loadGridView();
    }


    private void loadApps(){
        manager = getPackageManager();
        apps = new ArrayList<GridHomeDetail>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for(ResolveInfo ri:availableActivities){
            GridHomeDetail app = new GridHomeDetail();
            app.label = ri.loadLabel(manager);
            app.name = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
        }
    }

    private GridView grid;
    private void loadGridView(){
        grid = (GridView)findViewById(R.id.apps_grid);

        ArrayAdapter<GridHomeDetail> adapter = new ArrayAdapter<GridHomeDetail>(this, R.layout.grid_home_item, apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.grid_home_item, null);
                }

                ImageView appIcon = (ImageView)convertView.findViewById(R.id.item_app_icon);
                appIcon.setImageDrawable(apps.get(position).icon);
                appIcon.startAnimation(lala);
                TextView appLabel = (TextView)convertView.findViewById(R.id.item_app_label);
                appLabel.setText(apps.get(position).label);

                TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);
                appName.setText(apps.get(position).name);

                return convertView;
            }
        };

        grid.setAdapter(adapter);
    }
}
