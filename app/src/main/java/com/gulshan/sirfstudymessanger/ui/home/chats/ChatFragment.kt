package com.gulshan.sirfstudymessanger.ui.home.chats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.adapters.AllChatsAdapter
import com.gulshan.sirfstudymessanger.databinding.FragmentChatBinding
import com.gulshan.sirfstudymessanger.network.response.chats.SingleChatItem
import com.gulshan.sirfstudymessanger.repository.ChatRepository
import com.gulshan.sirfstudymessanger.ui.chat.ChatScreen
import com.gulshan.sirfstudymessanger.util.Resource

class ChatFragment : Fragment() {
    lateinit var binding: FragmentChatBinding
    lateinit var viewModel: ChatViewModel
    lateinit var chatsAdapter: AllChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chatRepository = ChatRepository()
        val viewModelProviderFactory = ChatViewModelProviderFactory(chatRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[ChatViewModel::class.java]
        setupRV()

        viewModel.chatList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        chatsAdapter.differ.submitList(response.data.data)
                    }
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }
        initListeners()
    }

    private fun navigateToIndividualChat(it: SingleChatItem) {
        val bundle = Bundle().apply {
            putSerializable("selectedChatItem", it)
        }
        findNavController().navigate(R.id.action_chatFragment_to_chatScreen, bundle)
    }

    private fun setupRV() {
        chatsAdapter = AllChatsAdapter()
        binding.rvChat.apply {
            adapter = chatsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        chatsAdapter.setOnItemClickListener {
            navigateToIndividualChat(it)
        }
    }

    private fun initListeners() {
    }


}