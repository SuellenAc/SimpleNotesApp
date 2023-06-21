package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.domain.NoteRepository
import javax.inject.Inject

interface DeleteNoteUseCase {
    suspend operator fun invoke(id: String)
}

class DeleteNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : DeleteNoteUseCase {
    override suspend fun invoke(id: String){
        repository.deleteNote(id)
    }
}