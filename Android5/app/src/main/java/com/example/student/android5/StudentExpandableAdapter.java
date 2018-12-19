package com.example.student.android5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentExpandableAdapter extends BaseExpandableListAdapter {

    private int mGroupResource, mChildResource;
    private ArrayList<Group> mGroups;
    private LayoutInflater mInflater;

    public StudentExpandableAdapter(Context context, int groupResource, int childResource, ArrayList<Group> groups) {
        mGroupResource = groupResource;
        mChildResource = childResource;
        mGroups = groups;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups.get(groupPosition).students.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).students[childPosition];
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mGroupResource, null);
        Group group = (Group) getGroup(groupPosition);

        ((TextView)convertView.findViewById(R.id.textViewGroup)).setText(group.name);

        View indicator = convertView.findViewById(R.id.indicator);
        if(getChildrenCount(groupPosition) == 0){
            indicator.setBackgroundColor(Color.GRAY);
        }else if(isExpanded){
            indicator.setBackgroundColor(Color.RED);
        }else{
            indicator.setBackgroundColor(Color.GREEN);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mChildResource, null);
        Student student = (Student) getChild(groupPosition, childPosition);

        ((TextView)convertView.findViewById(R.id.textViewFirstName)).setText(student.firstName);
        ((TextView)convertView.findViewById(R.id.textViewLastName)).setText(student.lastName);
        ((TextView)convertView.findViewById(R.id.textViewAge)).setText(String.valueOf(student.age));

        return convertView;
    }


    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
