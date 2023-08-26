package com.example.appdozero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        var drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        var navView: NavigationView = findViewById(R.id.navigationView)

        /* - Parte do toolbar */
        var toolBar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)

        var btnToggle = ActionBarDrawerToggle(
            this, findViewById(R.id.drawerLayout), toolBar,
            R.string.abrir_drawer, R.string.fechar_drawer
        )
        drawerLayout.addDrawerListener(btnToggle)
        btnToggle.syncState()
        /* ----------------- */

        navView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.itemUm -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, Fragment1())
                    .commit()

                R.id.itemDois -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, Fragment2())
                    .commit()

                R.id.itemTres -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, Fragment3())
                    .commit()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_sobre -> mostrarActivitySobre()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun mostrarActivitySobre(): Boolean {
        var intent = Intent(this, SobreActivity::class.java)
        startActivity(intent)
        return true
    }

}