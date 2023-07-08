package com.suellen.colangelo.notes.presentation.mapper

import com.suellen.colangelo.notes.domain.model.Note
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import org.junit.Assert
import org.junit.Test

class NoteToUiMapperTest {
    private val sut = NoteToUiMapper()

    @Test
    fun mapFrom_returnUiModel() {
        val note = Note(
            id = "id",
            title = "title",
            description = "description"
        )

        val actual = sut.mapFrom(note)
        val expected = NoteUiModel(
            id = "id",
            title = "title",
            description = "description"
        )

        Assert.assertEquals(expected, actual)
    }
}