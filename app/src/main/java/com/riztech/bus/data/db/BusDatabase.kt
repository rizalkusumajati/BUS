package com.riztech.bus.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [BusTable.Line::class],version = 1, exportSchema = false)
abstract class BusDatabase : RoomDatabase() {


}