package douglasspgyn.com.github.fragmentstackmanagersample.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.fragmentstackmanager.base.BaseStackFragment
import douglasspgyn.com.github.fragmentstackmanagersample.R
import douglasspgyn.com.github.fragmentstackmanagersample.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.fragment_photo.*

/**
 * Created by Douglas on 4/9/18.
 */

class PhotoFragment : BaseStackFragment() {

    private val fragmentName: String = "Photo"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarTitle(fragmentName)

        recyclerView.let {
            it.layoutManager = GridLayoutManager(context, 2)
            it.adapter = PhotoAdapter()
        }
    }
}