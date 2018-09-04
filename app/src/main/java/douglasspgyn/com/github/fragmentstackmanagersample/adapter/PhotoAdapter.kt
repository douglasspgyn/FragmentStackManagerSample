package douglasspgyn.com.github.fragmentstackmanagersample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.fragmentstackmanager.extension.pushFragment
import douglasspgyn.com.github.fragmentstackmanagersample.R
import douglasspgyn.com.github.fragmentstackmanagersample.fragment.InnerFragment

/**
 * Created by Douglas on 4/9/18.
 */

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            with(itemView) {
                setOnClickListener {
                    context.pushFragment(InnerFragment().newInstance("Recycler Pos $position", 0))
                }
            }
        }
    }
}