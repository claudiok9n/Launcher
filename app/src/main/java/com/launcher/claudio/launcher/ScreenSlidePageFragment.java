package com.launcher.claudio.launcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ScreenSlidePageFragment extends Fragment {

    //Key to insert the index page into the mapping of a Bundle.
    private static final String PAGENUMBER = "pagenumber";

    private int pageNumber;

    private GridHomeDetail appList = new GridHomeDetail();

    public static ScreenSlidePageFragment newInstance(int _pageNumber) {

        // Instantiate a new fragment
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt(PAGENUMBER, _pageNumber);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load parameters when the initial creation of the fragment is done
        this.pageNumber = (getArguments() != null) ? getArguments().getInt(PAGENUMBER)
                : -1;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GridAdapter adapter = null;
        //Agrego el GridView al PageView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.grid_home, container, false);

        //Creo un adapter para agregar las views al GridView
        GridView grid = (GridView) rootView.findViewById(R.id.apps_grid);

        adapter = new GridAdapter(this.getContext(), new GridHomeDetail().GetAvailableAppsByPage(this.pageNumber));

        grid.setAdapter(adapter);

        return rootView;

    }
}