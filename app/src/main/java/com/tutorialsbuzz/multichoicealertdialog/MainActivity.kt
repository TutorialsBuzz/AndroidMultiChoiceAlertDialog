package com.tutorialsbuzz.multichoicealertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    val multiChoiceList = linkedMapOf<String, Boolean>(
        "English" to false,
        "Hindi" to false,
        "French" to false,
        "Spanish" to false,
        "Portuguese" to false,
        "German" to false,
        "Italian" to false,
        "Korean" to false,
        "Japanese" to false,
        "Chinese" to false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun multiChoiceDialog(view: View) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Languages")

        builder.setMultiChoiceItems(multiChoiceList.keys.toTypedArray(),
            multiChoiceList.values.toBooleanArray(), { dialogInterface, which, isChecked ->

                multiChoiceList.set(multiChoiceList.keys.toTypedArray().get(which), isChecked)

                val status = if (isChecked) {
                    " :is checked"
                } else {
                    " :is un-checked"
                }

                Toast.makeText(
                    this@MainActivity,
                    "item: " + multiChoiceList.keys.toTypedArray().get(which) + status, Toast.LENGTH_SHORT
                ).show()

            })

        builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
            Log.d("Selected Items", multiChoiceList.toString())
            dialog.dismiss()
        })
        builder.setNegativeButton("cancel", { dialog, id ->
            dialog.dismiss()
        })

        val alertDialog = builder.create()
        alertDialog.show()
    }

}
