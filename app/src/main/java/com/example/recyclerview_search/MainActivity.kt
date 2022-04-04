package com.example.recyclerview_search

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.RadioButton
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf(
        Movie(" Torvalds t", "Dublin", R.drawable.pcture1,199,
        "Hi im specialized in C# and programing"),

        Movie("Rich-Harris", "Dublin",R.drawable.pcture2, 101,
        "Hi im especialized in jva and C#"),

        Movie("Jake Wharton", "Corck",R.drawable.pcture3, 99,
             "Hi im especialized website and programing"),

        Movie("Newtoneinstein", "Belfest",R.drawable.pcture5, 155,
        "C#/java and web design fone 085 299 2356"),

        Movie("Eliabe Baliero", "Dublin",R.drawable.eli, 130,
            "Hi im especialized in jva and C# and web design"),


        Movie("Microsoft", "USA", R.drawable.microsoft,199,
        "microsoft company"),

        Movie("Uber", "USA", R.drawable.uber,199,
            "uber company"),

        Movie("Facebook", "USA", R.drawable.face,199,
            "facebook company"),

        Movie("Ultrabot", "USA", R.drawable.ultrabot,199,
            "ultrabot company")

    )




    private var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))


        radioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            var rb =  findViewById<RadioButton>(i)
            if(rb!=null)
                radio_text.setText(rb.text.toString())
        }



        val rv = findViewById(R.id.list_recycler_view) as RecyclerView

        val layoutManager = LinearLayoutManager(getApplicationContext())
        adapter = RecyclerViewAdapter(movies)

        rv.setAdapter(adapter)
        rv.setLayoutManager(layoutManager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setQueryHint("Search View Hint")

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.getFilter()?.filter(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                adapter?.getFilter()?.filter(query)
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}
