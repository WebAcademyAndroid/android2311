package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity2 extends AppCompatActivity {

    private Spinner mSpinner;
    private EditText mEditText;
    private ArrayList<Student> mStudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mSpinner = findViewById(R.id.spinner);
        mEditText = findViewById(R.id.editText);

        /*String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1,
                items);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);*/

        for (int i = 0; i < 50; i++) {
            mStudents.add(new Student("Ivan" + i, "Ivanov" + i, i));
        }

        final StudentAdapter adapter = new StudentAdapter(this, R.layout.student, mStudents);

        mSpinner.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString().trim();

                Pattern p = Pattern.compile("^[\\d]{1,}$");
                Matcher m = p.matcher(text);

                try{
                    int age = Integer.parseInt(text);
                }catch (Exception e){

                }

                if(m.matches()){
                    Toast.makeText(Activity2.this, "Is number", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Activity2.this, "NOT number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
