package com.example.homework10

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.logging.Logger
import kotlin.coroutines.coroutineContext

class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " +
                "DATETABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE INTEGER)")
    }


    fun getDate(): Cursor? {

        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM DATETABLE", null)

    }

    fun clearDate(){
        val db = this.readableDatabase

        db.execSQL("delete from DATETABLE");

    }

    companion object{

        val DATE = "DATE"

    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}