package com.example.student.android8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       Intent intent1 = new Intent(context, MyService.class);
       context.startService(intent1);
    }
}