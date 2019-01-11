package com.example.student.android10;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    private static final String EXTRA_STUDENTS = "com.example.student.android10.extra.STUDENTS";

    private ListView mListView;
    private ArrayList<Student> mStudents;

    public static final Fragment1 newInstance(ArrayList<Student> students) {
        Fragment1 fragment1 = new Fragment1();

        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_STUDENTS, students);

        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStudents = getArguments().getParcelableArrayList(EXTRA_STUDENTS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        mListView = view.findViewById(R.id.listView);
        mListView.setOnItemClickListener(clickListener);

        init();

        return view;
    }

    private void init() {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mStudents);

        mListView.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (mListener != null) {
                Student student = mStudents.get(position);
                mListener.edit(student);
            }
        }
    };

    public interface ActionListener {
        public void edit(Student student);
    }

    private ActionListener mListener;

    public void setActionListener(ActionListener listener) {
        mListener = listener;
    }
}
