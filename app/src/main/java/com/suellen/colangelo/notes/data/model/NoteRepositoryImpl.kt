package com.suellen.colangelo.notes.data.model

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor() : NoteRepository {
    private val notes = mutableMapOf<Long, Note>()

    override fun getAllNotes(): List<Note> {
        return notes.values.toList()
    }

    override fun getNote(id: Long): Note? {
        return notes[id]
    }

    override fun addNote(note: Note) {
        notes[note.id] = note
    }

    override fun deleteNote(id: Long) {
        notes.remove(id)
    }

    override fun updateNote(note: Note) {
        notes[note.id] = note
    }
}