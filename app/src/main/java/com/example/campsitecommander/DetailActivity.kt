package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtDetails =
            findViewById<TextView>(R.id.txtDetails)

        val btnBack =
            findViewById<Button>(R.id.btnBack)

        val items =
            intent.getStringArrayListExtra("items")

        val categories =
            intent.getStringArrayListExtra("categories")

        val quantities =
            intent.getIntegerArrayListExtra("quantities")

        val comments =
            intent.getStringArrayListExtra("comments")

        var display = ""

        if (
            items != null &&
            categories != null &&
            quantities != null &&
            comments != null
        ) {

            for (i in items.indices) {

                display +=
                    "Item: ${items[i]}\n" +
                            "Category: ${categories[i]}\n" +
                            "Quantity: ${quantities[i]}\n" +
                            "Comment: ${comments[i]}\n\n"
            }
        }

        txtDetails.text = display

        btnBack.setOnClickListener {
            finish()
        }
    }
}