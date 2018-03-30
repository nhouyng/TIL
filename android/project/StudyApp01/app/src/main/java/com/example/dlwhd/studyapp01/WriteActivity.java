package com.example.dlwhd.studyapp01;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteActivity extends AppCompatActivity {

    public static String dirPath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/Android/com.mosslife.studyapp01/temp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void save(View view) {

        EditText editText = (EditText) findViewById(R.id.edittext);
        final String contents = editText.getText().toString();
        final EditText et = new EditText(WriteActivity.this);

        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("저장");
        alert.setView(et);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String filename = et.getText().toString();
                writeTextFile(filename, contents);

                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);

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

    public void writeTextFile(String filename, String contents){
        try{
            FileOutputStream fos = new FileOutputStream(dirPath+"/"+filename, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(contents);
            bw.flush();

            bw.close();
            fos.close();
        }catch (Exception e){
            Log.v("writeTextFile ERROR", e.toString());
        }

    }
}
