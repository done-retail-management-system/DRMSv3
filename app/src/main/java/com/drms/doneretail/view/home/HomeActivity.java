
package com.drms.doneretail.view.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.widget.GridLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.drms.doneretail.R;
import com.drms.doneretail.adapter.ViewPagerHeaderAdapter;
import com.drms.doneretail.adapter.RecyclerViewHomeAdapter;
import com.drms.doneretail.model.Categories;
import com.drms.doneretail.model.Meals;

import butterknife.BindView;
import butterknife.ButterKnife;

// TODO 31 implement the HomeView interface at the end
public class HomeActivity extends AppCompatActivity {

    /*
     * TODO 32 Add @BindView Annotation (1)
     *
     * 1. viewPagerHeader
     * 2. recyclerCategory
     *
     */

    /*
     *  TODO 33 Create variable for presenter;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*
         *  TODO 34 bind the ButterKnife (2)
         */

        /*
         *  TODO 35 Declare the presenter
         *  new HomePresenter(this)
         */
    }

    // TODO 36 Overriding the interface

}
