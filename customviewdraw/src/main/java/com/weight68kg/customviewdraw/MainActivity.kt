package com.weight68kg.customviewdraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.weight68kg.customviewdraw.paint.PaintActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var pageModels: MutableList<PageModel> = ArrayList()

    init {
        pageModels.add(PageModel(R.string.title_draw_arc, R.layout.practice_arc))
//        pageModels.add(PageModel( R.string.title_draw_argb, R.layout.practice_argb))
//        pageModels.add(PageModel( R.string.title_draw_bitmap, R.layout.practice_bitmap))
//        pageModels.add(PageModel( R.string.title_draw_circle, R.layout.practice_circle))
//        pageModels.add(PageModel( R.string.title_draw_line, R.layout.practice_line))
//        pageModels.add(PageModel( R.string.title_draw_oval, R.layout.practice_oval))
//        pageModels.add(PageModel( R.string.title_draw_path, R.layout.practice_path))
//        pageModels.add(PageModel( R.string.title_draw_point, R.layout.practice_point))
//        pageModels.add(PageModel( R.string.title_draw_rect, R.layout.practice_rect))
//        pageModels.add(PageModel( R.string.title_draw_round_rect, R.layout.practice_round_rect))
//        pageModels.add(PageModel( R.string.title_draw_text, R.layout.practice_text))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PaintActivity.start(this)

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
