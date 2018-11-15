package com.debuggersstudio.bid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ib-internetbasic on 4/20/17.
 */

public class myHelper extends SQLiteOpenHelper {

private Context con;
    public myHelper(Context context) {
        super(context,"MyDatabase", null,1);
        con =context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "create table MyTable (xValues INTEGER,YValues INTEGER)";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void insertdata(int x , int y){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("xValues",x);
        contentValues.put("YValues",y);
        db.insert("MyTable",null,contentValues);



    }
}
