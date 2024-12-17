package com.example.poxor
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Список услуг
        val services = listOf(
            Service(
                name = "Организация похорон",
                description = "Полный комплекс услуг по организации похорон." +
                        "\nЦена: От 35 000₽",
                imageResId = R.drawable.funeral // Замените на ваши изображения
            ),
            Service(
                name = "Кремация",
                description = "Организация и проведение кремации." +
                        "\nЦена: От 20 000₽",
                imageResId = R.drawable.cremation
            ),
            Service(
                name = "Ритуальный транспорт",
                description = "Транспорт для ритуальных мероприятий." +
                        "\nЦена: От 1 000₽",
                imageResId = R.drawable.monuments
            ),
            Service(
                name = "Изготовление памятников",
                description = "Изготовление памятников и надгробий." +
                        "\nЦена: От 3 000₽",
                imageResId = R.drawable.pamyt
            ),
            Service(
                name = "Цветы и венки",
                description = "Доставка ритуальных венков и цветов." +
                        "\nЦена: От 2 000₽",
                imageResId = R.drawable.flowers
            )
        )

        // Настройка RecyclerView для отображения услуг
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ServicesAdapter(services) { service ->

            val intent = Intent(this, ServiceDetailActivity::class.java).apply {
                putExtra("serviceName", service.name)
                putExtra("serviceDescription", service.description)
                putExtra("serviceImage", service.imageResId)
            }
            startActivity(intent)
        }

        // Добавляем ItemDecoration с отступом, например, 16 пикселей
        val spaceDecoration = SpaseItemDecoration(16) // Укажите нужный вам отступ
        recyclerView.addItemDecoration(spaceDecoration)

        // Настройка кнопки для перехода к странице сотрудников
        findViewById<MaterialButton>(R.id.staffButton).setOnClickListener {
            val intent = Intent(this, StaffActivity::class.java)
            startActivity(intent)


        }
    }






} //mainact



