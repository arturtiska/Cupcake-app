/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentPickupBinding
import com.example.cupcake.model.OrderViewModel

/**
 * [PickupFragment] permite que o usuário escolha uma data de retirada para o pedido de cupcake.
 */
class PickupFragment : Fragment() {

    // Instância de objeto de ligação correspondente ao layout fragment_pickup.xml
    // Esta propriedade não é nula entre os retornos de chamada do ciclo de vida onCreateView() e onDestroyView(),
    // quando a hierarquia de exibição é anexada ao fragmento.
    private var binding: FragmentPickupBinding? = null
    private val sharedViewModel: OrderViewModel  by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding?.apply {
          lifecycleOwner = viewLifecycleOwner
          viewModel = sharedViewModel
          pickupFragment = this@PickupFragment
      }
    }

    /**
     * Navegue até a próxima tela para ver o resumo do pedido.
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }

    /**
       Este método de ciclo de vida do fragmento é chamado quando a hierarquia de visualização associada ao fragmento
     * está sendo removido. Como resultado, limpe o objeto de ligação.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}