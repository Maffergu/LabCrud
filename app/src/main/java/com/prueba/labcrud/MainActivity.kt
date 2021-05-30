package com.prueba.labcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val items : MutableList<String> = mutableListOf()
    private val adaptador = Adaptador({
            clickListener -> showItemClick(clickListener)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")
        adaptador.setItems(items)



        cambio.setOnClickListener{

            items.add("Prueba 5")


            adaptador.setItems(items)
        }



        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    fun showItemClick(position:Int){
        val item = adaptador.getItem(position)
        //Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
        items.remove(item)
        adaptador.setItems(items)
    }
}