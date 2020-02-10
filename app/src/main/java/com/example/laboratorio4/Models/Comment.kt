package com.example.laboratorio4.Models


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ShareActionProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentCommentBinding


class Comment : Fragment() {
    private lateinit var shareActionProvider: ShareActionProvider
    private lateinit var binding: FragmentCommentBinding
    private var comment: String? = "HOLAAA" //default


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_comment, container, false)
        //Get comment
        arguments?.let {
            comment = it.getString("new_comment")
        }
        binding.commentByUser = comment

        //Keyboard
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //Menu
        setHasOptionsMenu(true)

        //Return to principal fragment
        binding.buttonReturn.setOnClickListener{
            view!!.findNavController().navigate(CommentDirections.actionFragmentCommentToTitleFragment())
        }


        return binding.root
    }


    //Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_option, menu)
    }
    //Item Selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        //Showing sharing options
        if (item.itemId == R.id.share){
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, comment)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Compartir a:"))
        }

        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
    }

}
