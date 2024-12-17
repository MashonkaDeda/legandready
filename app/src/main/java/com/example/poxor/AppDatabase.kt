import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

// Определите ваши сущности
@Entity(tableName = "your_entity_table")
data class YourEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val age: Int
)

// Определите DAO интерфейс
@Dao
interface YourEntityDao {
    @Insert
    suspend fun insert(entity: YourEntity)

    @Query("SELECT * FROM your_entity_table")
    suspend fun getAllEntities(): List<YourEntity>

    @Delete
    suspend fun delete(entity: YourEntity)
}

// Определите класс базы данных
@Database(entities = [YourEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yourEntityDao(): YourEntityDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
