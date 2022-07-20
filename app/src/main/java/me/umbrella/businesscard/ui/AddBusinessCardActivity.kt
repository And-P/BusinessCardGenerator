package me.umbrella.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.umbrella.businesscard.App
import me.umbrella.businesscard.R
import me.umbrella.businesscard.data.BusinessCard
import me.umbrella.businesscard.databinding.ActivityAddBusinesssCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinesssCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard (
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
                )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}