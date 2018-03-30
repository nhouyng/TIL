package com.example.dlwhd.studyapp01;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static String dirPath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/Android/com.mosslife.studyapp01/temp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        List<String> filesNameList = new ArrayList<>();
        for (File file : files) {
            filesNameList.add(file.getName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, filesNameList);

        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String filename = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListActivity.this, ReadActivity.class);
                // ReadActivity로 파일이름 전달
                intent.putExtra("filename", filename);
                startActivity(intent);
                Log.i("filename : ", filename);
            }
        });
    }
}
