package com.example.student.android10;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Fragment2 extends DialogFragment {

    private static final String EXTRA_STUDENT = "com.example.student.android10.STUDENT";

    private EditText mEditTextFirstName, mEditTextLastName, mEditTextAge;
    private Student mStudent;


    public static Fragment2 newInstance(Student student) {
        Fragment2 fragment2 = new Fragment2();

        Bundle args = new Bundle();
        args.putParcelable(EXTRA_STUDENT, student);

        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStudent = getArguments().getParcelable(EXTRA_STUDENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        mEditTextFirstName = view.findViewById(R.id.editTextFirstName);
        mEditTextLastName = view.findViewById(R.id.editTextLastName);
        mEditTextAge = view.findViewById(R.id.editTextAge);

        view.findViewById(R.id.buttonSave).setOnClickListener(saveClick);
        view.findViewById(R.id.buttonCancel).setOnClickListener(cancelClick);

        init();

        return view;
    }

    private void init() {
        mEditTextFirstName.setText(mStudent.firstName);
        mEditTextLastName.setText(mStudent.lastName);
        mEditTextAge.setText(String.valueOf(mStudent.age));
    }

    private View.OnClickListener saveClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mStudent.firstName = mEditTextFirstName.getText().toString();
                mStudent.lastName = mEditTextLastName.getText().toString();
                mStudent.age = Integer.parseInt(mEditTextAge.getText().toString());

                mListener.save(mStudent);
            }

            dismiss();
        }
    };
    private View.OnClickListener cancelClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.cancel();
            }

            dismiss();
        }
    };


    public interface ActionListener {
        public void save(Student student);

        public void cancel();
    }

    private ActionListener mListener;

    public void setActionListener(ActionListener listener) {
        mListener = listener;
    }
}
