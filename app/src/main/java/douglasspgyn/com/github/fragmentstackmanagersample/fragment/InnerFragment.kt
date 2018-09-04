package douglasspgyn.com.github.fragmentstackmanagersample.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import douglasspgyn.com.github.fragmentstackmanager.base.BaseStackFragment
import douglasspgyn.com.github.fragmentstackmanagersample.R
import kotlinx.android.synthetic.main.fragment_inner.*
import java.util.*

/**
 * Created by Douglas on 4/9/18.
 */

class InnerFragment : BaseStackFragment() {

    fun newInstance(message: String, number: Int): InnerFragment {
        val bundle: Bundle = Bundle().apply {
            putString("message", message)
            putInt("number", number + 1)
        }

        return InnerFragment().apply { arguments = bundle }
    }

    /**
     * Generate a random to show or not the Options Menu, just to test
     */
    private var showOptionsMenu: Boolean = (Random().nextInt(10) + 1) % 2 == 0
    private var message: String = ""
    private var number: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_inner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message = arguments?.getString("message") ?: ""
        number = arguments?.getInt("number") ?: 0

        toolbarTitle(messageAndNumber())
        text.text = messageAndNumber()

        innerFragment.setOnClickListener {
            pushFragment(InnerFragment().newInstance(message, number))
        }
    }

    private fun messageAndNumber(): String = "$message\nInner $number"

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (showOptionsMenu) {
            hasMenu.text = "Menu Enabled"
            inflater?.inflate(R.menu.menu_inner, menu)
        } else {
            super.onCreateOptionsMenu(menu, inflater)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_info -> Toast.makeText(context, messageAndNumber(), Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}