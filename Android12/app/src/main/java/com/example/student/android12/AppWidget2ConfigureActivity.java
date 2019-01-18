package com.example.student.android12;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AppWidget2ConfigureActivity extends Activity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    ListView mListView;
    ArrayList<Student> mStudents;
    DataBaseHelper mHelper;

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            int position = mListView.getCheckedItemPosition();
            if (position >= 0) {
                Student student = mStudents.get(position);
                Widget widget = new Widget(student.id, mAppWidgetId);
                mHelper.insert(widget);

                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(AppWidget2ConfigureActivity.this);
                AppWidget2.updateAppWidget(AppWidget2ConfigureActivity.this, appWidgetManager, mAppWidgetId);

                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
                setResult(RESULT_OK, resultValue);
                finish();
            }
        }
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setResult(RESULT_CANCELED);

        setContentView(R.layout.app_widget2_configure);

        mListView = findViewById(R.id.listView);
        findViewById(R.id.add_button).setOnClickListener(mOnClickListener);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
            return;
        }

        mHelper = new DataBaseHelper(this);
        mStudents = mHelper.getStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                android.R.id.text1,
                mStudents);
        mListView.setAdapter(adapter);
    }
}

