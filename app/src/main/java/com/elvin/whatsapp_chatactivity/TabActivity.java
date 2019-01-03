package com.elvin.whatsapp_chatactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.elvin.whatsapp_chatactivity.Adapter.TabAdapter;

import org.w3c.dom.Text;

public class TabActivity extends AppCompatActivity {


    private TabAdapter tabAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabAdapter = new TabAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container_a);
        mViewPager.setAdapter(tabAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.action_contacts){
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
            intent.setData(Uri.parse("content:contacts/people/"));
            return true;
        }
        if(id==R.id.action_new_brroadcast){
            return true;
        }
        if(id==R.id.action_new_group){
            return true;
        }
        if(id==R.id.action_starred_messages){
            return true;
        }
        if(id==R.id.action_whatsapp_web){
            return true;
        }
        if(id==R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
