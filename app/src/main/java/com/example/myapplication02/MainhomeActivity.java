package com.example.myapplication02;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import me.relex.circleindicator.CircleIndicator3;

//상품진열
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainhomeActivity extends FragmentActivity  {
    private ViewPager2 mPager;
    private ViewPager2 mPager01;   //01붙은거는 슬라이드2변수

    private FragmentStateAdapter pagerAdapter;
    private FragmentStateAdapter pagerAdapter01;
    private final int num_page = 4;    //viewpager2에 2개의 페이지가 표시됨.
    private final int num_page01 = 4;
    private CircleIndicator3 mIndicator;
    private CircleIndicator3 mIndicator01;

                    //슬라이드1 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainhome);

        // ViewPager2
        mPager = findViewById(R.id.viewpager);
        mPager01 = findViewById(R.id.viewpager01);
        // Adapter
        FragmentStateAdapter pagerAdapter = new MyAdapter(this, num_page);//
        mPager.setAdapter(pagerAdapter);

        FragmentStateAdapter pagerAdapter01 = new MyAdapter01(this, num_page01);
        mPager01.setAdapter(pagerAdapter01);

        // Indicator 초기화 및 설정
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);     //indicator와 ViewPager2이 연동됨
        mIndicator.createIndicators(num_page, 0);

        mIndicator01 = findViewById(R.id.indicator01);
        mIndicator01.setViewPager(mPager01);     //indicator와 ViewPager2이 연동됨
        mIndicator01.createIndicators(num_page01, 0);
        // ViewPager2 설정
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);  //슬라이드방향(수평)
        mPager.setCurrentItem(1000);           // 시작 지점
        mPager.setOffscreenPageLimit(2);       // 최대 이미지 수

        mPager01.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);  //슬라이드방향(수평)
        mPager01.setCurrentItem(1000);           // 시작 지점
        mPager01.setOffscreenPageLimit(2);

        //쇼핑 상품
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2); //가로2개
        recyclerView.setLayoutManager(layoutManager);
        final ProductdAdapter adapter = new ProductdAdapter();

        adapter.addItem(new Productmain("천연비누", "4000원" ,  R.drawable.menu01img));
        adapter.addItem(new Productmain("천연 수세미", "3500원" , R.drawable.menu01img));
        adapter.addItem(new Productmain("천연비누", "4000원" ,  R.drawable.menu01img));
        adapter.addItem(new Productmain("천연 수세미", "3500원" , R.drawable.menu01img));

        recyclerView.setAdapter(adapter);


        //페이지 변경 이벤트 리스너 등록
        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position % num_page);
            }
        });
                            //슬라이드2
        mPager01.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager01.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator01.animatePageSelected(position % num_page01);
            }
        });

    }
}