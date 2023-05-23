package com.suellen.colangelo.notes.domain

import com.suellen.colangelo.notes.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): List<Note>
    fun getNote(id: Long): Note?
    fun addNote(note: Note)
    fun deleteNote(id: Long)
    fun updateNote(note: Note)
}