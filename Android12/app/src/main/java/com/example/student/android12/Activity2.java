package com.example.student.android12;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private StudentView mStudentView;
    private DataBaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mStudentView = findViewById(R.id.studentView);

        mHelper = new DataBaseHelper(this);
        long id = getIntent().getExtras().getLong("id");
        final Student student = mHelper.getStudent(id);

        mStudentView.set(student);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStudentView.validate()) {
                    Student student1 = mStudentView.get();
                    mHelper.save(student1);

                    ArrayList<Widget> widgets = mHelper.getWidgets(student1.id);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Activity2.this);
                    for (Widget w : widgets) {
                        AppWidget2.updateAppWidget(Activity2.this, appWidgetManager, w.idWidget);
                    }

                    finish();
                }
            }
        });
    }
}
