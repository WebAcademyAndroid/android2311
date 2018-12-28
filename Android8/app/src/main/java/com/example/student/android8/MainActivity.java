package com.example.student.android8;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyService myService;

    private ArrayAdapter<Student> adapter;
    private ArrayList<Student> students;

    private ListView listView;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, students);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        initList();
    }

    private void initList() {
        showProgress();
        MyIntentService.getStudents(this);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, MyService.class);
                PendingIntent pendingIntent = createPendingResult(1, intent, 0);

                intent.putExtra("PendingIntent", pendingIntent);
                intent.putExtra("Text", "Some text");

                startService(intent);
            }
            break;
            case R.id.button2:
                if(myService == null) {
                    ServiceConnection connection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            myService = ((MyService.MyBinder) service).getService();
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                            myService = null;
                        }
                    };

                    Intent intent = new Intent(this, MyService.class);
                    bindService(intent, connection, BIND_AUTO_CREATE);
                }
                if(myService != null){
                    myService.testBind();
                }
                break;
            case R.id.button3:
                showProgress();
                MyIntentService.saveStudent(this, new Student("Ivan","Ivanov",33));
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

    private void showProgress(){
        if(progressDialog == null || !progressDialog.isShowing()){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    private void hideProgress(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("Text");
                Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            }
        }else if(requestCode == MyIntentService.REQUEST_CODE_GET_STUDENTS){
            if (resultCode == RESULT_OK) {
                ArrayList<Student> items = data.getParcelableArrayListExtra(MyIntentService.EXTRA_STUDENTS);

                students.clear();
                students.addAll(items);

                adapter.notifyDataSetChanged();
                hideProgress();
            }
        }else if(requestCode == MyIntentService.REQUEST_CODE_SAVE_STUDENT){
            if (resultCode == RESULT_OK) {
                long id = data.getLongExtra(MyIntentService.EXTRA_ID, 0);
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_LONG).show();

                initList();
            }
        }
    }
}
