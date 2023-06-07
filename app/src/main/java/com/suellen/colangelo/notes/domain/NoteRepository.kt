package com.suellen.colangelo.notes.domain

import com.suellen.colangelo.notes.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): List<Note>
    fun getNote(id: String): Note?
    fun addNote(note: Note)
    fun deleteNote(id: String)
    fun updateNote(note: Note)
}