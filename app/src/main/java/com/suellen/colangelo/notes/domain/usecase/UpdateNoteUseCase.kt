package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import javax.inject.Inject

interface UpdateNoteUseCase {
    suspend operator fun invoke(note: Note)
}

class UpdateNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : UpdateNoteUseCase {
    override suspend fun invoke(note: Note) {
        repository.updateNote(note)
    }
}