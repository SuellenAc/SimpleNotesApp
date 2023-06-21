package com.suellen.colangelo.notes.presentation.notelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suellen.colangelo.notes.domain.usecase.GetAllNotesUseCase
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNotes: GetAllNotesUseCase,
) : ViewModel() {

    private val _notes = MutableStateFlow<List<NoteUiModel>>(listOf())
    val notes: StateFlow<List<NoteUiModel>> = _notes

    private val _searchToken = MutableStateFlow<String?>(null)
    val searchToken: StateFlow<String?> = _searchToken

    init {
        viewModelScope.launch {
            _notes.value = getAllNotes().map {
                NoteUiModel(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                )
            }
        }
    }
}
