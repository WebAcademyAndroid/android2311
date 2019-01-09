package com.example.student.android9;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private SaveTask mSaveTask;
    private SaveTask2 mSaveTask2;

    private ListView mListView;
    private ArrayList<Student> mStudents;
    private ArrayAdapter<Student> mAdapter;

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
        if (mSaveTask2 != null) {
            mSaveTask2.cancel(true);
        }
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mSaveTask = new SaveTask();
                mSaveTask.execute(new Student("Ivan", "Ivanov", 22));
                break;
            case R.id.button2:
                mSaveTask2 = new SaveTask2();
                mSaveTask2.execute(new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22),
                        new Student("Ivan", "Ivanov", 22));
                break;
            case R.id.button3:
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


    public class SaveTask extends AsyncTask<Student, Void, Long> {

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
        protected Long doInBackground(Student... students) {

            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);
            Student student = students[0];

            return helper.insert(student);
        }

        @Override
        protected void onPostExecute(Long id) {
            //Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_LONG).show();
            ((Button) findViewById(R.id.button)).setText(String.valueOf(id));

            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }

    public class SaveTask2 extends AsyncTask<Student, Integer, Boolean> {
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
        protected Boolean doInBackground(Student... students) {
            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);

            for (int i = 0; i < students.length; i++) {
                if (isCancelled()) {
                    break;
                }

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Student student = students[i];
                helper.insert(student);

                publishProgress(students.length, i + 1);
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            dialog.setMessage(String.format("Saved %d from %d", values[1], values[0]));
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
