package com.sidpug.siddharth_pugalia.DB;

import android.provider.BaseColumns;

public class DataContract {
    private DataContract() {}

    public static final class DataEntry implements BaseColumns{
        /**Name of database table for pets*/
        public final static String TABLE_NAME = "Data_Table";

        /**Table Fields*/
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_LAT  = "LAT";
        public final static String COLUMN_LON  = "LON";
        public final static String COLUMN_TEMP = "Temperature";
        public final static String COLUMN_WEATHER = "Weather";
    }
}
