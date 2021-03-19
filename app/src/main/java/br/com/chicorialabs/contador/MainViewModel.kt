package br.com.chicorialabs.contador

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val mContador =  MutableLiveData<String>().apply {
        this.value = contador.toString()
    }

    private var contador: Int = 0

    fun adiciona(){
        contador++
        validaContador()
    }

    private fun validaContador() {
        if(contador > 5) {
            contador = 0
        }
        mContador.value = contador.toString()
    }



}