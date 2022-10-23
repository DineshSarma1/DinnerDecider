package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {

    private var defaultFoods = arrayOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    private lateinit var newFoodTxt: EditText
    private lateinit var foodNameTxt : TextView

    private val foodList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    fun initView() {
        //initializing views
        val addFood:Button = findViewById(R.id.addFoodBtn)
        newFoodTxt = findViewById(R.id.newFoodTxt)
        foodNameTxt = findViewById(R.id.foodNameTxt)
        val decideBtn:Button = findViewById(R.id.decideBtn)

        //adding all the default foods into the array list
        foodList.addAll(defaultFoods)

        //setting click listener to the buttons
        addFood.setOnClickListener(this)
        decideBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.addFoodBtn -> {
                onAddFoodButtonClicked()
            }
            R.id.decideBtn -> {
                onDecideButtonClicked()
            }
        }
    }

    private fun onAddFoodButtonClicked() {
        if (!newFoodTxt.text.isNullOrEmpty()) {
            foodList.add(newFoodTxt.text.toString())
            newFoodTxt.text.clear()
        }
    }

    private fun onDecideButtonClicked() {
        //get random number
        val randomIndex = Random.nextInt(0, foodList.size)

        //get food name according to random value
        val foodName = foodList[randomIndex]

        //set value to the text view
        foodNameTxt.text = foodName
    }

}