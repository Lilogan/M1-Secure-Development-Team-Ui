package fr.isen.teamui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.isen.teamui.adapter.AccountsAdapter
import fr.isen.teamui.api.Services
import fr.isen.teamui.database.TeamuiDatabase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AccountsActivity : AppCompatActivity() {
    private val mainScope = MainScope()
    private val database by lazy { TeamuiDatabase.getDatabase(this) }
    private val service by lazy {
        Retrofit.Builder()
            .baseUrl("https://6007f1a4309f8b0017ee5022.mockapi.io/api/m1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Services::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)

        updateAccounts()

        val adapter = AccountsAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.accountRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        database.teamuiDao().getAllAccounts().observe(this, { accounts ->
            adapter.setItems(accounts)
        })

        val button = findViewById<FloatingActionButton>(R.id.refreshActionButton)
        button.setOnClickListener {
            updateAccounts()
        }
    }

    private fun updateAccounts() {
        mainScope.launch {
            try {
                val accounts = service.getAccounts()
                database.teamuiDao().updateAccounts(accounts)
                Toast.makeText(applicationContext, "Account updated !", Toast.LENGTH_SHORT).show()
            } catch (exception: Exception) {
                exception.message?.let { Log.v("Testing", it) }
                Toast.makeText(applicationContext, "No Internet connection", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }
}
