package com.example.poxor
import AppDatabase
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class ServiceDetailActivity : AppCompatActivity() {

    private lateinit var db:AppDatabase // Объявляем переменную для базы данных

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_detail) // Убедитесь, что используете правильный layout

        db = AppDatabase.getDatabase(this)
lifecycleScope.launch {
    val editTextName = findViewById<EditText>(R.id.editTextName)
    val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
    val buttonRegister = findViewById<Button>(R.id.buttonRegister)

    buttonRegister.setOnClickListener {
        val name = editTextName.text.toString()
        val phoneNumber = editTextPhone.text.toString()

        if (name.isNotEmpty() && phoneNumber.isNotEmpty()) {
            lifecycleScope.launch {
                val ClientDao = db.ClientDao()
                val newClient = Client(name = name, phoneNumber = phoneNumber)
                ClientDao.insert(newClient)

                // Очистка полей после добавления клиента
                editTextName.text.clear()
                editTextPhone.text.clear()

                Log.d(
                    "ServiceDetailActivity",
                    "Клиент добавлен: $newClient"
                ) // Измените на правильное название активности
            }
        } else {
            Log.d(
                "ServiceDetailActivity",
                "Пожалуйста, заполните все поля."
            ) // Измените на правильное название активности
        }
    }
}}}