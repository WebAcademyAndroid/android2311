package com.example.student.android5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentViewHolder> {

    private int mResource;
    private ArrayList<Student> mStudents;
    private LayoutInflater mInflater;

    private int mCheckedPosition = -1;

    public RecyclerAdapter(Context context, int resource, ArrayList<Student> students) {
        mResource = resource;
        mStudents = students;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(mResource, viewGroup, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, final int i) {
        final Student student = mStudents.get(i);
        studentViewHolder.set(student);

        if(mListener != null){
            studentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(student);
                }
            });
            studentViewHolder.itemView.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onRemove(student);
                }
            });
        }

        final RadioButton radioButton = studentViewHolder.itemView.findViewById(R.id.radio);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previousChecked = mCheckedPosition;

                mCheckedPosition = i;
                radioButton.setChecked(true);

                notifyItemChanged(previousChecked);
            }
        });

        if(i == mCheckedPosition){
            radioButton.setChecked(true);
        }else {
            radioButton.setChecked(false);
        }
    }


    public interface ActionListener {
        void onClick(Student student);

        void onRemove(Student student);
    }

    private ActionListener mListener;

    public void setActionListener(ActionListener listener) {
        mListener = listener;
    }

    public int getCheckedPosition(){
        return mCheckedPosition;
    }


    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewFirstName, mTextViewLastName, mTextViewAge;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            mTextViewLastName = itemView.findViewById(R.id.textViewLastName);
            mTextViewAge = itemView.findViewById(R.id.textViewAge);
        }

        public void set(Student student) {
            mTextViewFirstName.setText(student.firstName);
            mTextViewLastName.setText(student.lastName);
            mTextViewAge.setText(String.valueOf(student.age));
        }
    }
}
