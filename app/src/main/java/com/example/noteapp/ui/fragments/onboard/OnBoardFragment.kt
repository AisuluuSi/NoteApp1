package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        val adapter = PagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {_, _->}.attach()
    }

    private fun setupListeners() = with(binding.viewPager) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) = with(binding) {
                super.onPageSelected(position)
                if (position == 2) {
                    txtSkip.visibility = View.INVISIBLE
                }
                else {
                    txtSkip.visibility = View.VISIBLE
                    binding.txtSkip.setOnClickListener {
                        setCurrentItem(currentItem +2, true)
                    }
                    if (position ==2) {
                        txtStart.visibility = View.VISIBLE
                    }
                    else {
                        txtStart.visibility = View.INVISIBLE
                        binding.txtStart.setOnClickListener {
                            setCurrentItem(currentItem +2, true)
                        }
                    }
                }
            }
        })
    }

}