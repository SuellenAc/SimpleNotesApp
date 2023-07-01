package com.suellen.colangelo.notes.presentation.mapper

import com.suellen.colangelo.notes.common.Mapper
import com.suellen.colangelo.notes.domain.model.Note
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import javax.inject.Inject

class NoteToUiMapper @Inject constructor() : Mapper<Note, NoteUiModel> {

    override fun mapFrom(from: Note): NoteUiModel = NoteUiModel(
        id = from.id,
        title = from.title,
        description = from.description,
    )
}