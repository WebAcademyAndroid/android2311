package com.example.student.android91;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private ListView mListView;
    private ArrayList<Student> mStudents;
    private ArrayAdapter<Student> mAdapter;

    private SaveTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        mStudents = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mStudents);
        mListView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(0, null, this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTask = new SaveTask();
                mTask.execute(new Student("Petro","Petrov",33));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mTask != null){
            mTask.cancel(true);
        }
    }

    @NonNull
    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new StudentLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Student>> loader, ArrayList<Student> students) {
        mStudents.clear();
        mStudents.addAll(students);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }


    public class SaveTask extends AsyncTask<Student, Void, Uri> {
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Wait...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Uri doInBackground(Student... students) {
            Student student = students[0];

            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.firstName);
            values.put(Student.COLUMN_LAST_NAME, student.lastName);
            values.put(Student.COLUMN_AGE, student.age);

            try {
                Uri uri = Uri.parse("content://com.example.student.android9/students");
                return getContentResolver().insert(uri, values);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Uri uri) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
