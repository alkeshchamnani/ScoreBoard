package com.alkesh.scoreboard.core.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alkesh.scoreboard.core.database.dao.DaoGameResult
import com.alkesh.scoreboard.core.database.entity.DbGameResult

@Database(entities = [DbGameResult::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): DaoGameResult
}