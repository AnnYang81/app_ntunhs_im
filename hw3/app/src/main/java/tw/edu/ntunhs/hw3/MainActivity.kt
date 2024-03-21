package tw.edu.ntunhs.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup

import android.app.DatePickerDialog

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idEditText: EditText = findViewById(R.id.idEditText)
        val accountEditText: EditText = findViewById(R.id.accountEditText)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val dobEditText: EditText = findViewById(R.id.dobEditText)
        val genderRadioGroup: RadioGroup = findViewById(R.id.genderRadioGroup)
        val carCheckBox: CheckBox = findViewById(R.id.carCheckBox)
        val bikeCheckBox: CheckBox = findViewById(R.id.bikeCheckBox)
        val motorcycleCheckBox: CheckBox = findViewById(R.id.motorcycleCheckBox)
        val metroCheckBox: CheckBox = findViewById(R.id.metroCheckBox)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val id = idEditText.text.toString()
            val account = accountEditText.text.toString()
            val name = nameEditText.text.toString()
            val dob = dobEditText.text.toString()
            val gender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.maleRadioButton -> "男"
                R.id.femaleRadioButton -> "女"
                else -> ""
            }
            val transportTypes = mutableListOf<String>()
            if (carCheckBox.isChecked) {
                transportTypes.add("car")
            }
            if (bikeCheckBox.isChecked) {
                transportTypes.add("bike")
            }
            if (motorcycleCheckBox.isChecked) {
                transportTypes.add("motorcycle")
            }
            if (metroCheckBox.isChecked) {
                transportTypes.add("metro")
            }

            val selectedTransport = transportTypes.joinToString(", ")

            val dialogMessage =
                "ID: $id\nPassword: $account\nName: $name\nBirthDate: $dob\nGender: $gender\nVehicle: $selectedTransport"

            val builder = AlertDialog.Builder(this)
            builder.setTitle("User Information")
            builder.setMessage(dialogMessage)
            builder.setPositiveButton("OK", null)
            val dialog = builder.create()
            dialog.show()
        }
    }
}