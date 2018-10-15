package com.koalatea.sedaily.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EpisodeDao {
    @get:Query("SELECT * FROM episode")
    val all: List<Episode>

    @Query("SELECT * FROM episode WHERE _id = :id LIMIT 1")
    fun findById(id: String): Episode

    @Insert
    fun inserAll(vararg episodes: Episode)
}