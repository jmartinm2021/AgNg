package com.example.agng

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.agng.TopScreen
import com.example.agng.ScreenPoint

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3 // Número de pestañas
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScreenPoint() // Fragment para la pestaña 1
            1 -> TopScreen() // Fragment para la pestaña 2
            2 -> CocktailScreen() // Fragment para la pestaña 3
            else -> throw IllegalStateException("Posición no válida: $position")
        }
    }
}
