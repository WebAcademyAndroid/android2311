package com.example.student.android2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    public static final String EXTRA_TEXT = "com.example.student.android2.extra.TEXT";
    public static final String EXTRA_STUDENT = "com.example.student.android2.extra.STUDENT";
    private static final int REQUEST_CODE_ACTIVITY_5 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("AAAAAAAAAA");
            }
        });*/
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                textView.setText("AAAAAAAAAA");
                break;
            case R.id.button2:
                textView.setText("BBBBBBBBBB");
                break;
            case R.id.button3: {
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra(EXTRA_TEXT, "Hello activity!");
                startActivity(intent);
            }
            break;
            case R.id.button4: {
                Student student = new Student("Ivan", "Ivanov", 22);

                Intent intent = new Intent(this, Activity3.class);
                intent.putExtra(EXTRA_STUDENT, student);

                startActivity(intent);
            }
            break;
            case R.id.button5: {
                Intent intent = new Intent(this, Activity4.class);
                startActivity(intent);
            }
            break;
            case R.id.button6: {
                String text = editText.getText().toString();
                if(!text.isEmpty()){
                    Intent intent = new Intent(this, Activity5.class);
                    intent.putExtra(EXTRA_TEXT, text);

                    startActivityForResult(intent, REQUEST_CODE_ACTIVITY_5);
                }
            }
            break;
            case R.id.button7:
                editText.setText(String.valueOf(1));
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_ACTIVITY_5){
            if(resultCode == RESULT_OK){
                String text = data.getStringExtra(EXTRA_TEXT);
                editText.setText(text);
            }
        }
    }
}
