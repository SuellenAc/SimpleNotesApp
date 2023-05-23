package com.suellen.colangelo.notes.presentation.notelist

import androidx.lifecycle.ViewModel
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor() : ViewModel() {

    private val _notes = MutableStateFlow<List<NoteUiModel>>(listOf())
    val notes: StateFlow<List<NoteUiModel>> = _notes

}