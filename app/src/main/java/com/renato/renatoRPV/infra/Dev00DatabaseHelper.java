package com.renato.renatoRPV.infra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dev00DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Renato.db";

    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "pass";
    public static final String COLUMN_DNASEQ = "dna_seq";

    public static final String TABLE_DRUG = "drug";
    public static final String COLUMN_APPLICATION = "application";
    public static final String COLUMN_BIOPROF = "biological_profile";

    public Dev00DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_USER + " ( " +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_EMAIL + " TEXT NOT NULL, " +
                        COLUMN_PASS + " TEXT NOT NULL, " +
                        COLUMN_DNASEQ + " TEXT );");

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_DRUG + " ( " +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_APPLICATION + " TEXT NOT NULL, " +
                        COLUMN_BIOPROF + " TEXT NOT NULL );");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('HeadDrug', 'Náusea', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('NoHeadPain', 'Náusea', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('HeadFree', 'Náusea', 'ATCTTCAA');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('NauseaStop', '>Dor de cabeça', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('NoNausea', '>Dor de cabeça', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Nauseastamin', '>Dor de cabeça', 'ATCTTCAA');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('StomachPeace', 'Dor de estômago', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Stomachflex', 'Dor de estômago', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('HealStomach', 'Dor de estômago', 'ATCTTCAA');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }

}
