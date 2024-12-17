package com.example.poxor
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients") // Assuming your table is named 'clients'
data class Client(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Add an auto-generating primary key
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phoneNumber") val phoneNumber: String
)
