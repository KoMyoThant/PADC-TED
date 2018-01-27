package com.ps.ted.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ps.ted.R;
import com.ps.ted.adapters.TabPagerAdapter;
import com.ps.ted.data.model.TEDModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private TabPagerAdapter tabPagerAdapter;

    @BindView(R.id.vp_ted_tab)
    ViewPager vpTedTab;

    @BindView(R.id.tl_tabs)
    TabLayout tabLayout;

    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;

    private TEDModel mTedModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.accent));
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary));

        // Viewpager with fragment
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        vpTedTab.setAdapter(tabPagerAdapter);

        tabLayout.setupWithViewPager(vpTedTab);

        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent searchIntent = SearchActivity.newIntent(getApplicationContext());
                startActivity(searchIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
