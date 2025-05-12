package com.example.agng

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {

    // Datos de usuarios con sus fotos (sin contraseñas)
    private val userProfiles = listOf(
        UserProfile("Longas", R.drawable.test_photo),
        UserProfile("Sergio", R.drawable.test_photo),
        UserProfile("Hupa", R.drawable.test_photo)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val usersGrid: GridView = view.findViewById(R.id.usersGrid)
        val adapter = UserGridAdapter(requireContext(), userProfiles)
        usersGrid.adapter = adapter

        usersGrid.setOnItemClickListener { _, _, position, _ ->
            // Navegar directamente al siguiente fragmento al seleccionar usuario
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ViewPagerFragment())
                .commit()
        }

        return view
    }
}

data class UserProfile(val name: String, val photoResId: Int)

class UserGridAdapter(
    context: android.content.Context,
    private val userProfiles: List<UserProfile>
) : ArrayAdapter<UserProfile>(context, 0, userProfiles) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val user = getItem(position)!!
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_user, parent, false)

        view.findViewById<ImageView>(R.id.userImage).setImageResource(user.photoResId)
        view.findViewById<TextView>(R.id.userName).text = user.name

        return view
    }
}