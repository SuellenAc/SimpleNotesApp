package com.suellen.colangelo.notes.presentation.notedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suellen.colangelo.notes.domain.usecase.GetNoteUseCase
import com.suellen.colangelo.notes.presentation.mapper.NoteToUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(
    private val mapper: NoteToUiMapper,
    private val getNoteUseCase: GetNoteUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<NoteDetailState>(NoteDetailState.Loading)
    val state: StateFlow<NoteDetailState> = _state

    fun initialize(noteId: String?) {
        noteId?.let {
            _state.value = NoteDetailState.Loading
            getNote(noteId)
        }
    }

    private fun getNote(noteId: String) {
        viewModelScope.launch {
            _state.value = getNoteUseCase(noteId)?.let {
                NoteDetailState.Success(mapper.mapFrom(it))
            } ?: NoteDetailState.Error
        }
    }

}