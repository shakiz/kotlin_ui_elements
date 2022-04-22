package com.practice.uielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.practice.uielements.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showAlertDialog.setOnClickListener { showAlert() }

        binding.showBasicAlert.setOnClickListener { showBasicAlert() }

        binding.showAlertDialogRounded.setOnClickListener { showAlertDialogRounded() }

        binding.showBottomSheet.setOnClickListener { showBottomSheet() }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout Confirmation")
        builder.setMessage("Do you want to logout from the app?")
        builder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(
                applicationContext,
                "Logged out", Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(
                applicationContext,
                "Stay with us", Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNeutralButton("Maybe") { dialog,
                                            which ->
            Toast.makeText(
                applicationContext,
                "Not sure", Toast.LENGTH_SHORT
            ).show()
        }

        builder.show();
    }

    private fun showBasicAlert() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Basic Alert")
            setMessage("Basic alert dialog message")
            setPositiveButton("Ok") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Ok Clicked", Toast.LENGTH_SHORT
                ).show()
            }
            setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Cancel Clicked", Toast.LENGTH_SHORT
                ).show()
            }
            show()
        }
    }

    private fun showAlertDialogRounded() {
        val dialog: AlertDialog = MaterialAlertDialogBuilder(this, R.style.RoundedMaterialDialog)
            .setView(R.layout.dialog_layout_rounded)
            .show()
        dialog.findViewById<View>(R.id.closeButton)!!.setOnClickListener { dialog.dismiss() }
    }

    private fun showBottomSheet(){
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.layout_bottom_sheet)
        val closeBtn = dialog.findViewById<View>(R.id.ivClose)
        closeBtn!!.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}