package com.mayank.managementsevakriti.worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.mayank.managementsevakriti.R
import com.mayank.managementsevakriti.fragmentWorker.FinanceFragment
import com.mayank.managementsevakriti.fragmentWorker.HomeFragment
import com.mayank.managementsevakriti.fragmentWorker.LogOutFragment
import com.mayank.managementsevakriti.fragmentWorker.ProfileFragment

class WorkerHome : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var  previousMenuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_home)



        drawerLayout = findViewById(R.id.drawer_layout)
        coordinatorLayout = findViewById(R.id.coordinator)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.fragment_container)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()
        openHome()


        val actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem != null){
                previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){
                R.id.homes -> {
                    openHome()
                }
                R.id.profile -> {
                    openProfile()
                }
                R.id.transaction -> {
                    openFinance()
                }
                R.id.logout -> {
                    openLogout()
                }
                }
            return@setNavigationItemSelectedListener true
        }
    }

    fun setUpToolbar(){
        //setSupportActionBar(toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openHome(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,HomeFragment()).addToBackStack("Home").commit()
        drawerLayout.closeDrawers()
        supportActionBar?.title = "Home"
        navigationView.setCheckedItem(R.id.homes)
    }

    fun openProfile(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ProfileFragment()).addToBackStack("Home").commit()
        drawerLayout.closeDrawers()
        supportActionBar?.title = "Profile"
    }

    fun openFinance(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FinanceFragment()).addToBackStack("Home").commit()
        drawerLayout.closeDrawers()
        supportActionBar?.title = "Finance"
    }

    fun openLogout(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,LogOutFragment()).addToBackStack("Home").commit()
        drawerLayout.closeDrawers()
        supportActionBar?.title = "ABC"
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.fragment_container)
        when(frag){
            !is HomeFragment -> openHome()
            else -> finishAffinity()//finish()
        }
    }

}