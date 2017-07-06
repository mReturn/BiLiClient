package com.mreturn.biliclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.bean.LiveAppIndexInfo;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;
import com.mreturn.biliclient.widget.banner.BannerBean;
import com.mreturn.biliclient.widget.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/6.
 * 首页直播adapter
 */

public class HomeLiveAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    //banner
    private static final int TYPE_BANNER = 0;
    //分类入口
    private static final int TYPE_ENTRANCE = 1;
    //item title
    private static final int TYPE_PARTITION = 2;
    //item
    private static final int TYPE_LIVE_ITEM = 3;

    private Context context;
    private LiveAppIndexInfo liveAppIndexInfo;
    private List<LiveAppIndexInfo.DataBean.EntranceIconsBean> entranceIcons = new ArrayList<>();
    private List<BannerBean> bannerlist = new ArrayList<>();


    public HomeLiveAdapter(Context context) {
        this.context = context;
    }

    public void setLiveInfo(LiveAppIndexInfo liveAppIndexInfo){
        this.liveAppIndexInfo = liveAppIndexInfo;

        if (liveAppIndexInfo.getData().getEntranceIcons() != null) {
            entranceIcons.clear();
            entranceIcons.addAll(liveAppIndexInfo.getData().getEntranceIcons());
            if (entranceIcons.size()>4)
                entranceIcons = entranceIcons.subList(0,4);
            System.out.println("entrance: "+entranceIcons.size());

        }
        if (liveAppIndexInfo.getData().getBanner() != null) {
            bannerlist.clear();
            bannerlist.addAll(liveAppIndexInfo.getData().getBanner());
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_BANNER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_banner, null);
                break;
            case TYPE_ENTRANCE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_entrance, null);
                break;
            case TYPE_PARTITION:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_partition, null);
                break;
            case TYPE_LIVE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live, null);
                break;
            default:
                break;
        }
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_BANNER:
                BannerView bannerView = holder.getView(R.id.live_banner);
                bannerView.delayTime(5).build(bannerlist);
                break;
            case TYPE_ENTRANCE:
                ImageView ivEntrance = holder.getImageView(R.id.iv_entrance);
                holder.setText(R.id.tv_entrance, entranceIcons.get(position-1).getName());
                ImageLoader.display(ivEntrance, entranceIcons.get(position-1).getEntrance_icon().getSrc());
                break;
            case TYPE_PARTITION:
                LiveAppIndexInfo.DataBean.PartitionsBean.PartitionBean partition = liveAppIndexInfo.
                        getData().getPartitions().get(getItemPosition(position)).getPartition();

                TextView tvParttionCount = holder.getTextView(R.id.tv_partition_count);
                ImageLoader.display(holder.getImageView(R.id.iv_partition),partition.getSub_icon().getSrc());
                holder.setText(R.id.tv_partition_title,partition.getName());
                SpannableStringBuilder strBuilder = new SpannableStringBuilder("当前"
                        +partition.getCount()+"个直播");
                ForegroundColorSpan fcs = new ForegroundColorSpan(context.getResources()
                        .getColor(R.color.pink_text_color));
                strBuilder.setSpan(fcs,2,strBuilder.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                tvParttionCount.setText(strBuilder);
                break;
            case TYPE_LIVE_ITEM:
                int itemPos = getItemPosition(position);
                int livePos = position - 1 - entranceIcons.size() - getItemPosition(position) * 5;
                LiveAppIndexInfo.DataBean.PartitionsBean.LivesBean livesBean = liveAppIndexInfo.
                        getData().getPartitions().get(getItemPosition(position)).getLives()
                        .get(position - 1 - entranceIcons.size() - getItemPosition(position) * 5);
                ImageLoader.display(holder.getImageView(R.id.iv_live_cover),livesBean.getCover().getSrc());
                ImageLoader.display(holder.getImageView(R.id.civ_live_avatar),livesBean.getCover().getSrc());
                holder.setText(R.id.tv_live_title,livesBean.getTitle());
                holder.setText(R.id.tv_live_name,livesBean.getOwner().getName());
                holder.setText(R.id.tv_live_count,livesBean.getOnline()+"");
                holder.setClickListener(R.id.item_root,v -> {
                    ToastUtil.show("live");
                });
                break;
            default:
                break;
        }

    }

    //计算在第几组中
    private int getItemPosition(int position) {
        position -= entranceIcons.size();
        return position / 5;
    }

    @Override
    public int getItemCount() {
        if (liveAppIndexInfo != null) {
            return 1 + entranceIcons.size() + liveAppIndexInfo.getData().getPartitions().size() * 5;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_BANNER;
        position -= 1;
        if (position < entranceIcons.size()) {
            return TYPE_ENTRANCE;
        } else if (isPartion(position)) {
            return TYPE_PARTITION;
        } else {
            return TYPE_LIVE_ITEM;
        }
    }

    private boolean isPartion(int position) {
        position -= entranceIcons.size();
        return position % 5 == 0;
    }

    public int getSpanSize(int position) {
        switch (getItemViewType(position)){
            case TYPE_ENTRANCE:
                return 3;
            case TYPE_LIVE_ITEM:
                return 6;
            case TYPE_PARTITION:
                return 12;
            case TYPE_BANNER:
                return 12;
            default:
                return 0;
        }
    }
}
