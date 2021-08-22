package com.alkesh.scoreboard.common.util;

object NameUtil {

    fun getShortName(fullName: String): String {
        var shortName = ""
        val words = fullName.split(" ")
        for (word in words) {
            shortName = shortName + "" + word[0]
        }
        return shortName
    }
}