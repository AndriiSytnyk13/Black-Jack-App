package com.miuelO6.netsb.com.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miuelO6.netsb.com.viewmodel.BlaizersGameViewModel
import com.miuelO6.netsb.com.databinding.FragmentBlaizersGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlaizersGameFragment : Fragment() {

    private lateinit var blaizersGameFragmentBinding: FragmentBlaizersGameBinding

    private val blaizersGameViewModel: BlaizersGameViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        blaizersGameFragmentBinding =
            FragmentBlaizersGameBinding.inflate(inflater, container, false)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        return blaizersGameFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchBlaizersDataBinding()
        observeBlaizersCards()
    }

    private fun fetchBlaizersDataBinding() {
        blaizersGameFragmentBinding.blaizersGameViewModel = blaizersGameViewModel
        blaizersGameFragmentBinding.lifecycleOwner = viewLifecycleOwner
    }

    private fun observeBlaizersCards() {
        blaizersGameViewModel.blaizersUserCard1.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard1.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersUserCard2.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard2.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersUserCard3.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard3.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersUserCard4.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard4.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersUserCard5.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard5.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersUserCard6.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersUserCard6.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard1.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard1.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard2.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard2.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard3.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard3.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard4.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard4.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard5.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard5.setBackgroundResource(it)
        }

        blaizersGameViewModel.blaizersDealerCard6.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersDealerCard6.setBackgroundResource(it)
        }



        blaizersGameViewModel.blaizersPointsVisibility.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.apply {
                blaizersUserPoints.visibility = it
                blaizersDealerPoints.visibility = it
            }
        }
        blaizersGameViewModel.blaizersActionsVisibility.observe(viewLifecycleOwner) {
            blaizersGameFragmentBinding.blaizersActions.visibility = it
        }
    }

}