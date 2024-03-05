package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ticktactoeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticktactoe)
        val centerTxt:TextView = findViewById(R.id.centerTxt)
        val centerLeftTxt:TextView = findViewById(R.id.centerLeftTxt)
        val centerRightTxt:TextView = findViewById(R.id.centerRightTxt)
        val topCenterTxt:TextView = findViewById(R.id.topCenterTxt)
        val topLeftTxt:TextView = findViewById(R.id.topLeftTxt)
        val topRightTxt:TextView = findViewById(R.id.topRightTxt)
        val bottomCenterTxt:TextView = findViewById(R.id.bottomCenterTxt)
        val bottomRightTxt:TextView = findViewById(R.id.bottomRightTxt)
        val bottomLeftTxt:TextView = findViewById(R.id.bottomLeftTxt)

    }
}