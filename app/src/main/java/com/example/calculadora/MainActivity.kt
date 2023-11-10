package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var texto: String = ""
    private var reg: String = ""

    override fun onSaveInstanceState(outState: Bundle) {
        if (outState != null) {
            super.onSaveInstanceState(outState)
            outState.putString("texto", texto)
            outState.putString("registro", reg)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        if (savedInstanceState != null) {
            texto = savedInstanceState.getString("texto").toString()
            binding.operaciones.text = texto
            reg = savedInstanceState.getString("registro",).toString()
            binding.registro.text = reg

        }




        binding.botonCero.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
        binding.botonCuatro.setOnClickListener(this)
        binding.botonCinco.setOnClickListener(this)
        binding.botonSeis.setOnClickListener(this)
        binding.botonSiete.setOnClickListener(this)
        binding.botonOcho.setOnClickListener(this)
        binding.botonNueve.setOnClickListener(this)

        binding.botonReset.setOnClickListener(this)
        binding.botonNegativoPositivo.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)
        binding.botonComa.setOnClickListener(this)

        binding.botonDivision.setOnClickListener(this)
        binding.botonMultiplicacion.setOnClickListener(this)
        binding.botonResta.setOnClickListener(this)
        binding.botonSuma.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonRaizcuadrada?.setOnClickListener(this)
        binding.botonPi?.setOnClickListener(this)
        binding.botonCoseno?.setOnClickListener(this)
        binding.botonSeno?.setOnClickListener(this)
        binding.botonTangente?.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {

            // Funcionalidad texto en la calcu
            binding.botonCero.id -> texto += "0"
            binding.botonUno.id -> texto += "1"
            binding.botonDos.id -> texto += "2"
            binding.botonTres.id -> texto += "3"
            binding.botonCuatro.id -> texto += "4"
            binding.botonCinco.id -> texto += "5"
            binding.botonSeis.id -> texto += "6"
            binding.botonSiete.id -> texto += "7"
            binding.botonOcho.id -> texto += "8"
            binding.botonNueve.id -> texto += "9"
            binding.botonReset.id -> texto = ""
            binding.botonNegativoPositivo.id -> texto = (texto.toInt() * -1).toString()
            binding.botonPorcentaje.id -> texto = formatoResultado((texto.toInt() * 0.01))
            binding.botonComa.id -> texto += "."
            binding.botonSuma.id -> texto += "+"
            binding.botonResta.id -> texto += "-"
            binding.botonDivision.id -> texto += "/"
            binding.botonMultiplicacion.id -> texto += "x"
            binding.botonRaizcuadrada?.id -> texto = formatoResultado(Math.sqrt(texto.toDouble()))
            binding.botonPi?.id -> texto = Math.PI.toString()
            binding.botonCoseno?.id -> texto = formatoResultado(Math.cos(texto.toDouble()))
            binding.botonSeno?.id -> texto = formatoResultado(Math.sin(texto.toDouble()))
            binding.botonTangente?.id -> texto = formatoResultado(Math.tan(texto.toDouble()))





            binding.botonIgual.id -> {
                var input = binding.operaciones.text
                if(input.isNotEmpty()) {
                    if(input.contains("+")) {
                        var operacionDividida = input.split("+")
                        if(operacionDividida.size == 2) {
                            var op1 = operacionDividida[0].toDouble()
                            var op2 = operacionDividida[1].toDouble()
                            var result = op1 + op2
                            reg = texto + ("=").toString()
                            texto = result.toString()
                        }
                    } else if (input.contains("-")) {
                        var operacionDividida = input.split("-")
                        if(operacionDividida.size == 2) {
                            var op1 = operacionDividida[0].toDouble()
                            var op2 = operacionDividida[1].toDouble()
                            var result = op1 - op2
                            reg = texto + ("=").toString()
                            texto = result.toString()
                        }
                    } else if (input.contains("x")) {
                        var operacionDividida = input.split("x")
                        if(operacionDividida.size == 2) {
                            var op1 = operacionDividida[0].toDouble()
                            var op2 = operacionDividida[1].toDouble()
                            var result = op1 * op2
                            reg = texto + ("=").toString()
                            texto = result.toString()
                        }
                    } else if (input.contains("/")) {
                        var operacionDividida = input.split("/")
                        if(operacionDividida.size == 2) {
                            var op1 = operacionDividida[0].toDouble()
                            var op2 = operacionDividida[1].toDouble()
                            var result = op1 / op2
                            reg = texto + ("=").toString()
                            texto = result.toString()
                        }
                    }
                }
            }
        }
        binding.operaciones.text = texto
        binding.registro.text = reg
    }
    fun formatoResultado (valor : Double): String {
        if(valor % 1 == 0.0) {
            return valor.toInt().toString()
        } else {
            return valor.toString()
        }
    }
}