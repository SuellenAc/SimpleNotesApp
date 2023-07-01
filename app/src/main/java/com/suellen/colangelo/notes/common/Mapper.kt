package com.suellen.colangelo.notes.common

interface Mapper<FROM, TO> {
    fun mapFrom(from: FROM): TO
}