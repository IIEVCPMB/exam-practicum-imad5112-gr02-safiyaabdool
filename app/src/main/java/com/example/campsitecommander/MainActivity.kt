package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val itemNames = ArrayList<String>()
    private val categories = ArrayList<String>()
    private val quantities = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComment = findViewById<EditText>(R.id.edtComment)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        itemNames.add("Tent")
        categories.add("Shelter")
        quantities.add(1)
        comments.add("4 Person Waterproof")

        itemNames.add("Marshmallows")
        categories.add("Food")
        quantities.add(3)
        comments.add("For Smores")

        itemNames.add("Flashlight")
        categories.add("Safety")
        quantities.add(2)
        comments.add("Check batteries")

        updateTotal(txtTotal)

        btnAdd.setOnClickListener {

            if (
                edtItem.text.isEmpty() ||
                edtCategory.text.isEmpty() ||
                edtQuantity.text.isEmpty() ||
                edtComment.text.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please complete all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                itemNames.add(edtItem.text.toString())
                categories.add(edtCategory.text.toString())
                quantities.add(edtQuantity.text.toString().toInt())
                comments.add(edtComment.text.toString())

                updateTotal(txtTotal)

                Toast.makeText(
                    this,
                    "Item Added",
                    Toast.LENGTH_SHORT
                ).show()

                edtItem.text.clear()
                edtCategory.text.clear()
                edtQuantity.text.clear()
                edtComment.text.clear()
            }
        }

        btnView.setOnClickListener {

            val intent =
                Intent(this, DetailActivity::class.java)

            intent.putStringArrayListExtra(
                "items",
                itemNames
            )

            intent.putStringArrayListExtra(
                "categories",
                categories
            )

            intent.putIntegerArrayListExtra(
                "quantities",
                quantities
            )

            intent.putStringArrayListExtra(
                "comments",
                comments
            )

            startActivity(intent)
        }
    }

    private fun updateTotal(textView: TextView) {

        var total = 0

        for (qty in quantities) {
            total += qty
        }

        textView.text = "Total Items Packed: $total"
    }
}