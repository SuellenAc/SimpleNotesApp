package com.suellen.colangelo.notes.factory

import com.suellen.colangelo.notes.domain.model.Note

object NoteFactory {
    fun makeNote(
        id: String = "id",
        title: String = "title",
        description: String = "description"
    ) = Note(
        id = id,
        title = title,
        description = description
    )
}