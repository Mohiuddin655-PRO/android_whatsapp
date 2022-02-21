package com.whatsapp.whatsapp.utils;

import com.google.android.material.tabs.TabLayout;

public interface OnTabSelectedListener extends TabLayout.OnTabSelectedListener {

    @Override
    default void onTabSelected(TabLayout.Tab tab) {
    }

    @Override
    default void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    default void onTabReselected(TabLayout.Tab tab) {
    }
}
