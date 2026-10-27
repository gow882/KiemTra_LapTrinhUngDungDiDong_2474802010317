package com.example.kiemtra_laptrinhungdungdidong_2474802010317

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById truyền thống
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSkills = findViewById(R.id.lvSkills)

        // Nhận dữ liệu Email từ Intent
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvUserEmail.text = email

        // Dữ liệu danh sách môn học/kỹ năng mẫu
        val skillsList = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android",
        )

        // Gắn ArrayAdapter để đổ dữ liệu lên ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skillsList)
        lvSkills.adapter = adapter

        // Bắt sự kiện click vào item trong ListView
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = skillsList[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }

        // Xử lý sự kiện click nút Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }
    }
}