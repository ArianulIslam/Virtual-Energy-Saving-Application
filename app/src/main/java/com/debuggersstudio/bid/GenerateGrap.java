package com.debuggersstudio.bid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class GenerateGrap extends AppCompatActivity {
    Spinner spinner;
    EditText billtxt;
    ArrayAdapter<CharSequence> arrayAdapter;
    GraphView graph;
    BarGraphSeries<DataPoint> bargrp;
    myHelper helper;
    Button grpbtn;
    SQLiteDatabase sqLiteDatabase;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_grap);
      grpbtn  = (Button)findViewById(R.id.grpbtn);
  spinner = (Spinner)findViewById(R.id.spinner);
        billtxt =(EditText)findViewById(R.id.billtxt);
        graph = (GraphView)findViewById(R.id.grap);
        arrayAdapter = ArrayAdapter.createFromResource(GenerateGrap.this,R.array.monthName,android.R.layout.simple_spinner_item);

arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        helper =new myHelper(this);
        sqLiteDatabase = helper.getWritableDatabase();
        
        exqButton();
        



    }

    private void exqButton() {
        grpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int xVal = spinner.getSelectedItemPosition()+1;
                int yval  = Integer.parseInt(String.valueOf(billtxt.getText()));

                helper.insertdata(xVal,yval);

                bargrp = new BarGraphSeries<DataPoint>(getData());
                graph.addSeries(bargrp);
                //bargrp.setDrawValuesOnTop(true);
                bargrp.setValuesOnTopColor(Color.RED);
                billtxt.setText("");


            }
        });
    }

    private DataPoint[] getData() {

        String []col={"xValues","YValues"};
        Cursor cursor =sqLiteDatabase.query("MyTable",col,null,null,null,null,null);

DataPoint []db = new  DataPoint[cursor.getCount()];
        for (int  i = 0 ; i < cursor.getCount(); i++){
            cursor.moveToNext();
            db[i]=new DataPoint(cursor.getInt(0),cursor.getInt(1));
        }
        return  db;
    }
}
