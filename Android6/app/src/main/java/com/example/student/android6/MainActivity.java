package com.example.student.android6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper helper;
    private ArrayAdapter<Student> adapter;
    private ArrayList<Student> students;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DataBaseHelper(this);
        students = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, students);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        initList();
    }

    private void initList() {
        ArrayList<Student> items = helper.getStudents();

        students.clear();
        students.addAll(items);

        adapter.notifyDataSetChanged();
    }

    public void OnClick(View v) {
        DataBaseHelper helper = new DataBaseHelper(this);
        //SQLiteDatabase db = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.button: {
                long id = helper.insert(new Student("Ivan", "Ivanov", 33));
                Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_LONG).show();

                initList();
            }
            break;
            case R.id.button2: {

                //int count = helper.update(new Student())
                //Toast.makeText(MainActivity.this, String.valueOf(count), Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
        }
    }
}
