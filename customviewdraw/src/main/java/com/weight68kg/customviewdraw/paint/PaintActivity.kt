package com.weight68kg.customviewdraw.paint

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.weight68kg.customviewdraw.PageFragment
import com.weight68kg.customviewdraw.PageModel
import com.weight68kg.customviewdraw.R
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_paint.*

class PaintActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, PaintActivity::class.java))
        }
    }

    var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.string.title_paint_shader,R.layout.paint_shader))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)


        pager.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getCount(): Int = pageModels.size


            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(pageModel.practiceLayoutRes)
            }

            override fun getPageTitle(position: Int): CharSequence {
                return getString(pageModels[position].titleRes)
            }
        })

        tabLayout.setupWithViewPager(pager)
    }
}
