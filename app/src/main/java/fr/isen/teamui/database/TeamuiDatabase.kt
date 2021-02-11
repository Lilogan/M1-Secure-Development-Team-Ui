package fr.isen.teamui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.isen.teamui.model.Account
import net.sqlcipher.database.SupportFactory

@Database(entities = [Account::class], version = 1)
abstract class TeamuiDatabase : RoomDatabase() {
    abstract fun teamuiDao(): TeamuiDao

    companion object {
        init {
            System.loadLibrary("native-lib")
        }

        @Volatile
        private var INSTANCE: TeamuiDatabase? = null

        @JvmStatic
        external fun passphraseFromJNI(): String

        fun getDatabase(context: Context): TeamuiDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TeamuiDatabase::class.java,
                    "teamui.db"
                )
                    .openHelperFactory(SupportFactory(passphraseFromJNI().toByteArray()))
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}