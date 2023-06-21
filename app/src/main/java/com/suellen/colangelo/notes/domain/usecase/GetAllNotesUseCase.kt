package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import javax.inject.Inject

interface GetAllNotesUseCase {
    suspend operator fun invoke(): List<Note>
}

class GetAllNotesUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : GetAllNotesUseCase {
    override suspend fun invoke(): List<Note> =
        repository.getAllNotes()
}