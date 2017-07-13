package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseRecycleViewAdapter;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.bean.RegionTyppeInfo;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.utils.CommonUtil;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/12.
 */
public class HomeRegionFragment extends BaseRxLazyFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private String[] itemNames = new String[]{
            "直播", "番剧", "动画",
            "音乐", "舞蹈", "游戏",
            "科技", "生活", "鬼畜",
            "时尚", "广告", "娱乐",
            "电影", "电视剧", "游戏中心",
    };

    private int[] itemIcons = new int[]{
            R.drawable.ic_category_live, R.drawable.ic_category_t13,
            R.drawable.ic_category_t1, R.drawable.ic_category_t3,
            R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160,
            R.drawable.ic_category_t119, R.drawable.ic_category_t155,
            R.drawable.ic_category_t165, R.drawable.ic_category_t5,
            R.drawable.ic_category_t23, R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center
    };
    private List<String> nameList = Arrays.asList(itemNames);

    private List<RegionTyppeInfo.DataBean> regionList = new ArrayList<>();
    BaseRecycleViewAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_region;
    }

    @Override
    protected void initView(Bundle state) {
        getData();
        initRecycleView();
    }

    private void getData() {
        Observable.just(CommonUtil.readAssetsJson(getActivity(), "region.json"))
                .compose(bindToLifecycle())
                .map(s -> new Gson().fromJson(s, RegionTyppeInfo.class))
                .map(RegionTyppeInfo::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<RegionTyppeInfo.DataBean>>() {
                    @Override
                    protected void onSuccess(List<RegionTyppeInfo.DataBean> dataBeen) {
                        regionList.clear();
                        regionList.addAll(dataBeen);
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                    }
                });
    }

    private void initRecycleView() {
        initAdapter();
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, BaseViewHolder holder) {
                if (position > 0 && position < 14) {
                    //TODO click
                    ToastUtil.show("retion: " + regionList.get(position).getTid());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        adapter = new BaseRecycleViewAdapter(getActivity(), nameList) {
            @Override
            public int getItemLayoutId(int layoutID) {
                return R.layout.item_home_region;
            }

            @Override
            public void bindData(BaseViewHolder holder, int position) {
                holder.setText(R.id.tv_title, nameList.get(position));
                holder.setImgResource(R.id.iv_icon, itemIcons[position]);
            }
        };
    }


}
