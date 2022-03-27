package com.gulshan.sirfstudymessanger.ui.home.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.adapters.AllChatsAdapter
import com.gulshan.sirfstudymessanger.databinding.FragmentChatBinding
import com.gulshan.sirfstudymessanger.databinding.FragmentGroupChatBinding
import com.gulshan.sirfstudymessanger.network.response.chats.SingleChatItem
import com.gulshan.sirfstudymessanger.repository.ChatRepository
import com.gulshan.sirfstudymessanger.util.Resource


class GroupChatFragment : Fragment() {
    lateinit var binding: FragmentChatBinding
    lateinit var viewModel: GroupChatViewModel
    lateinit var chatsAdapter: AllChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chatRepository = ChatRepository()
        val viewModelProviderFactory = GroupChatViewModelProviderFactory(chatRepository)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory)[GroupChatViewModel::class.java]
        setupRV()
        initData()
    }

    private fun initData() {
        viewModel.groupChatList.observe(viewLifecycleOwner) { response ->
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

    private fun navigateToIndividualChat(it: SingleChatItem) {
        val bundle = Bundle().apply {
            putSerializable("selectedChatItem", it)
        }
        findNavController().navigate(R.id.action_groupChatFragment_to_chatScreen, bundle)
    }


}