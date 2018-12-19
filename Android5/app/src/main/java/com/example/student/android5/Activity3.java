package com.example.student.android5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Activity3 extends AppCompatActivity {

    private ExpandableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mListView = findViewById(R.id.listView);

        Random random = new Random();
        /*ArrayList<HashMap<String, String>> groups = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> children = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            HashMap<String, String> group = new HashMap<>();
            group.put("Name", "Group " + i);
            groups.add(group);

            ArrayList<HashMap<String, String>> groupChildren = new ArrayList<>();
            for (int j = 0; j < random.nextInt(10); j++) {
                HashMap<String, String> child = new HashMap<>();
                child.put("Name", "Ivan " + i + j);
                groupChildren.add(child);
            }
            children.add(groupChildren);
        }

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"Name"},
                new int[]{android.R.id.text1},
                children,
                android.R.layout.simple_list_item_1,
                new String[]{"Name"},
                new int[]{android.R.id.text1});
        mListView.setAdapter(adapter);*/

        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student[] students = new Student[random.nextInt(10)];

            for (int j = 0; j < students.length; j++) {
                students[j] = new Student("Ivan " + i + j, "Ivanov " + i + j, i + j);
            }

            groups.add(new Group("Group " + i, students));
        }

        StudentExpandableAdapter adapter =
                new StudentExpandableAdapter(this, R.layout.group, R.layout.student, groups);
        mListView.setAdapter(adapter);

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(mListView.isGroupExpanded(groupPosition)){
                    mListView.collapseGroup(groupPosition);
                }else{
                    mListView.expandGroup(groupPosition);
                }
                return true;
            }
        });
        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }
}
