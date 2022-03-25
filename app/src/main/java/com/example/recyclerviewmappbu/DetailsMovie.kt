package com.example.recyclerviewmappbu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewmappbu.databinding.DetailsMovieBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailsMovie : BottomSheetDialogFragment() {

    private var binding: DetailsMovieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.details_movie, container, false)

        binding?.nameCardMovie?.text = arguments?.getString("nameMovie").toString()
        binding?.longCardMovie?.text = arguments?.getString("longMovie").toString()
        binding?.actorsCardMovie?.text = arguments?.getString("actorsMovie").toString()
        binding?.ratingCardMovie?.text = arguments?.getString("ratingMovie").toString()

        return binding?.root
    }


}