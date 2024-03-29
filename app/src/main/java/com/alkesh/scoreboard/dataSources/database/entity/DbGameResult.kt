package com.alkesh.scoreboard.dataSources.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Result")
data class DbGameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    @ColumnInfo(name = "teamA") val teamA: String,
    @ColumnInfo(name = "teamB") val teamB: String,
    @ColumnInfo(name = "score") val score: String,

    @ColumnInfo(name = "linkA") val linkA: String,
    @ColumnInfo(name = "linkB") val linkB: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "apiSource") val apiSource: String

) {

}