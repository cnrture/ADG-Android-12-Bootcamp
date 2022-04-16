package com.canerture.ad12bootcampconnecttotheinternet.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canerture.ad12bootcampconnecttotheinternet.R
import com.canerture.ad12bootcampconnecttotheinternet.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    private val viewModel: OverviewViewModel by lazy { OverviewViewModel() }

    private val charactersAdapter by lazy { CharactersAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.rvCharacters.adapter = charactersAdapter

        charactersAdapter.onClick = {
            viewModel.displayCharacterDetail(it)
        }

        viewModel.navigateToSelectedCharacter.observe(viewLifecycleOwner) {

            if (it != null) {
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayCharacterDetailComplete()
            }
        }

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.filterCharacters(
            when (item.itemId) {
                R.id.show_gryffindor -> HarryPotterApiFilter.SHOW_GRYFFINDOR
                R.id.show_hufflepuff -> HarryPotterApiFilter.SHOW_HUFFLEPUFF
                R.id.show_ravenclaw -> HarryPotterApiFilter.SHOW_RAVENCLAW
                else -> HarryPotterApiFilter.SHOW_SLYTHERIN
            }
        )
        return true
    }
}