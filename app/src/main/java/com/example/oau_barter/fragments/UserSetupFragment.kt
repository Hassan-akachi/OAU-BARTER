package com.example.oau_barter.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.oau_barter.databinding.UserSetupBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class UserSetupFragment : Fragment() {  //uses to binding view
    private var _binding: UserSetupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Dailoglisterner()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {  //destroy previous view

        _binding = null
        super.onDestroyView()
    }


    fun Dailoglisterner() {
        binding.apply {
            aboutYouself.setOnClickListener { showDailog("aboutYouself",aboutYouself,InputType.TYPE_CLASS_TEXT) }
            department.setOnClickListener {
             showDailog("department",department,InputType.TYPE_CLASS_TEXT)
            }
            phoneNumber.setOnClickListener { showDailog("PhoneNumber",phoneNumber,InputType.TYPE_CLASS_NUMBER) }
            mail.setOnClickListener { showDailog("Mail",mail,InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS) }
            whatsappInfo.setOnClickListener { showDailog("whatsAppInfo",whatsappInfo,InputType.TYPE_CLASS_NUMBER) }
        }

    }
    fun showDailog(title:String,mainView: TextView,textType: Int){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        val constraintLayout = EditText(context)
        constraintLayout.setHint("Enter Text")
        constraintLayout.inputType = textType
        builder.setView(constraintLayout)
        builder.setPositiveButton(
            "enter",
            DialogInterface.OnClickListener { dialog, which ->
                var sendText = constraintLayout.text
                mainView.text= sendText.toString()
            })
        builder.setNegativeButton("cancel",DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
        builder.setCancelable(true)
        val dailog = builder.create()
        dailog.show()
    }
}