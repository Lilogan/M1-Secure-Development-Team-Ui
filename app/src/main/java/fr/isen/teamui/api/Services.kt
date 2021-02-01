package fr.isen.teamui.api

import fr.isen.teamui.model.Account
import fr.isen.teamui.model.Config
import retrofit2.http.GET

interface Services {
    @GET("accounts")
    suspend fun getAccounts(): List<Account>

    @GET("config/1")
    suspend fun getInfo(): Config
}