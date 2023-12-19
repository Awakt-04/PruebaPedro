package com.example.pruebapedro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDisplayActivity: AppCompatActivity() {

    private lateinit var txtlibros :TextView
    private lateinit var boton :Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_display_activity)

        val libro = Book(intent.getStringExtra("titulo"),intent.getStringExtra("paginas")?.toInt(),
            intent.getStringExtra("autor").toString(),intent.getStringExtra("anho").toString().toInt())

        var libros = arrayListOf<Book>()
        libros.add(libro)

        txtlibros = findViewById(R.id.libros)

        var txt = ""
        for(libro in libros) {
            txt += libro.toString() + "\n"
        }

        txtlibros.setText(txt.toCharArray(),0,txt.toCharArray().size)

        boton = findViewById(R.id.bVuelta)

        boton.setOnClickListener {
            val intent = Intent(this,BookTitleActivity::class.java)
            intent.putParcelableArrayListExtra("libros",libros)
            startActivity(intent)
        }


    }
}

/*

    private lateinit var libros :TextView
    private lateinit var boton :Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_display_activity)

        val libro3 = intent.getParcelableExtra<Book>("libro")

        libros = findViewById(R.id.libros)

        libros.text = libro3.toString()

        boton = findViewById(R.id.bVuelta)

        boton.setOnClickListener {
            val intent = Intent(this,BookTitleActivity::class.java)
            startActivity(intent)
        }


    }
}
 */