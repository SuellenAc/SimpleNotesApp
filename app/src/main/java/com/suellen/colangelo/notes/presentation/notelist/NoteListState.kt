package com.suellen.colangelo.notes.presentation.notelist

import com.suellen.colangelo.notes.presentation.model.NoteUiModel

sealed class NoteListState {
    object Loading : NoteListState()
    data class Loaded(
        val notes: List<NoteUiModel>,
        val searchToken: String?,
        val showGrid: Boolean,
    ) : NoteListState()
}
