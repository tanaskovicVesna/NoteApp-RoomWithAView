package com.note.myapplication.mvvm;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 */
@Entity(tableName = "note_table")
public class Notice {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Notice(@NonNull String note) {
        this.mNote = note;
    }

    @NonNull
    public String getNote() {
        return this.mNote;
    }
}
