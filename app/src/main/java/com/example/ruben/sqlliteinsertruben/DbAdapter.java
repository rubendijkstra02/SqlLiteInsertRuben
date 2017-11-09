package com.example.ruben.sqlliteinsertruben;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruben on 9-11-2017.
 */

public class DbAdapter {
    DbHelper helper;

    public DbAdapter(Context context)
    {
        helper = new DbHelper(context);
    }

    public long insertData(String name, String password)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.NAME, name);
        contentValues.put(DbHelper.PASSWORD, password);
        long id = db.insert(DbHelper.TABLE_NAME, null , contentValues);
        return id;
    }
    static class DbHelper extends SQLiteOpenHelper
    {
        //velden
        private static final String DATABASE_NAME = "myDatabase";
        private static final String TABLE_NAME = "myTable";
        //als deze hoger wordt gaat die naar onUpgrade
        private static final int DATABASE_Version = 1;
        private static final String UID="_id";
        private static final String NAME = "Name";
        private static final String PASSWORD= "Password";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +
                "( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +NAME+ " VARCHAR(225), " + PASSWORD+ " VARCHAR(225));";
        //private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
            Message.message(context,"Started...");
        }

        @Override
        //Als die een nieuwe versie van de database vindt gooit de ouwe weg.
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL("DROP_TABLE");
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        public void onCreate(SQLiteDatabase db) {
//tabel maken in De database.
            String SQL_CREATE_WERKNEMER_TABLE =  "CREATE TABLE " + Contract.ContractEntry.TABLE_NAME + " ("
                    + Contract.ContractEntry.COLUMN_UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " //Wordt automaties een value aan gegeven.
                    + Contract.ContractEntry.COLUMN_NAME + " TEXT NOT NULL, "
                    + Contract.ContractEntry.COLUMN_PASSWORD + " TEXT NOT NULL, ";


            db.execSQL(CREATE_TABLE);
        }
    }
}
