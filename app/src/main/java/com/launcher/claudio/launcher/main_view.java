package com.launcher.claudio.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class main_view extends FragmentActivity {

    ViewPager pager = null;
    FragmentPagerAdapter pagerAdapter;

    private PackageManager manager;
    private static List<GridHomeDetail> apps;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.main_pager);

        //Creo listado de APPS
        loadApps();

        // Instantiate a ViewPager
        this.pager = (ViewPager) this.findViewById(R.id.pager);

        // Create an adapter with the fragments we show on the ViewPager
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ScreenSlidePageFragment.newInstance(0));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(1));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(2));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(3));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(4));
        this.pager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        // Return to previous page when we press back button
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);
    }

    public void loadApps(){
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

    public List<GridHomeDetail> GetAvailableApps(){
        return apps;
    }

}