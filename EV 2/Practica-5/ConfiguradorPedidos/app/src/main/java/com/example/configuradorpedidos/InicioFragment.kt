
package com.example.configuradorpedidos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// Fragmento de inicio que permite al usuario iniciar un nuevo pedido.  
class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el layout para este fragmento y asigna el binding.  
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el listener para el botón que inicia un nuevo pedido.  
        binding.btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpia el binding para evitar fugas de memoria.  
        _binding = null
    }
}  