package com.example.poxor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaffActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)

        // Список сотрудников
        val staffList = listOf(
            StaffMember("Раздымаха Мария", "Владелец", R.drawable.masha),
            StaffMember("Землянский Валерий", "Судмедэксперт", R.drawable.valera),
            StaffMember("Молчанов Сергей", "Водитель катафалка", R.drawable.serega),
            StaffMember("Токарь Станислав", "Гробовщик", R.drawable.stass),
            StaffMember("Емельянов Иван", "Могильщик", R.drawable.vanya)
            )

        // Настройка RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.staffRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StaffAdapter(staffList)
    }
}
