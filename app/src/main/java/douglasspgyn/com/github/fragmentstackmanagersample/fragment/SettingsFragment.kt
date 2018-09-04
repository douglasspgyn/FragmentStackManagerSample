package douglasspgyn.com.github.fragmentstackmanagersample.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import douglasspgyn.com.github.fragmentstackmanager.base.BaseStackFragment
import douglasspgyn.com.github.fragmentstackmanagersample.R
import kotlinx.android.synthetic.main.fragment_settings.*

/**
 * Created by Douglas on 4/9/18.
 */

class SettingsFragment : BaseStackFragment() {

    private val fragmentName: String = "Settings"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarTitle(fragmentName)
        text.text = fragmentName

        innerFragment.setOnClickListener {
            pushFragment(InnerFragment().newInstance(fragmentName, 0))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_settings, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_exit -> Toast.makeText(context, "Exit", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}