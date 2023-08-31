package com.example.appdozero.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appdozero.R

class PessoaFragment : Fragment() {

    companion object {
        fun newInstance() = PessoaFragment()
    }

    private lateinit var viewModel: PessoaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pessoa, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PessoaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}