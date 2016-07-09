package com.thargyi.padc_week05;

import android.app.Application;
import android.content.Context;

/**
 * Created by Dell on 08-Jul-16.
 */
public class Week05App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }

}
