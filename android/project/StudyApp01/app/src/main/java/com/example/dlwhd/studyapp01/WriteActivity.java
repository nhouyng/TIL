package com.example.dlwhd.studyapp01;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class WriteActivity extends AppCompatActivity {

    //EditText editText = (EditText) findViewById(R.id.edittext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void save(View view) {
        final EditText et = new EditText(WriteActivity.this);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("저장");
        alert.setView(et);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String value = et.getText().toString();
                Log.v("file name", value);
                finish();
            }
        });
        alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alert.show();
    }
}
