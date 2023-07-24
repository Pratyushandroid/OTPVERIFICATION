package com.example.otpverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.otpverification.utils.Constant.phoneNumberKey
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login_Activity : AppCompatActivity() {

    private lateinit var etPhoneNum : TextInputLayout
    private lateinit var btnGetOtp :MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etPhoneNum = findViewById(R.id.et_phone_num)
        btnGetOtp = findViewById(R.id.btn_get_otp)


        btnGetOtp.setOnClickListener {
            validateNumber()
        }
    }

    private fun validateNumber() {

            if (etPhoneNum.editText?.text.toString().isEmpty()) {
                etPhoneNum.error = "Enter your Phone Number"
                etPhoneNum.requestFocus()
                return
            }

            if (etPhoneNum.editText?.text.toString().count() == 10) {

                etPhoneNum.clearFocus()
                val intent = Intent(this, OTPVerification::class.java).apply {
                    putExtra(phoneNumberKey, etPhoneNum.editText?.text.toString())
                }
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Enter 10 digit number", Toast.LENGTH_SHORT).show()
            }

    }
}