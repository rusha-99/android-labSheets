package com.example.sqlitedemo

import android.database.Cursor
import android.database.sqlite.SQLiteException

class DatabaseHandle {

    fun viewEmployee(): ArrayList<EmpModelClass> {

        val empList: ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()

        // Query to select all the records from the table.
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"

        val db = this.readableDatabase
        // Cursor is used to read the record one by one. Add them to data model class.
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)

        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var email: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL))

                val emp = EmpModelClass(id = id, name = name, email = email)
                empList.add(emp)

            } while (cursor.moveToNext())
        }
        return empList
    }
}