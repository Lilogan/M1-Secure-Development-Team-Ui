package fr.isen.teamui.api


import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ApiHelper {

    companion object {

        init {
            System.loadLibrary("native-lib")
        }

        @JvmStatic
        external fun baseUrlFromJNI(): String

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val spec = ConnectionSpec.Builder(ConnectionSpec.RESTRICTED_TLS)
                    .build()

                val client = OkHttpClient.Builder()
                    .connectionSpecs(Collections.singletonList(spec))
                    .build()

                val instance = Retrofit.Builder()
                    .baseUrl(baseUrlFromJNI())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}