package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import javax.inject.Inject

interface AddNoteUseCase {
    suspend operator fun invoke(note: Note)
}

class AddNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : AddNoteUseCase {
    override suspend fun invoke(note: Note) {
        repository.addNote(note)
    }
}