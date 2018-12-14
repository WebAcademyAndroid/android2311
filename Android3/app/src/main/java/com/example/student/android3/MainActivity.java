package com.example.student.android3;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView2);
        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action2:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action3:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action2:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action3:
                Toast.makeText(this, "Action 1 click", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(this, "Hello toast", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2: {
                Toast toast = Toast.makeText(this, "Hello toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);

                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);

                ViewGroup layout = (ViewGroup) toast.getView();
                layout.addView(imageView, 0);

                toast.show();
            }
            break;
            case R.id.button3: {
                View view = getLayoutInflater().inflate(R.layout.toast, null);
                TextView textView = view.findViewById(R.id.textView);
                textView.setText("Hello toast");

                view.findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                Toast toast = new Toast(this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view);
                toast.show();
            }
            break;
            case R.id.button4: {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent(this, MyReceiver.class);
                PendingIntent pendingIntent =
                        PendingIntent.getBroadcast(this, 0, intent, 0);

                Notification notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Ticker")
                        .setContentTitle("Title")
                        .setContentText("Text")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .build();

                notificationManager.notify(1, notification);
            }
            break;
            case R.id.button5:
             TimePickerDialog dialog =   new TimePickerDialog(
                        this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(MainActivity.this, hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
                            }
                        },
                        40, 222, true
                );
             dialog.setCancelable(false);
             dialog.show();
                break;
            case R.id.button6:
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                }, 2010, 33, 44).show();
                break;
            case R.id.button7:
                PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.imageView2));
                popupMenu.inflate(R.menu.main);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
        }
    }
}
