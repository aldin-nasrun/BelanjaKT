package com.quick.belanjakt.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ContentOfflineDatabase(var context: Context?) : SQLiteOpenHelper(
    context, "db_konten", null, 1) {
    lateinit var mQuery :String
    override fun onCreate(db: SQLiteDatabase?) {
        mQuery = "CREATE TABLE IF NOT EXISTS tb_konten(" +
                "_id INTEGER PRIMARY KEY," +
                "documentID TEXT," +
                "judul TEXT," +
                "harga TEXT," +
                "harga_awal TEXT," +
                "deskripsi TEXT," +
                "free_shipping INTEGER," +
                "rating INTEGER," +
                "image_url TEXT," +
                "real_date INTGER"+
                ")"
        db?.execSQL(mQuery)
    }
    fun createTable(){
        val db = this.writableDatabase
        mQuery = "CREATE TABLE IF NOT EXISTS tb_konten(" +
                "_id INTEGER PRIMARY KEY," +
                "documentID TEXT," +
                "judul TEXT," +
                "harga TEXT," +
                "harga_awal TEXT," +
                "deskripsi TEXT," +
                "free_shipping INTEGER," +
                "rating INTEGER," +
                "image_url TEXT," +
                "real_date INTGER"+
                ")"
        db?.execSQL(mQuery)
    }
    fun insertData(values: ContentValues) {
        val db = this.writableDatabase
        db.insert("tb_konten", null, values)
    }
    fun select(): Cursor? {
        val db = this.writableDatabase
        mQuery = "select * from tb_konten order by real_date desc"
        return db.rawQuery(mQuery, null)
    }

    fun selectBy(key : String): Cursor? {
        val db = this.writableDatabase
        mQuery = "select * from tb_konten where judul like '%$key%' order by real_date desc"
        return db.rawQuery(mQuery, null)
    }


    fun delete() {
        val db = this.writableDatabase
        mQuery = "DELETE FROM tb_konten"
        db.execSQL(mQuery)
    }
//    fun delete() {
//        val db = this.writableDatabase
//        mQuery = "DROP TABLE IF EXISTS tb_konten"
//        db.execSQL(mQuery)
//    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}