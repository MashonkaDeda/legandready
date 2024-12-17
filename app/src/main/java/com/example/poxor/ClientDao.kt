package com.example.poxor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ClientDao {
    @Insert
    suspend fun insert(client: Client)

    @Query("SELECT * FROM clients")
    suspend fun getAllClients(): List<Client>
}