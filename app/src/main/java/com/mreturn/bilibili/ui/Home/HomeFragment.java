package com.mreturn.bilibili.ui.Home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mreturn.bilibili.R;
import com.mreturn.bilibili.adapter.HomePagerAdapter;
import com.mreturn.bilibili.ui.MainActivity;
import com.mreturn.bilibili.ui.base.BaseLazyFragment;
import com.mreturn.bilibili.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomeFragment extends BaseLazyFragment {

    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle state) {
        setHasOptionsMenu(true);
        initTooBar();
        initSearchView();
        initViewPager();
    }

    private void initTooBar() {
        toobar.setTitle("");
        ((MainActivity)getActivity()).setSupportActionBar(toobar);
    }

    private void initSearchView() {
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ToastUtil.show(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initViewPager() {
        HomePagerAdapter adapter = new HomePagerAdapter(getContext(),getChildFragmentManager());
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(adapter);
        slidingTab.setViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main_menu,menu);
        MenuItem item = menu.findItem(R.id.item_home_search);
        searchView.setMenuItem(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home_game:
                ToastUtil.show("game");
                break;
            case R.id.item_home_download:
                ToastUtil.show("download");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.ll_top_user)
    void toggleDrawer(){
        Activity activity = getActivity();
        if (activity instanceof MainActivity){
            ((MainActivity) activity).toggleDrawer();
        }
    }

    public boolean isSearchViewOpen(){
        return searchView.isSearchOpen();
    }

    public void closeSearchView(){
        searchView.closeSearch();
    }
}
