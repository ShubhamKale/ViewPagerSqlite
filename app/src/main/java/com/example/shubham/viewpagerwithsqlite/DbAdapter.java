package com.example.shubham.viewpagerwithsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shubham on 23/6/16.
 */

public class DbAdapter extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AGE";
    public static final String COLUMN_ID = "_ID";
    public static final String COLUMN_QUE = "QUE";
    public static final String COLUMN_OPT1 = "OP1";
    public static final String COLUMN_OPT2 = "OP2";
    public static final String COLUMN_OPT3 = "OP3";
    public static final String COLUMN_OPT4 = "OP4";
    public static final String COLUMN_ANS = "ANSWERE";
    public static final String COLUMN_EXP = "EXPLAINATION";
    public static final String TABLE_NAME="CATEGORY";

    public DbAdapter(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" ("+COLUMN_ID+" integer primary key,"+ COLUMN_QUE+" text,"+COLUMN_OPT1 + " text,"+COLUMN_OPT2 + " text,"+COLUMN_OPT3 + " text,"+COLUMN_OPT4 + " text,"+COLUMN_ANS + " text,"+COLUMN_EXP + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_QUE, "fjsdhvjs djshfdjs dfhsjdfh asl");
        contentValues.put(COLUMN_OPT1, "Mdhvjshvjsdvhsj");
        contentValues.put(COLUMN_OPT2, "Rsdhjshvdsjv");
        contentValues.put(COLUMN_OPT3, "Hhjh");
        contentValues.put(COLUMN_OPT4, "Ashhhh");
        contentValues.put(COLUMN_ANS, "Hhjh");
        contentValues.put(COLUMN_EXP, "NOTHING");
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getDataById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT "+COLUMN_QUE +" , " + COLUMN_OPT1 + " , "+ COLUMN_OPT2 + " , "+ COLUMN_OPT3 + " , "+ COLUMN_OPT4 + " FROM "+TABLE_NAME + " WHERE "+COLUMN_ID + "="+id, null);
        return res;
    }

    public int countquestion(){
        SQLiteDatabase db = this.getReadableDatabase();
        int count=(int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return count;
    }

}
