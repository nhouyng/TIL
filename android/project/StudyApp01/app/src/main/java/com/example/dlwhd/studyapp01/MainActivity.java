package com.example.dlwhd.studyapp01;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dirPath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/Android/com.nhouyng.studyapp01/temp";
        File file = new File(dirPath);
        if(!file.exists())
            file.mkdirs();
    }

    public void mvWrite(View view) {
        Intent intent = new Intent(MainActivity.this, WriteActivity.class);
        startActivity(intent);
    }

    public void mvList(View view){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void finish(View view){
        finish();
    }
}
