package com.example.student.android2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity5 extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        editText = findViewById(R.id.editText2);

        String text = getIntent().getStringExtra(MainActivity.EXTRA_TEXT);
        editText.setText(text);

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = editText.getText().toString();

                if(!text2.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra(MainActivity.EXTRA_TEXT, text2);

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
