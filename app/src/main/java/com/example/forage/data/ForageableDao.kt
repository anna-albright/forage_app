package com.example.forage.data

import android.content.ClipData
import androidx.room.*
import com.example.forage.model.Forageable
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for database interaction.
 */
@Dao
interface ForageableDao {

    @Query("SELECT * from Forageable")
    fun getForageables(): Flow<List<Forageable>>

    @Query("SELECT * from Forageable WHERE id = :id")
    fun getForageable(id: Long):Flow<Forageable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Forageable)

    @Update
    suspend fun update(item: Forageable)

    @Delete
    suspend fun delete(item: Forageable)
}
