package com.example.student.android7;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v) {

        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        switch (v.getId()) {
            case R.id.button:
                preferences = getPreferences(MODE_PRIVATE);
                editor = preferences.edit();

                editor.putString("Test", "some text");
                editor.apply();
                break;
            case R.id.button2:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                editor = preferences.edit();

                editor.putString("Test", "some text");
                editor.commit();
                break;
            case R.id.button3:
                preferences = getPreferences(MODE_PRIVATE);
                Toast.makeText(this, preferences.getString("Test", ""), Toast.LENGTH_LONG).show();
                break;
            case R.id.button4:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                Toast.makeText(this, preferences.getString("Test", ""), Toast.LENGTH_LONG).show();
                break;
            case R.id.button5:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.button6:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                Toast.makeText(this, preferences.getString("edit_text_preference_1", ""), Toast.LENGTH_LONG).show();
                break;
            case R.id.button7:
                saveInternalFile("MyFile.txt", "Internal file data");
                break;
            case R.id.button8:
                Toast.makeText(this, readInternalFile("MyFile.txt"), Toast.LENGTH_LONG).show();
                break;
            case R.id.button9:
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder");

                        saveExternalFile(folder, "MyFile.txt", "External file data");
                    }
                } else {
                    requestPermissions();
                }
                break;
            case R.id.button10:
                if (hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder");

                        Toast.makeText(this, readExternalFile(folder, "MyFile.txt"), Toast.LENGTH_LONG).show();
                    }
                } else {
                    requestPermissions();
                }
                break;
            case R.id.button11: {
                Student student = new Student("Ivan", "Ivanov", 33);
                Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();

                String json = gson.toJson(student);
                saveInternalFile("Student.txt", json);
            }
            break;
            case R.id.button12:
                String json = readInternalFile("Student.txt");
                Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();

                Student student = gson.fromJson(json, Student.class);
                Toast.makeText(this, student.toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void saveInternalFile(String fileName, String data) {
        try {
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, MODE_PRIVATE)));

            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readInternalFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));

            StringBuilder builder = new StringBuilder();
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }

            bufferedReader.close();

            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        }

        return true;
    }

    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };

            requestPermissions(permissions, 0);
        }
    }

    private void saveExternalFile(File folder, String fileName, String data) {
        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }

            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(folder, fileName)), "UTF8"));

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readExternalFile(File folder, String fileName) {
        try {
            File file = new File(folder, fileName);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                StringBuilder builder = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }

                bufferedReader.close();

                return builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
