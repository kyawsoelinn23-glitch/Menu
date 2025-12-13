package com.example.home_menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtHello: TextView
    lateinit var btnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtHello = findViewById(R.id.txtHello)
        registerForContextMenu(txtHello)

        btnButton = findViewById(R.id.btnButton)
        btnButton.setOnClickListener {
            val popupMenu = PopupMenu(this, btnButton)
            popupMenu.menuInflater.inflate(R.menu.actionmenu, popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.home -> {
                        Toast.makeText(this, "Home Click", Toast.LENGTH_SHORT).show()
                    }

                    R.id.category -> {
                        Toast.makeText(this, "Category Click", Toast.LENGTH_SHORT).show()
                    }

                    R.id.setting -> {
                        Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Home Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.category -> {
                Toast.makeText(this, "Category Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.setting -> {
                Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.actionmenu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Home Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.category -> {
                Toast.makeText(this, "Category Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.setting -> {
                Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}