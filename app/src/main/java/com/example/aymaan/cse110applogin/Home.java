package com.example.aymaan.cse110applogin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.List;

public class Home extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.homePageLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final CompactCalendarView compactCalendarView = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        final ListView listView = (ListView) findViewById(R.id.home_list);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent to EventActivity", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void onNavigationMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                Intent h = new Intent(Home.this, Home.class);
                startActivity(h);
                break;
            case R.id.nav_mygroups:
                Intent g = new Intent(Home.this, MyGroups.class);
                startActivity(g);
                break;
            case R.id.nav_settings:
                Intent s = new Intent(Home.this, AccountSettings.class);
                startActivity(s);
                break;
            case R.id.nav_logout:
                Intent l= new Intent(Home.this,LoginActivity.class);
                startActivity(l);
                break;
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.homePageLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void onGroupNavigationMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.group_nav_noticeBoard:
                Intent nb = new Intent(Home.this, NoticeBoard.class);
                startActivity(nb);
                break;
            case R.id.group_nav_members:
                Intent gm = new Intent(Home.this, NoticeBoard.class);
                startActivity(gm);
                break;
            case R.id.group_nav_heatmap:
                Intent h = new Intent(Home.this, NoticeBoard.class);
                startActivity(h);
                break;
            case R.id.group_nav_contactAdmin:
                Intent ca= new Intent(Home.this,NoticeBoard.class);
                startActivity(ca);
                break;
            case R.id.group_nav_relatedGroups:
                Intent rg = new Intent(Home.this, NoticeBoard.class);
                startActivity(rg);
                break;
            case R.id.group_nav_leaveGroup:
                break;
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.homePageLayout);
        mDrawerLayout.closeDrawer(GravityCompat.END);
    }

    public void onFilterMenuItemClick(MenuItem item) {
        Drawable icon = item.getIcon();

        Drawable checked = this.getResources().getDrawable(R.drawable.baseline_radio_button_checked_24);
        Drawable unchecked = this.getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24);

        // First time will always be false, but there is no problem as everything will be unchecked in the beginning.
        if (icon.getConstantState().equals(checked.getConstantState())) {
            item.setIcon(unchecked);
        } else {
            item.setIcon(checked);
        }
    }
}
