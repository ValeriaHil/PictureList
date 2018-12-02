package com.example.lenovo.hw2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lenovo.hw2.pictures.PicturesContent
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture_detail.*
import kotlinx.android.synthetic.main.picture_detail.view.*

/**
 * A fragment representing a single Picture detail screen.
 * This fragment is either contained in a [PictureListActivity]
 * in two-pane mode (on tablets) or a [PictureDetailActivity]
 * on handsets.
 */
class PictureDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: PicturesContent.PictureItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = PicturesContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
//                activity?.toolbar_layout?.title =
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.picture_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
//            rootView.picture_detail.text = it.download_link
            Picasso.get().load(it.download_link).into(rootView.picture_detail)
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
