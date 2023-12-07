package com.example.assignment15.messages

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment15.BaseFragment
import com.example.assignment15.databinding.FragmentHomePageBinding
import kotlinx.coroutines.launch

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {
    private val viewModel: MessagesFragmentViewModel by viewModels()
    private lateinit var messagesAdapter: MessagesRecyclerAdapter

    override fun setUp() {
        messagesAdapter = MessagesRecyclerAdapter()

        with(binding) {
            messagesRecycler.layoutManager = LinearLayoutManager(requireContext())
            messagesRecycler.setHasFixedSize(true)
            messagesRecycler.adapter = messagesAdapter
        }
    }

    override fun bindViewActionListeners() { //ქ ჩაიწერება რო ღილაკზე კლიკისას დასერჩოს
        binding.btnSearch.setOnClickListener{
            viewModel.addNewMessages()
        }
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.messagesFlow.collect {
                    messagesAdapter.submitList(it)
                }
            }
        }
    }

}