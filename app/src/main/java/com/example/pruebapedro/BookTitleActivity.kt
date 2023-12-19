package com.example.pruebapedro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BookTitleActivity : AppCompatActivity() {

    private lateinit var txttitulo : EditText
    private lateinit var txtpaginas :EditText
    private lateinit var boton : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_title_activity)

       var libros = intent.getParcelableArrayListExtra<Book>("libros")


        txttitulo = findViewById<EditText>(R.id.titulo)
        txtpaginas = findViewById<EditText>(R.id.nPaginas)
        boton = findViewById<Button>(R.id.bContinuar)

        boton.setOnClickListener {
            val intent = Intent(this,BookDetailsActivity::class.java)
            intent.putParcelableArrayListExtra("libros",libros)
            intent.putExtra("titulo",txttitulo.text.toString())
            intent.putExtra("paginas",txtpaginas.text.toString())
            startActivity(intent)
        }

    }
}

/*


    private lateinit var txttitulo : EditText
    private lateinit var txtpaginas :EditText
    private lateinit var boton : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_title_activity)

        txttitulo = findViewById<EditText>(R.id.titulo)
        txtpaginas = findViewById<EditText>(R.id.nPaginas)

        var libro = Book(txttitulo.toString(), txtpaginas.toString().toInt(),"",0)
        boton = findViewById<Button>(R.id.bContinuar)

        boton.setOnClickListener {
            val intent = Intent(this,BookDetailsActivity::class.java)
            intent.putExtra("libro",libro)
            startActivity(intent)
        }

    }
 */