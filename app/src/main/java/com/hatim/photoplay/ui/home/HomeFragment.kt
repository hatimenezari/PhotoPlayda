package com.hatim.photoplay.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.hatim.photoplay.R

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by hiltNavGraphViewModels(R.id.mobile_navigation)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getDocuments()
        homeViewModel.documents.observe(viewLifecycleOwner){
            val documents = view.findViewById<RecyclerView>(R.id.documents)
            documents.adapter = DocumentsAdapter(
                it
            )
        }
    }
}