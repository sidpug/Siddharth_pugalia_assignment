package com.sidpug.siddharth_pugalia.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.sidpug.siddharth_pugalia.DB.DataContract.DataEntry;

public class DataHelper extends SQLiteOpenHelper {
    /** Name of the database file */
    private static final String DATABASE_NAME = "DATA";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRANSACTION_TABLE =  "CREATE TABLE " + DataEntry.TABLE_NAME + " ("
                + DataEntry.COLUMN_TIME + " VARCHAR, "
                + DataEntry.COLUMN_LAT + " VARCHAR, "
                + DataEntry.COLUMN_LON + " INTEGER, "
                + DataEntry.COLUMN_WEATHER + " VARCHAR, "
                + DataEntry.COLUMN_TEMP + " INTEGER);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TRANSACTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public void insertTransferData (String time, String LAT, String LON, String temp, String weather) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataEntry.COLUMN_TIME, time);
        contentValues.put(DataEntry.COLUMN_LAT, LAT);
        contentValues.put(DataEntry.COLUMN_LON, LON);
        contentValues.put(DataEntry.COLUMN_TEMP, temp);
        contentValues.put(DataEntry.COLUMN_WEATHER, weather);
        Long result = db.insert(DataEntry.TABLE_NAME, null, contentValues);

    }
}

