package com.geeks.presentation.ui.fragments.maps

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.presentation.R
import com.geeks.presentation.base.BaseFragment
import com.geeks.presentation.databinding.FragmentMapsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : BaseFragment<FragmentMapsBinding, MapsViewModel>(R.layout.fragment_maps) {

    override val binding: FragmentMapsBinding by viewBinding(FragmentMapsBinding::bind)
    override val viewModel: MapsViewModel by viewModels()

}