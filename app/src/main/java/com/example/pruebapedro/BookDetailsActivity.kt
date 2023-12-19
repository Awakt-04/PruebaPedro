package com.example.pruebapedro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var txtautor : EditText
    private lateinit var txtanho : EditText
    private lateinit var boton : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details_activity)

        var libros = intent.getParcelableArrayListExtra<Book>("libros")
        val titulo = intent.getStringExtra("titulo")
        val paginas = intent.getStringExtra("paginas")

        txtautor = findViewById<EditText>(R.id.autor)
        txtanho = findViewById<EditText>(R.id.anho)
        boton = findViewById<Button>(R.id.bContinuar2)

        boton.setOnClickListener {
            val intent = Intent(this,BookDisplayActivity::class.java)
                intent.putParcelableArrayListExtra("libros",libros)
            intent.putExtra("titulo",titulo)
            intent.putExtra("paginas",paginas)
            intent.putExtra("autor",txtautor.text.toString())
            intent.putExtra("anho",txtanho.text.toString())
            startActivity(intent)
        }

    }
}

/*


    private lateinit var txtautor : EditText
    private lateinit var txtanho : EditText
    private lateinit var boton : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details_activity)

        val libro = intent.getParcelableExtra<Book>("libro")

        txtautor = findViewById<EditText>(R.id.autor)
        txtanho = findViewById<EditText>(R.id.anho)
        boton = findViewById<Button>(R.id.bContinuar2)

        val libro2 = Book(libro?.getTitle(),libro?.getPages(),txtautor.toString(),txtanho.toString().toInt())

        boton.setOnClickListener {
            val intent = Intent(this,BookDisplayActivity::class.java)
            intent.putExtra("libro",libro2)
            startActivity(intent)
        }
    }
 */