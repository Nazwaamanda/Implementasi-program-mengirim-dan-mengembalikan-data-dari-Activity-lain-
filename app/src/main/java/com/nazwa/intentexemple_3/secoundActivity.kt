package com.nazwa.intentexemple_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nazwa.intentexemple_3.databinding.ActivitySecondBinding

class secoundActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.getBundleExtra("main_activity_data")
        val height = bundle?.getDouble("height")
        val weight = bundle?.getDouble("weight")
        binding.txtIntentData.text = "Height: $height | Weight: $weight"
        binding.btnCalculate.setOnClickListener {
            val intent = Intent()
            var bmiValue = 0.0
            if (height != null && weight != null){
                bmiValue = 703 * (weight / (height * height))
            }
            intent.putExtra("second_activity_data", bmiValue)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}