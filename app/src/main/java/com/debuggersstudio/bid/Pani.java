package com.debuggersstudio.bid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Pani extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String > arrayListplaceName;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pani);

        lv = (ListView) findViewById(R.id.listviewplacename);

        arrayListplaceName = new ArrayList<>();
        arrayListplaceName.addAll(Arrays.asList(getResources().getStringArray(R.array.Panitips)));
        adapter = new ArrayAdapter<String>(Pani.this,android.R.layout.simple_list_item_1,arrayListplaceName);
        //  lv.setBackgroundColor(Color.RED);
        lv.setAdapter(adapter);
    }
}
