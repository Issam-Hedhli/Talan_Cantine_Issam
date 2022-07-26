package com.example.talancantine.FragmentAdmin

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.talancantine.R
import com.example.talancantine.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*
import java.text.SimpleDateFormat
import java.util.*

class SecondFragment : Fragment() {
    var formatDate= SimpleDateFormat("dd MMMM YYYY", Locale.US)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_date_picked.setOnClickListener(View.OnClickListener {
            val getDate : Calendar = Calendar.getInstance()
            val datepicker= DatePickerDialog(requireContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener{ datepicker, i, i2, i3->


                val  selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR,i)
                selectDate.set(Calendar.MONTH,i2)
                selectDate.set(Calendar.DAY_OF_MONTH,i3)
                val date : String =formatDate.format(selectDate.time)
                Toast.makeText(context," Date : "+date, Toast.LENGTH_SHORT).show()
                txt_view_date_picked.text=date

            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })

    }

    //choisir les entrées

    private lateinit var binding: FragmentSecondBinding
    fun menus(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentSecondBinding.inflate(layoutInflater)
        val items1 = resources.getStringArray(R.array.types_entrees)
        val adapter = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.activity_list_item,
                items1
            )
        }
        with(binding) {
            dropdown_field_entree.setAdapter(adapter)
        }

    }

    }

