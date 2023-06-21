package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.domain.model.Note
import javax.inject.Inject

interface GetNoteUseCase {
    suspend operator fun invoke(id: String): Note?
}

class GetNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : GetNoteUseCase {
    override suspend fun invoke(id: String): Note? =
        repository.getNote(id)
}