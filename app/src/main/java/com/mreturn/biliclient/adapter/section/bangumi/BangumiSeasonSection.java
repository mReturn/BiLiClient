package com.mreturn.biliclient.adapter.section.bangumi;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.bean.BangumiAppIndexInfo;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.NumberUtil;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class BangumiSeasonSection extends StatelessSection {

    private Context context;
    private int season;
    private List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonList;

    private String[] seasonTitles = new String[]{"1月新番", "4月新番", "7月新番", "10月新番"};
    private int[] seasonIcons = new int[]{
            R.drawable.bangumi_home_ic_season_1, R.drawable.bangumi_home_ic_season_2,
            R.drawable.bangumi_home_ic_season_3, R.drawable.bangumi_home_ic_season_4};


    public BangumiSeasonSection(Context context, int season,
                                List<BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean> seasonList) {
        super(R.layout.item_bangumi_season_head, R.layout.item_bangumi_season_body);
        this.context = context;
        this.season = season;
        this.seasonList = seasonList;
    }

    @Override
    protected int getContentItemsCount() {
        return seasonList.size();
    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        if (season > 0 && season <= seasonTitles.length) {
            holder.setText(R.id.tv_season,seasonTitles[season]);
            holder.setImgResource(R.id.iv_season,seasonIcons[season]);
        }
        holder.setClickListener(R.id.tv_all_season,v -> {
            //TODO click
            ToastUtil.show("all season");
        });
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        BangumiAppIndexInfo.ResultBean.PreviousBean.ListBean season = seasonList.get(position);

        ImageLoader.display(holder.getImageView(R.id.iv_cover),season.getCover(),R.drawable.bili_default_image_tv);
        holder.setText(R.id.tv_favourite, NumberUtil.coverString(season.getFavourites())+"人追番");
        holder.setText(R.id.tv_title,season.getTitle());

        holder.setClickListener(R.id.card_view,v -> {
            //TODO click
            ToastUtil.show("season");
        });
    }
}
