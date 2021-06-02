package com.example.victordummy

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.victordummy.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button : Button = findViewById<Button>(R.id.button)

        fun Boolean.toInt() = if (this) 1 else 0

        button.setOnClickListener(View.OnClickListener {
            var sw1 : Switch = findViewById(R.id.switch1)
            var sw2 : Switch = findViewById(R.id.switch2)
            var sw3 : Switch = findViewById(R.id.switch3)
            var sw4 : Switch = findViewById(R.id.switch4)
            var sw5 : Switch = findViewById(R.id.switch5)
            var sw6 : Switch = findViewById(R.id.switch6)
            var sw7 : Switch = findViewById(R.id.switch7)
            var sw8 : Switch = findViewById(R.id.switch8)
            var sw9 : Switch = findViewById(R.id.switch9)
            var sw10 : Switch = findViewById(R.id.switch10)
            var sw11 : Switch = findViewById(R.id.switch11)
            var sw12 : Switch = findViewById(R.id.switch12)
            var sw13 : Switch = findViewById(R.id.switch13)
            var sw14 : Switch = findViewById(R.id.switch14)
            var sw15 : Switch = findViewById(R.id.switch15)
            var sw16 : Switch = findViewById(R.id.switch16)
            var sw17 : Switch = findViewById(R.id.switch17)

            var v1 : Int = sw1.isChecked().toInt()
            var v2 : Int = sw2.isChecked().toInt()
            var v3 : Int = sw3.isChecked().toInt()
            var v4 : Int = sw4.isChecked().toInt()
            var v5 : Int = sw5.isChecked().toInt()
            var v6 : Int = sw6.isChecked().toInt()
            var v7 : Int = sw7.isChecked().toInt()
            var v8 : Int = sw8.isChecked().toInt()
            var v9 : Int = sw9.isChecked().toInt()
            var v10 : Int = sw10.isChecked().toInt()
            var v11 : Int = sw11.isChecked().toInt()
            var v12 : Int = sw12.isChecked().toInt()
            var v13 : Int = sw13.isChecked().toInt()
            var v14 : Int = sw14.isChecked().toInt()
            var v15 : Int = sw15.isChecked().toInt()
            var v16 : Int = sw16.isChecked().toInt()
            var v17 : Int = sw17.isChecked().toInt()


            var byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*17)
            byteBuffer.putFloat(v1.toFloat())
            byteBuffer.putFloat(v2.toFloat())
            byteBuffer.putFloat(v3.toFloat())
            byteBuffer.putFloat(v4.toFloat())
            byteBuffer.putFloat(v5.toFloat())
            byteBuffer.putFloat(v6.toFloat())
            byteBuffer.putFloat(v7.toFloat())
            byteBuffer.putFloat(v8.toFloat())
            byteBuffer.putFloat(v9.toFloat())
            byteBuffer.putFloat(v10.toFloat())
            byteBuffer.putFloat(v11.toFloat())
            byteBuffer.putFloat(v12.toFloat())
            byteBuffer.putFloat(v13.toFloat())
            byteBuffer.putFloat(v14.toFloat())
            byteBuffer.putFloat(v15.toFloat())
            byteBuffer.putFloat(v16.toFloat())
            byteBuffer.putFloat(v17.toFloat())

            val model = Model.newInstance( this)

// Creates inputs for reference.
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 17), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            var tv : TextView = findViewById(R.id.textView)
            val output : String = outputFeature0.joinToString("--")
            val maxIdx = outputFeature0.indices.maxBy { outputFeature0[it] } ?: -1
            tv.setText(output)

//            val maxIdx = nums.indexOf(nums.max())
            model.close()


        })

    }
}