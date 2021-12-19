package com.example.fragmentmodule.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.fragmentmodule.R
import com.example.fragmentmodule.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartagena = args.poicartagena
        with(detailBinding){
            nombreTextView.text = cartagena.nombre
            Picasso.get().load(cartagena.urlpic).into(imagenImageView)
            contenidoTextView.text = cartagena.descripCorta
            tempTextView.text = cartagena.temperatura
        }
    }

}