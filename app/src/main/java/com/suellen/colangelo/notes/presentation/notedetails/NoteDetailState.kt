package com.suellen.colangelo.notes.presentation.notedetails

import com.suellen.colangelo.notes.presentation.model.NoteUiModel

sealed class NoteDetailState {
    object Error : NoteDetailState()
    object Loading : NoteDetailState()
    data class Success(val note: NoteUiModel) : NoteDetailState()
}
