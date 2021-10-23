package com.example.persistentcalculationb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var edNum1:EditText
    lateinit var edNum2:EditText
    lateinit var btnCalc:Button
    lateinit var textResult:TextView
    var result=0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNum1=findViewById(R.id.edNum1)
        edNum2=findViewById(R.id.edNum2)
        btnCalc=findViewById(R.id.btnCalc)
        textResult=findViewById(R.id.tvResult)

        btnCalc.setOnClickListener(){
            if(edNum1.text.isNotEmpty() && edNum2.text.isNotEmpty()){
                result= multyPlay()
                textResult.text="The result is: $result"
            }else
                Toast.makeText(applicationContext, "Please fill the missing entry", Toast.LENGTH_SHORT).show()
        }//end listene

        if(savedInstanceState != null){
            result= savedInstanceState.getFloat("result")
            textResult.text="The result is: $result"
        }

    }//end onCreate()

    fun multyPlay():Float{
        val d=edNum1.text.toString().toFloat()
        val f=edNum2.text.toString().toFloat()
        return d*f
    }//end multyPlay()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putFloat("result",result)
    }//end
}