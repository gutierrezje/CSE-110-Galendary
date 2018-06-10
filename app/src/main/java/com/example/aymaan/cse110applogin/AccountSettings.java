package com.example.aymaan.cse110applogin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import com.example.jeff.database_access.GroupObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pablo on 5/14/2018.
 */

public class AccountSettings extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private android.support.v7.widget.Toolbar mToolbar;

    private Button changePw;
    private EditText editName;
    private Button deleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.accountSettingsLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        changePw = (Button) findViewById(R.id.changePassw);
        deleteAccount = (Button) findViewById(R.id.deleteAccountButton);
        editName=(EditText) findViewById(R.id.usName);
        editName.setText(LoginActivity.userLogin.getName());

        changePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chP= new Intent(AccountSettings.this,PasswordChange.class);
                startActivity(chP);
            }
        });

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //public void onBackPressed() { }

    public void onNavigationMenuItemClick(MenuItem item) {
        int id=item.getItemId();
        switch (id){

            case R.id.nav_home:
                Intent h= new Intent(AccountSettings.this,Home.class);
                startActivity(h);
                break;
            case R.id.nav_mygroups:
                Intent g= new Intent(AccountSettings.this,MyGroups.class);
                startActivity(g);
                break;
            case R.id.nav_settings:
                Intent s= new Intent(AccountSettings.this,AccountSettings.class);
                startActivity(s);
                break;
            case R.id.nav_logout:
                Intent l= new Intent(AccountSettings.this,LoginActivity.class);
                l.putExtra("logout", true);
                startActivity(l);
                break;
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.accountSettingsLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
