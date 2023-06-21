package com.suellen.colangelo.notes.data.model

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import java.util.UUID
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor() : NoteRepository {
    private val notes = mutableMapOf<String, Note>()

    init {
        (1..50).forEach {
            notes[it.toString()] = Note(
                id = getRandomUUID(),
                title = "title - $it",
                description = "description - $it"
            )
        }
    }

    private fun getRandomUUID() = UUID.randomUUID().toString()

    override fun getAllNotes(): List<Note> {
        return notes.values.toList()
    }

    override fun getNote(id: String): Note? {
        return notes[id]
    }

    override fun addNote(note: Note) {
        notes[note.id] = note
    }

    override fun deleteNote(id: String) {
        notes.remove(id)
    }

    override fun updateNote(note: Note) {
        notes[note.id] = note
    }
}