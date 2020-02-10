package com.example.laboratorio4.Models

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*
import android.view.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.R


class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    var changeEditText:Boolean?=true
    private var placechose = "place_chose"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_title, container, false)
        //Keyboard
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //Menu
        setHasOptionsMenu(true)

        //Get name from user
        binding.starButton.setOnClickListener{
            if (changeEditText == true){ //Hides editText and button
                val nameValue = name_value.getText().toString()
                binding.GuatemalaName.text = nameValue //Shows new name
                binding.nombre.setVisibility(View.GONE)
                name_value.setVisibility(View.GONE)

                changeEditText = false
            } else { //Shows editText and button
                binding.GuatemalaName.text = "Guatemala" //Shows default name
                binding.nombre.setVisibility(View.VISIBLE)
                name_value.setVisibility(View.VISIBLE)

                changeEditText = true
            }
        }

        //Show Xocomil info on text views
        binding.buttonXocomil.setOnClickListener{
            placechose = "Xocomil"
            val bundle = bundleOf ("actual_place" to placechose)


            view!!.findNavController().navigate(R.id.action_titleFragment_to_touristicPlaces, bundle)
        }
        //Show Rio Dulce info on text views
        binding.buttonRioDulce.setOnClickListener{
            placechose = "Rio Dulce"
            val bundle = bundleOf ("actual_place" to placechose)

            view!!.findNavController().navigate(R.id.action_titleFragment_to_touristicPlaces, bundle)
        }
        //Show Semuc Champey info on text views
        binding.buttonSemuc.setOnClickListener{
           placechose = "Semuc Champey"
            val bundle = bundleOf ("actual_place" to placechose)

            view!!.findNavController().navigate(R.id.action_titleFragment_to_touristicPlaces, bundle)
        }


        return binding.root
    }


    //Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    //Item Selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }



}
