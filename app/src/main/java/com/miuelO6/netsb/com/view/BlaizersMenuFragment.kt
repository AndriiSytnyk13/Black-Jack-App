package com.miuelO6.netsb.com.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.miuelO6.netsb.com.R
import com.miuelO6.netsb.com.viewmodel.BlaizersMenuViewModel
import com.miuelO6.netsb.com.databinding.FragmentBlaizersMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlaizersMenuFragment : Fragment() {

    private lateinit var blaizersMenuFragmentBinding: FragmentBlaizersMenuBinding


    private val blaizersMenuViewModel: BlaizersMenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        blaizersMenuFragmentBinding =
            FragmentBlaizersMenuBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finishAffinity()
        }
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        return blaizersMenuFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchBlaizersDataBinding()
        playBlaizersGame()
        navigateToBlaizersRules()
        quitBlaizersGame()
    }

    private fun fetchBlaizersDataBinding() {
        blaizersMenuFragmentBinding.blaizersMenuVieModel = blaizersMenuViewModel
        blaizersMenuFragmentBinding.lifecycleOwner = viewLifecycleOwner
    }

    private fun playBlaizersGame() {
        blaizersMenuFragmentBinding.blaizersPlay.setOnClickListener {
            if (blaizersMenuViewModel.blaizersMoneyText.value == 0) {
                Toast.makeText(context, R.string.blaizersNotEnoughChipsToPlay, Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(R.id.blaizersGameFragment)
            }
        }
    }

    private fun navigateToBlaizersRules() {
        blaizersMenuFragmentBinding.blaizersRules.setOnClickListener {
            findNavController().navigate(R.id.blaizersRulesFragment)
        }
    }

    private fun quitBlaizersGame() {
        blaizersMenuFragmentBinding.blaizersQuit.setOnClickListener {
            requireActivity().finishAffinity()
        }
    }

}