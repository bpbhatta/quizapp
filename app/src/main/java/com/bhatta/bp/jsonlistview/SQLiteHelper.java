package com.bhatta.bp.jsonlistview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="SubjectDataBase";

    public static final String TABLE_NAME="quiz";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_question ="question";

    public static final String Table_Column_2_opta="opta";
    public static final String Table_Column_3_optb="optb";
    public static final String Table_Column_4_optc="optc";
    public static final String Table_Column_5_answer="answer";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_question+" VARCHAR, "+Table_Column_2_opta+" VARCHAR, \"+Table_Column_2_opta+\" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}