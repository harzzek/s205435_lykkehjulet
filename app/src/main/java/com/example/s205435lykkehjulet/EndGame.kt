package com.example.s205435lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.s205435lykkehjulet.databinding.FragmentEndGameBinding
import com.example.s205435lykkehjulet.databinding.FragmentFortuneWheelBinding


class EndGame : Fragment() {

    private var _binding: FragmentEndGameBinding? = null
    private val binding get() = _binding!!
    private val gameData : GameDataFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEndGameBinding.inflate(inflater, container, false)
        val view = binding.root

        if(gameData.player.playerLife == 0)
        {
            binding.endMessage.text = "Game lost!\nScore: ${gameData.player.playerScore}"
        } else
        {
            binding.endMessage.text = "Game win!\nScore: ${gameData.player.playerScore}"
        }

        binding.endMessage.setOnClickListener()
        {
            Navigation.findNavController(view).navigate(R.id.action_endGame_to_startScreen)
        }

        return view
    }

}