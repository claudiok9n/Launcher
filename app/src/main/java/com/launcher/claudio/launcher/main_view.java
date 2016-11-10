package com.launcher.claudio.launcher;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.launcher.claudio.launcher.MyFragmentPagerAdapter.MyFragmentPagerAdapter;

public class main_view extends FragmentActivity {

    ViewPager pager = null;
    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.main);

        // Instantiate a ViewPager
        this.pager = (ViewPager) this.findViewById(R.id.pager);

        // Create an adapter with the fragments we show on the ViewPager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
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

}