package com.example.noteapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteModel(
    val title: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}