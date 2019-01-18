package com.example.student.android12;

import android.content.Context;
import android.content.SharedPreferences;

public class IntManager {
    public static int nextInt(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int id = preferences.getInt("count", 0);

        id++;
        if (id > 99999999) {
            id = 1;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", id);
        editor.apply();

        return id;
    }
}
