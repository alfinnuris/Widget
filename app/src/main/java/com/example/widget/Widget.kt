package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

//membuat variabel binding nya
    private lateinit var binding:ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //memanggi bindig root
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "ini adalah Toast", Toast.LENGTH_SHORT).show()

        }

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah snackbar", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnAlert.setOnClickListener {

            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("ini adalah Alert")

                setPositiveButton("Ok") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda klik OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("Back") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda klik Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()
        }
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }

    }
}
