package com.example.talancantine.FragmentAdmin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.talancantine.R
import com.example.talancantine.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val  binding get() = _binding!!

    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onResume() {
        super.onResume()
        buttonAjouter.setOnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
                imageUri = data?.data
                imagePlat.setImageURI(imageUri)
            }


        }


    }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //spinner
        val categories = resources.getStringArray(R.array.categories)
        if (spinner_categorie != null) {
            val adapter = activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_item,
                    categories
                )
            }
            spinner_categorie.adapter = adapter

            spinner_categorie.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(
                        context,
                        getString(R.string.selected_item1) + " " +
                                "" + categories[p2], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }

            }


        }



        buttonValiderplat.setOnClickListener {
            Toast.makeText(context,"DISH CREATED", Toast.LENGTH_SHORT).show()

        }



        }
}




