package br.com.chicorialabs.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.chicorialabs.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    private val dadosBtn: Button by lazy {
        binding.mainDadosBtn
    }
    private val mostrarBtn: Button by lazy {
        binding.mainMostrarBtn
    }
    private val editTxt: EditText by lazy {
        binding.mainEdt
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initDados()
        initDadosBtn()
        initMostrarBtn()

    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.mContador.observe(this, {
            editTxt.setText(it.toString())
        })

    }

    private fun initMostrarBtn() {
        mostrarBtn.setOnClickListener {
            Toast.makeText(applicationContext,
                "Contador do ViewModel: ${mViewModel.mContador.value}",
                Toast.LENGTH_SHORT).show()
        }
    }


    private fun initDadosBtn() {

        dadosBtn.setOnClickListener {
            mViewModel.adiciona()

        }
    }




}