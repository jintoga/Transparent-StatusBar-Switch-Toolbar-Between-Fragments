package com.enterra.android.switchtoolbarbetweenfragmentsdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.navigationView)
    protected NavigationView nvDrawer;
    @Bind(R.id.drawerLayout)
    protected DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nvDrawer.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            nvDrawer.getMenu().performIdentifierAction(R.id.frag1, 0);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        //Closing drawer on item click
        mDrawer.closeDrawers();
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
            default:
                return true;
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        return false;
    }
}
