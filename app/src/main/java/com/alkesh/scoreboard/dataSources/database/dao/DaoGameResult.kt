package com.alkesh.scoreboard.dataSources.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alkesh.scoreboard.dataSources.database.entity.DbGameResult

@Dao
interface DaoGameResult {
    @Query("SELECT * FROM result")
    suspend fun getAll(): List<DbGameResult>

    @Query("SELECT * FROM result WHERE apiSource LIKE :apiSource")
    suspend fun getAll(apiSource: String): List<DbGameResult>

    @Insert
    suspend fun insertAll(vararg users: DbGameResult)

    @Query("DELETE FROM result WHERE apiSource LIKE :apiSource")
    suspend fun deleteAll(apiSource: String)

    @Delete
    suspend fun delete(user: DbGameResult)

}