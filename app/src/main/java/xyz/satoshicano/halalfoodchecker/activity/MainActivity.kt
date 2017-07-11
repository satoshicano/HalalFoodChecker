package xyz.satoshicano.halalfoodchecker.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import xyz.satoshicano.halalfoodchecker.R
import xyz.satoshicano.halalfoodchecker.fragment.DictionaryFragment
import xyz.satoshicano.halalfoodchecker.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private var navigationView: NavigationView? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null

    private var activityTitles: Array<String>? = null

    private var mHandler: Handler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        mHandler = Handler()
        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.nav_view) as NavigationView

        activityTitles = resources.getStringArray(R.array.nav_item_activity_titles)

        loadNavHeader()
        setUpNavigationView()

        if (savedInstanceState == null) {
            navItemIndex = 0
            CURRENT_TAG = TAG_HOME
            loadHomeFragment()
        }
    }

    private fun loadNavHeader() {
        navigationView!!.menu.getItem(3).setActionView(R.layout.menu_dot)
    }

    private fun loadHomeFragment() {
        selectNavMenu()
        setToolbarTitle()

        if (supportFragmentManager.findFragmentByTag(CURRENT_TAG) != null) {
            drawer!!.closeDrawers()
            return
        }

        val mPendingRunnable = Runnable {
            val fragment = homeFragment
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out)
            fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG)
            fragmentTransaction.commitAllowingStateLoss()
        }

        mHandler!!.post(mPendingRunnable)

        drawer!!.closeDrawers()
        invalidateOptionsMenu()
    }

    private val homeFragment: Fragment
        get() {
            when (navItemIndex) {
                0 -> return HomeFragment()
                1 -> return DictionaryFragment()
                else -> return HomeFragment()
            }
        }

    private fun setToolbarTitle() {
        supportActionBar!!.title = activityTitles!![navItemIndex]
    }

    private fun selectNavMenu() {
        navigationView!!.menu.getItem(navItemIndex).isChecked = true
    }

    private fun setUpNavigationView() {
        navigationView!!.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navItemIndex = 0
                    CURRENT_TAG = TAG_HOME
                }
                R.id.nav_dictionary -> {
                    navItemIndex = 1
                    CURRENT_TAG = TAG_DICTIONARY
                }
                R.id.nav_find_halal_camera -> {
                    startActivity(Intent(this@MainActivity, FindHalalCameraActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_barcode_camera ->
                    // startActivity(new Intent(MainActivity.this, BarcodeReader.class));
                    return@OnNavigationItemSelectedListener true
                else -> navItemIndex = 0
            }

            menuItem.isChecked = !menuItem.isChecked
            menuItem.isChecked = true

            loadHomeFragment()

            true
        })


        val actionBarDrawerToggle = object : ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }
        }

        drawer!!.setDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawers()
            return
        }

        if (navItemIndex != 0) {
            navItemIndex = 0
            CURRENT_TAG = TAG_HOME
            loadHomeFragment()
            return
        }

        super.onBackPressed()
    }

    companion object {

        var navItemIndex = 0

        private val TAG_HOME = "home"
        private val TAG_DICTIONARY = "dictionary"
        var CURRENT_TAG = TAG_HOME
    }
}