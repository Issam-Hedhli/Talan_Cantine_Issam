package com.example.talancantine.FragmentAdmin

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import com.example.talancantine.ActivityCricketers
import com.example.talancantine.Cricketer
import kotlinx.android.synthetic.main.fragment_third.*
import java.text.SimpleDateFormat
import java.util.*


class ThirdFragment : Fragment(), View.OnClickListener {
    var formatDate = SimpleDateFormat("dd MMMM YYYY", Locale.US)
    var layoutList: LinearLayout? = null
    var buttonAdd: Button? = null
    var buttonSubmitList: Button? = null

    var teamList: List<String> = ArrayList()
    var cricketersList: ArrayList<Cricketer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.talancantine.R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // date de la creation de menu du jour
        button_date_picked.setOnClickListener(View.OnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                requireContext(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datepicker, i, i2, i3 ->


                    val selectDate: Calendar = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date: String = formatDate.format(selectDate.time)
                    Toast.makeText(context, " Date : " + date, Toast.LENGTH_SHORT).show()
                    txt_view_date_picked.text = date

                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()
        })

            layoutList = view.findViewById(com.example.talancantine.R.id.layout_list)
            buttonAdd = view.findViewById(com.example.talancantine.R.id.button_add)
            buttonAdd!!.setOnClickListener(this)
            teamList.add("Team")
            teamList.add("India")
            teamList.add("Australia")
            teamList.add("England")
        }

    override fun onClick(v: View) {
        when (v.id) {
            com.example.talancantine.R.id.button_add -> addView()
            com.example.talancantine.R.id.button_submit_list -> if (checkIfValidAndRead()) {
                val intent = Intent(context, ActivityCricketers::class.java)
                val bundle = Bundle()
                bundle.putSerializable("list", cricketersList)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun checkIfValidAndRead(): Boolean {
        cricketersList.clear()
        var result = true
        for (i in 0 until layoutList!!.childCount) {
            val cricketerView = layoutList!!.getChildAt(i)
            val editTextName =
                cricketerView.findViewById<View>(com.example.talancantine.R.id.edit_cricketer_name) as EditText
            val spinnerTeam =
                cricketerView.findViewById<View>(com.example.talancantine.R.id.spinner_team) as AppCompatSpinner
            val cricketer = Cricketer()
            if (editTextName.text.toString() != "") {
                cricketer.setCricketerName(editTextName.text.toString())
            } else {
                result = false
                break
            }
            if (spinnerTeam.selectedItemPosition != 0) {
                cricketer.setTeamName(teamList[spinnerTeam.selectedItemPosition])
            } else {
                result = false
                break
            }
            cricketersList.add(cricketer)
        }
        if (cricketersList.size == 0) {
            result = false
            Toast.makeText(requireContext(), "Add Cricketers First!", Toast.LENGTH_SHORT).show()
        } else if (!result) {
            Toast.makeText(requireContext(), "Enter All Details Correctly!", Toast.LENGTH_SHORT).show()
        }
        return result
    }

    private fun addView() {
        val cricketerView: View = layoutInflater.inflate(com.example.talancantine.R.layout.row_add_cricketer, null, false)
        val editText = cricketerView.findViewById<View>(com.example.talancantine.R.id.edit_cricketer_name) as EditText
        val spinnerTeam = cricketerView.findViewById<View>(com.example.talancantine.R.id.spinner_team) as AppCompatSpinner
        val imageClose: ImageView = cricketerView.findViewById<View>(com.example.talancantine.R.id.image_remove) as ImageView
        val adapter = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_spinner_item,
                teamList
            )
        }
        spinnerTeam.adapter = adapter
        imageClose.setOnClickListener(View.OnClickListener { removeView(cricketerView) })
        layoutList!!.addView(cricketerView)
    }

    private fun removeView(view: View) {
        layoutList!!.removeView(view)
    }
    }

private fun <E> List<E>.add(e: E) {

}

