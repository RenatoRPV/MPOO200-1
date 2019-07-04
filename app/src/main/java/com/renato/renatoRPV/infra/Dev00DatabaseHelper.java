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

    public static final String TABLE_DRUG = "droga";
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
                        "VALUES ('Droga Principal', 'Dor de cabeça', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Sem dor de cabeça', 'Dor de cabeça', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Cabeça dor', 'Dor de cabeça', 'ATCTTCAA');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES (' Náusea', 'Náusea', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Sem náuseas', 'Náusea', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Náusea Forte', 'Náusea', 'ATCTTCAA');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Dor no estômago', 'Dor de estômago', 'CTGGTGGT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Queimor no Estômago ', 'Dor de estômago', 'CACAGCCT');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Curar p/ Estômago', 'Dor de estômago', 'ATCTTCAA');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Febre', 'Gripe', '');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Febre', 'Gripe', '');");

        sqLiteDatabase.execSQL(
                "INSERT INTO " + TABLE_DRUG + " (name, application, biological_profile) " +
                        "VALUES ('Febre', 'Gripe', '');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }

}