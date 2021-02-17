package com.koreait.actionbarapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.koreait.actionbarapp.chat.ChatFragment;
import com.koreait.actionbarapp.gallery.GalleryFragment;
import com.koreait.actionbarapp.mp3.MusicFragment;

public class ExamViewPagerAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[3];

    public ExamViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        fragments[0] = new YellowFragment();
        fragments[1] = new RedFragment();
        fragments[2] = new BlueFragment();
    }

    public int getCount() {
        return fragments.length;
    }

    public Fragment getItem(int position) {
        return fragments[position];
    }
}
