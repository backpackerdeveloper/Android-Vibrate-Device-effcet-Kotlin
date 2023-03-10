package com.shubhamtripz.vibratedevice

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchbtn = findViewById<Switch>(R.id.vib)

        switchbtn.setOnClickListener {
              if (switchbtn.isChecked){
                  vibe(it)
                  Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show()
              }
            else{
                vibe(it)
                  Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show()
              }
        }

    }

    fun vibe(v: View){
        val vibrate = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT>=26){
            vibrate.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else{
            vibrate.vibrate(400)
        }
    }

}