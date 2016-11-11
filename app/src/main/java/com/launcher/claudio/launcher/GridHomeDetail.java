package com.launcher.claudio.launcher;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class GridHomeDetail {
    private static List<GridHomeDetail> apps = new ArrayList<GridHomeDetail>();
    private static ArrayList<Object> lala = new ArrayList<Object>();

    private CharSequence label;
    private CharSequence name;
    private Drawable icon;
    private int page;

    public GridHomeDetail() {}

    public GridHomeDetail(CharSequence _label, CharSequence _name, Drawable _icon, int _page) {
        this.label = _label;
        this.name = _name;
        this.icon = _icon;
        this.page = _page;
    }

    public void addApp(GridHomeDetail appDetail) {
        //for(int i=0; i<apps.size(); i++) {
            //if(apps.get(i).get)
            this.apps.add(appDetail);
        //}

        /*lala.add(this.apps);
        List<GridHomeDetail> lsdf = (List<GridHomeDetail>)lala.get(0);
        CharSequence sdf = lsdf.get(0).getLabel();*/
    }

    public void setAppByPage(){
        List<GridHomeDetail> appsTemp;// = new ArrayList<GridHomeDetail>();
        for(int n = 0; n < 2; n++){
            appsTemp = new ArrayList<GridHomeDetail>();
            for(int i=0; i < apps.size(); i++){
                if (apps.get(i).page == n){
                    appsTemp.add(apps.get(i));
                }
            }
            this.lala.add(appsTemp);
        }
    }

    public List<GridHomeDetail> GetAvailableApps(){
        return apps;
    }

    public int GetCountPages(){
        return this.lala.size();
    }

    public List<GridHomeDetail> GetAvailableAppsByPage(int _page){
        List<GridHomeDetail> listAppsByPage = (List<GridHomeDetail>)lala.get(_page);
        return listAppsByPage;
    }

    public CharSequence getLabel(){ return this.label; }
    public Drawable getIcon(){ return this.icon; }
}