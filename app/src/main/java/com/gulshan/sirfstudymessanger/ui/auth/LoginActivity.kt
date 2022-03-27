package com.gulshan.sirfstudymessanger.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.databinding.ActivityMainBinding
import com.gulshan.sirfstudymessanger.repository.AuthRepository
import com.gulshan.sirfstudymessanger.ui.home.BaseActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val authRepository = AuthRepository()
        val viewModelProviderFactory = AuthViewModelProviderFactory(authRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        init()

    }

    private fun init() {
        observe()
        binding.apply {
            buttonLogin.setOnClickListener {
                viewModel.login()
            }
        }
    }

    private fun observe() {
        viewModel.errorString.observe(this) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginStatus.observe(this) {
            if (it) {
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            }
        }
    }
}