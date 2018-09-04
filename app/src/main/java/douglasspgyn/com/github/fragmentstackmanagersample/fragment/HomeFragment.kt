package douglasspgyn.com.github.fragmentstackmanagersample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.fragmentstackmanager.base.BaseStackFragment
import douglasspgyn.com.github.fragmentstackmanagersample.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Douglas on 4/9/18.
 */

class HomeFragment : BaseStackFragment() {

    private val fragmentName: String = "Home"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarTitle(fragmentName)
        text.text = fragmentName

        innerFragment.setOnClickListener {
            pushFragment(InnerFragment().newInstance(fragmentName, 0))
        }
    }
}