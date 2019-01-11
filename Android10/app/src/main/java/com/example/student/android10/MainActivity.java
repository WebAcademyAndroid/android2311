package com.example.student.android10;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private SaveTask mSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
    }

    public void OnClick(View v) {
        editStudent(new Student());
    }

    @NonNull
    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new StudentLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Student>> loader, ArrayList<Student> students) {
        showStudents(students);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }

    private void showStudents(ArrayList<Student> students) {
        Fragment1 fragment1 = Fragment1.newInstance(students);
        fragment1.setActionListener(new Fragment1.ActionListener() {
            @Override
            public void edit(Student student) {
                editStudent(student);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, fragment1).commitAllowingStateLoss();
    }

    private void editStudent(Student student) {
        final Fragment2 fragment2 = Fragment2.newInstance(student);
        fragment2.setActionListener(new Fragment2.ActionListener() {
            @Override
            public void save(Student student) {
                mSaveTask = new SaveTask();
                mSaveTask.execute(student);

            }

            @Override
            public void cancel() {

               // getSupportLoaderManager().initLoader(0, null, MainActivity.this);
            }
        });

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, fragment2).commit();
        fragment2.show(getSupportFragmentManager(), "dialog");
    }


    public class SaveTask extends AsyncTask<Student, Void, Void> {


        @Override
        protected Void doInBackground(Student... students) {
            new DataBaseHelper(MainActivity.this).save(students[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
