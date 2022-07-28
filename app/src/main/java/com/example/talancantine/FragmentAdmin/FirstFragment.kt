package com.example.talancantine.FragmentAdmin

import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.talancantine.R

class FirstFragment : Fragment() {

    lateinit var imageView: ImageView
    lateinit var button: Button
    private val pickImage = 100
    private var imageUri: Uri? = null


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_first, container, false)
        return view}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //spinner
        val categories = resources.getStringArray(R.array.categories)
        val spinner = view.findViewById<Spinner>(R.id.spinner_categorie)
        if (spinner != null) {
            val adapter = activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_item,
                    categories
                )
            }
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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


        // selectionner une image de la gallerie

        imageView = view.findViewById(R.id.imagePlat)
        button = view.findViewById(R.id.buttonAjouter)
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
                imageUri = data?.data
                imageView.setImageURI(imageUri)
                }


        }



        }}




