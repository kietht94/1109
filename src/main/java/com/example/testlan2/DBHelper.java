package com.example.testlan2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="DepartDB.db";
    private static final String TABLE_NAME="Departtb";
    private static final String NAME="name";

    private static final String SQL_CREATE_ENTRIES=
            "create table "+TABLE_NAME+"("+NAME+"TEXT NOT NULL"+")";

    public DBHelper(@Nullable Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db,int oldVersion, int newVersion )
    {
        onDowngrade(db,oldVersion,newVersion);
    }
}

