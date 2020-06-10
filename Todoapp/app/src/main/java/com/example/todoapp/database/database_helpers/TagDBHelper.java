package com.example.todoapp.database.database_helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.todoapp.database.Database;
import com.example.todoapp.models.Tag;

public class TagDBHelper extends ModelHelper {

    public TagDBHelper(Context context){ // pass the context to the database helper
        super(context);
    }

    public void addTag(Tag tag) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.COL_TAG_TITLE, tag.getTitle());
        sqLiteDatabase.insert(Database.TABLE_TAG_NAME, null, contentValues);
    }

    public void removeTag(int tagId){
        String tagIdString = String.valueOf(tagId);

        sqLiteDatabase.beginTransaction();
        sqLiteDatabase.delete(
                Database.TABLE_TAG_NAME,
                Database.COL_TAG_ID + "=?",
                new String[]{tagIdString}
        );

        /* sqLiteDatabase.delete(
                Database.TABLE_TODOTAGS_NAME,
                Database.COL_TODOTAGS_TAG_ID + "=?",
                new String[]{tagIdString}
        ); */
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }

    // implement other methods like update, query all todo tags, etc.

}
