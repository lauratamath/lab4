package com.example.laboratorio4.Models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentTouristicPlacesBinding
import kotlinx.android.synthetic.main.fragment_touristic_places.*

class TouristicPlaces : Fragment() {
    private var placetoshow: String? = "Xocomil" //default
    private lateinit var binding: FragmentTouristicPlacesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_touristic_places, container, false)

        //Getting place chose
        arguments?.let {
            placetoshow = it.getString("actual_place")
        }

        //Changing view
        changeTextViews()

        //Go to comment fragment
        binding.submitComment.setOnClickListener {
            val actualcomment = comment.getText().toString()
            val bundle = bundleOf ("new_comment" to actualcomment)

            view!!.findNavController().navigate(R.id.action_TouristicPlaces_to_comment, bundle)
        }

        return binding.root

    }


    //Shows actual info
    private fun changeTextViews(){

        //Changes title, subtitle and text depending on bundle String
        if (placetoshow == "Xocomil") {
            binding.placeName = getString(R.string.xocomil_title)
            binding.placeInfo = getString(R.string.xocomil_info)
            binding.placePhrase = getString(R.string.xocomil_phrase)
        } else if (placetoshow == "Semuc Champey") {
            binding.placeName = getString(R.string.semuc_title)
            binding.placeInfo = getString(R.string.semuc_champey_info)
            binding.placePhrase = getString(R.string.secum_champey_phrase)
        } else {
            binding.placeName = getString(R.string.rio_title)
            binding.placeInfo = getString(R.string.rio_dulce_info)
            binding.placePhrase = getString(R.string.rio_phrase)
        }
    }





}
