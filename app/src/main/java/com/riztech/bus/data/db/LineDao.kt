package com.riztech.bus.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface LineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLine(line: BusTable.Line)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLine(lines: List<BusTable.Line>)

    @Query("SELECT * FROM line")
    fun getAllLines(): LiveData<List<BusTable.Line>>

}