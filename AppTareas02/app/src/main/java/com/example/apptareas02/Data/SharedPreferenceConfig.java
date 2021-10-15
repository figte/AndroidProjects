package com.example.apptareas02.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences preferences;

    public SharedPreferenceConfig(Context context){
        preferences=context.getSharedPreferences("data",Context.MODE_PRIVATE);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void delete(){
        preferences.edit().clear();
    }
}
