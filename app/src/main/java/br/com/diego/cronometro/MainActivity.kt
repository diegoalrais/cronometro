package br.com.diego.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import br.com.diego.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var running = false
    private var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnInicar.setOnClickListener {
            iniciarCronometro()
        }

        binding.btnPausar.setOnClickListener {
            pausarCronometro()
        }

        binding.btnZerar.setOnClickListener {
            zerarCronometro()
        }

        binding.btnSair.setOnClickListener {
            finish()
        }

    }

     private fun iniciarCronometro(){
        if(!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true
        }
    }

    private fun pausarCronometro() {
        if(running) {
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun zerarCronometro() {
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }

}