package com.enterra.android.switchtoolbarbetweenfragmentsdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.navigationView)
    protected NavigationView nvDrawer;
    @Bind(R.id.drawerLayout)
    protected DrawerLayout mDrawer;
    FragmentManager fragmentManager;

    int currentMenuItemId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nvDrawer.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new Fragment1())
                .commit();
            currentMenuItemId = nvDrawer.getMenu().getItem(0).getItemId();
        }

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        //Closing drawer on item click
        mDrawer.closeDrawers();
        if (currentMenuItemId != menuItem.getItemId()) {
            changeFragment(menuItem);
            currentMenuItemId = menuItem.getItemId();
        }
        return false;
    }

    private void changeFragment(MenuItem menuItem) {
        Fragment fragment = null;
        //Check to see which item was being clicked and perform appropriate action
        switch (menuItem.getItemId()) {
            case R.id.frag1:
                fragment = new Fragment1();
                break;
            case R.id.frag2:
                fragment = new Fragment2();
                break;
            case R.id.frag3:
                fragment = new Fragment3();
                break;
        }
        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
            .replace(R.id.content, fragment)
            .addToBackStack(null)
            .commit();
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(Gravity.LEFT)) {
            mDrawer.closeDrawer(Gravity.LEFT);
        } else if (currentMenuItemId == nvDrawer.getMenu().getItem(0).getItemId()) {
            finish();
        } else if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            nvDrawer.setCheckedItem(R.id.frag1);
            currentMenuItemId = nvDrawer.getMenu().getItem(0).getItemId();
        }
    }
}
