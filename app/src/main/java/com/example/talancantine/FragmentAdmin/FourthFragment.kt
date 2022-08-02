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
import kotlinx.android.synthetic.main.fragment_fourth.*
import java.text.SimpleDateFormat
import java.util.*

class FourthFragment : Fragment() {
    private var formatDate= SimpleDateFormat("dd MMMM YYYY", Locale.US)
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val types_entree = resources.getStringArray(R.array.types_entrees)
        val arrayAdapter1 = ArrayAdapter(requireContext(),R.layout.list_items,types_entree)
        binding.dropdownFieldEntree.setAdapter(arrayAdapter1)
        val types_principal = resources.getStringArray(R.array.types_principal)
        val arrayAdapter2 = ArrayAdapter(requireContext(),R.layout.list_items,types_principal)
        binding.dropdownFieldPlat.setAdapter(arrayAdapter2)
        val types_dessert = resources.getStringArray(R.array.types_desserts)
        val arrayAdapter3 = ArrayAdapter(requireContext(),R.layout.list_items,types_dessert)
        binding.dropdownFieldDessert.setAdapter(arrayAdapter3)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSecondBinding.inflate(inflater,container,false)

        return binding.root
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
                val date : String = formatDate.format(selectDate.time)
                Toast.makeText(context," Date : "+date, Toast.LENGTH_SHORT).show()
                txt_view_date_picked.text=date

            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })
    }
    }



