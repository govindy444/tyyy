package com.example.tyyy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.devrevtesst.CustomNetworkSDK
import com.example.devrevtesst.NetworkCallback
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)


    }

    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> LetestMoviesFragment()
                1 -> PopularMoviesFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }

        override fun getCount(): Int {
            return 2 // Number of tabs
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Letest"
                1 -> "Popular"
                else -> null
            }
        }
    }

}