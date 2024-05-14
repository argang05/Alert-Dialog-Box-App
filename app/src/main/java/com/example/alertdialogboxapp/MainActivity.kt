package com.example.alertdialogboxapp

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialogboxapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        //Creating First Variant Of Alert Dialog Box:
        binding.buttonType1.setOnClickListener {
            //using AlertDialog class to create alert dialog box:
            //pass context as in which screen you want to create dialog box:
            val builder1 = AlertDialog.Builder(this);
            //Title:
            builder1.setTitle("Are You Sure?");
            //Inner Message:
            builder1.setMessage("Do you surely want to exit the App?:");
            //Exit Icon in Title:
            builder1.setIcon(R.drawable.baseline_exit_to_app_24);
            //Positive Button: Pass Button text and a onClickListener:
            builder1.setPositiveButton("Exit", DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Exit" is clicked?:
                finish();
            })
            //Negative Button: Pass Button text and a onClickListener:
            builder1.setNegativeButton("Stay" , DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Stay" is clicked?:
                Toast.makeText(this,"ThankYou For Staying!",Toast.LENGTH_SHORT).show();
            })
            //Show that Alert Dialog Box:
            builder1.show();
        }

        //Creating Second Variant Of Alert Dialog Box(CheckBoxes with Single Option):
        binding.buttonType2.setOnClickListener {
            val fastFoodOptions = arrayOf(
                "Burger",
                "French Fries",
                "Sandwich",
                "Milkshake",
                "Muffin"
            );
            val builder2 = AlertDialog.Builder(this);

            builder2.setTitle("Choose Your Favourite Fast Food Dish:");
            builder2.setIcon(R.drawable.baseline_fastfood_24);
            //For Displaying Checkboxes of options we will use .setSingleChoiceItems{}
            builder2.setSingleChoiceItems(
                fastFoodOptions,
                0,
                DialogInterface.OnClickListener { dialog, foodItem ->
                    //What action should be performed when user clicks on any option?:
                    //foodItem variable stores the index of the options array getting checked:
                    Toast.makeText(
                        this,
                        "You Chose: ${fastFoodOptions[foodItem]}",
                        Toast.LENGTH_SHORT
                    ).show();

                })
            //Positive Button: Pass Button text and a onClickListener:
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Submit" is clicked?:
                Toast.makeText(this,"ThankYou For Submitting!",Toast.LENGTH_SHORT).show();
            })
            //Negative Button: Pass Button text and a onClickListener:
            builder2.setNegativeButton("Exit Form" , DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Exit Form" is clicked?:
                finish();
            })
            //Show that Alert Dialog Box:
            builder2.show();
        }

        //Creating Second Variant Of Alert Dialog Box(CheckBoxes with Multiple Option):
        binding.buttonType3.setOnClickListener {
            val carOptions = arrayOf(
                "McLaren F1",
                "Ferrari Enzo",
                "Ferrari LaFerrari",
                "Porsche 918 Spyder",
                "SSC Tuatara"
            );
            val builder3 = AlertDialog.Builder(this);

            builder3.setTitle("Choose Your Favourite Supercar:");
            builder3.setIcon(R.drawable.baseline_directions_car_24);
            //For Displaying Checkboxes of options we will use .setSingleChoiceItems{}
            builder3.setMultiChoiceItems(
                carOptions,
                null,
                DialogInterface.OnMultiChoiceClickListener { dialog, car, isChecked ->
                    //What action to perform when user clicks on a checkbox?:
                    Toast.makeText(
                        this,
                        "You Chose: ${carOptions[car]}",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            )
            //Positive Button: Pass Button text and a onClickListener:
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Submit" is clicked?:
                Toast.makeText(this,"ThankYou For Submitting!",Toast.LENGTH_SHORT).show();
            })
            //Negative Button: Pass Button text and a onClickListener:
            builder3.setNegativeButton("Exit Form" , DialogInterface.OnClickListener { dialog, which ->
                //  What action should be performed when "Exit Form" is clicked?:
                finish();
            })
            //Show that Alert Dialog Box:
            builder3.show();
        }

    }
}