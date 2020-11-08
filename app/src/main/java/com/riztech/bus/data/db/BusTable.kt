package com.riztech.bus.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class BusTable {

    @Entity(tableName = "line")
    data class Line(
        val description: String,
        @PrimaryKey(autoGenerate = false)
        val id: String,
        val name: String,
        val plc_ip_address: String
    ): BusTable()
}