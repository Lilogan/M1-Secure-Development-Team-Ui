package fr.isen.teamui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.isen.teamui.model.Account
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(entities = [Account::class], version = 1)
abstract class TeamuiDatabase : RoomDatabase() {
    abstract fun teamuiDao(): TeamuiDao

    companion object {
        @Volatile
        private var INSTANCE: TeamuiDatabase? = null

        fun getDatabase(context: Context): TeamuiDatabase {
            return INSTANCE ?: synchronized(this) {

                val factory =
                    SupportFactory(SQLiteDatabase.getBytes("TheRandomPassPhrase".toCharArray()))

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TeamuiDatabase::class.java,
                    "teamui.db"
                )
                    .openHelperFactory(factory)
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}