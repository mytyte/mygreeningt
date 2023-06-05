package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

    public class MyAdapter01 extends FragmentStateAdapter {
        public int mCount;
        public MyAdapter01(FragmentActivity fa, int count) {
            super(fa);
            mCount = count;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            int index = getRealPosition(position);

            if(index==0) return new slide_Fragment01();
            else if(index==1) return new slide_Fragment02();
            else if(index==2) return new slide_Fragment03();
            else return new slide_Fragment04();
        }

        @Override
        public int getItemCount() {
            return 2000;
        }

        public int getRealPosition(int position) { return position % mCount; }

    }
