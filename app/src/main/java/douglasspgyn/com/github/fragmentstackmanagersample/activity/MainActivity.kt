package douglasspgyn.com.github.fragmentstackmanagersample.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Toast
import douglasspgyn.com.github.fragmentstackmanager.`interface`.FragmentStackManager
import douglasspgyn.com.github.fragmentstackmanager.base.BaseStackActivity
import douglasspgyn.com.github.fragmentstackmanagersample.R
import douglasspgyn.com.github.fragmentstackmanagersample.fragment.HomeFragment
import douglasspgyn.com.github.fragmentstackmanagersample.fragment.SettingsFragment
import douglasspgyn.com.github.fragmentstackmanagersample.fragment.PhotoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseStackActivity(R.id.contentLayout, 1),
        BottomNavigationView.OnNavigationItemSelectedListener,
        FragmentStackManager.OnBackPressed {

    /**
     * Used to verify if show the message or finish the app
     */
    private var exitTimer: Long = 0
    override fun bottomNavigationView(): BottomNavigationView = bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(this)
        setOnStackBackPressedListener(this)
    }

    override fun getRootFragment(position: Int): Fragment {
        return when (position) {
            0 -> PhotoFragment()
            1 -> HomeFragment()
            2 -> SettingsFragment()
            else -> HomeFragment()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_photo -> {
                updateStack(0)
                true
            }
            R.id.navigation_home -> {
                updateStack(1)
                true
            }
            R.id.navigation_settings -> {
                updateStack(2)
                true
            }
            else -> false
        }
    }

    override fun onStackEnded() {
        if (exitTimer + 2000 > System.currentTimeMillis())
            finish()
        else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_LONG).show()
        }

        exitTimer = System.currentTimeMillis()
    }
}
