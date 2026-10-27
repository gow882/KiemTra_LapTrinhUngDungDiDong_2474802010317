package com.example.kiemtra_laptrinhungdungdidong_2474802010317

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View bằng findViewById truyền thống
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 1. Kiểm tra bỏ trống Email hoặc Mật khẩu
            if (email.isEmpty()) {
                tvStatus.setText(R.string.error_email_empty)
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                tvStatus.setText(R.string.error_password_empty)
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email bằng Patterns.EMAIL_ADDRESS
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setText(R.string.error_email_invalid)
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 3. Kiểm tra độ dài Mật khẩu < 6 ký tự
            if (password.length < 6) {
                tvStatus.setText(R.string.error_password_length)
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // 4. Dữ liệu hoàn toàn hợp lệ -> Chuyển sang ProfileActivity
            tvStatus.setText(R.string.status_success)
            tvStatus.setTextColor(Color.GREEN)

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_EMAIL", email)
            }
            startActivity(intent)
        }
    }
}