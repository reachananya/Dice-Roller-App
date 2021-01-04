package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*displays the message when the roll button is clicked; message : Dice Rolled!
        // The findViewById() method finds the Button in the layout. R.id.button is the resource ID for the Button, which is a unique identifier for it. The code saves a reference to the Button object in a variable called rollButton*/
        val rollButton: Button = findViewById(R.id.button)
        //  A click listener is some code for what to do when a tap or click happens.
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        //create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //updates the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determine which drawable resource ID to use based on the dice roll
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }

}
class Dice(val numSides: Int){

    fun roll(): Int {
        return (1..numSides).random()
    }
}

