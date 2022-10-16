package com.example.android_tab_layout_view_pager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.android_tab_layout_view_pager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

//        val myViewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
//        val myTabLayout = findViewById<TabLayout>(R.id.tablayout)

        val myViewPager2: ViewPager2 = binding.viewpager2
        val myTabLayout: TabLayout = binding.tablayout

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 3
            }

            // Aquí es donde abriremos un fragment cuando se pulse en uno de los tabs
            override fun createFragment(position: Int): Fragment {
                if (position == 0) {
                    return BlueFragment()
                }

                if (position == 1) {
                    return RedFragment()
                }

                return GreenFragment()
            }

        }
        myViewPager2.adapter = adapter
    }
}