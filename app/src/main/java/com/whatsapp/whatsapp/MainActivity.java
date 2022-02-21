package com.whatsapp.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.whatsapp.whatsapp.databinding.ActivityMainBinding;
import com.whatsapp.whatsapp.ui.main.ViewPagerAdapter;
import com.whatsapp.whatsapp.ui.main.calls.CallsFragment;
import com.whatsapp.whatsapp.ui.main.chats.ChatsFragment;
import com.whatsapp.whatsapp.ui.main.status.StatusFragment;
import com.whatsapp.whatsapp.utils.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ActivityMainBinding mBinding;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setSupportActionBar(mBinding.toolbar);
        init();
        listener();
        setTabs();
    }

    private void init() {
        mContext = this;
        mFab = mBinding.fab;

    }

    private void listener() {

        mFab.setOnClickListener(v -> {
            if (mFab.getTag().equals(getResources().getString(R.string.tag_chats))) {
                onChat(v);
            } else if (mFab.getTag().equals(getResources().getString(R.string.tag_status))) {
                onStatus(v);
            } else if (mFab.getTag().equals(getResources().getString(R.string.tag_incoming_calls))) {
                onIncomingCall(v);
            } else {
                onChat(v);
            }
        });

        mBinding.tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_message));
                    mFab.setTag(getResources().getString(R.string.tag_chats));
                } else if (tab.getPosition() == 1) {
                    mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_camera));
                    mFab.setTag(getResources().getString(R.string.tag_status));
                } else if (tab.getPosition() == 2) {
                    mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_incoming_call));
                    mFab.setTag(getResources().getString(R.string.tag_incoming_calls));
                } else {
                    mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_message));
                    mFab.setTag(getResources().getString(R.string.tag_chats));
                }
            }
        });
    }

    private void onChat(View view) {
        showSnackBar(view, "Chat screen running...");
    }

    private void onStatus(View view) {
        showSnackBar(view, "Status screen running...");
    }

    private void onIncomingCall(View view) {
        showSnackBar(view, "Incoming call screen running...");
    }

    private void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Done", null).show();
    }

    private void setTabs() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ChatsFragment.newInstance(), getResources().getString(R.string.title_chats));
        adapter.addFragment(StatusFragment.newInstance(), getResources().getString(R.string.title_status));
        adapter.addFragment(CallsFragment.newInstance(), getResources().getString(R.string.title_calls));
        ViewPager viewPager = mBinding.viewPager;
        viewPager.setAdapter(adapter);
        TabLayout tabs = mBinding.tabLayout;
        tabs.setupWithViewPager(viewPager);
    }

    private void setTabIcon(TabLayout.Tab tab, @DrawableRes int icon) {
        if (tab != null) {
            tab.setIcon(icon);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_screen_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                onSearch();
                return true;
            case R.id.action_new_group:
                onCreateNewGroup();
                return true;
            case R.id.action_new_broadcast:
                onCreateNewBroadcast();
                return true;
            case R.id.action_linked_devices:
                onLinkedDevices();
                return true;
            case R.id.action_starred_messages:
                onStarredMessages();
                return true;
            case R.id.action_settings:
                onSettings();
                return true;
            default:
                return false;
        }
    }

    private void onSearch() {

    }

    private void onCreateNewGroup() {

    }

    private void onCreateNewBroadcast() {

    }

    private void onLinkedDevices() {

    }

    private void onStarredMessages() {

    }

    private void onSettings() {

    }

}