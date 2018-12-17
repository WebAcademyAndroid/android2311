package com.example.student.android4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Student> mStudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        /*ArrayList<HashMap<String, String>> items = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("Name", "Ivan" + i);
            item.put("LastName", "Ivanov" + i);
            item.put("Age", String.valueOf(i));
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                items,
                R.layout.student,
                new String[]{"Name", "LastName", "Age"},
                new int[]{R.id.textViewFirstName, R.id.textViewLastName, R.id.textViewAge}
        );*/

        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1,
                items);

        mListView.setAdapter(adapter);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position = mListView.getCheckedItemPosition();
                //Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();

                SparseBooleanArray items = mListView.getCheckedItemPositions();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i)) {
                        builder.append(String.valueOf(i));
                        builder.append(" ");
                    }
                }

                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_LONG).show();
            }
        });

        /*for (int i = 0; i < 50; i++) {
            mStudents.add(new Student("Ivan" + i, "Ivanov" + i, i));
        }

        final StudentAdapter adapter = new StudentAdapter(this, R.layout.student, mStudents);

        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = mStudents.get(position);
                Toast.makeText(MainActivity.this, student.toString(), Toast.LENGTH_LONG).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mStudents.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });*/

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });
    }
}
