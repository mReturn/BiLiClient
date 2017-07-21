package com.mreturn.biliclient.adapter.section.recommend;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.home.RecommendInfo;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.ui.live.LivePlayerActivity;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public class RecommendSection extends StatelessSection {

    private static final String TYPE_RECOMMENDED = "recommend";
    private static final String TYPE_LIVE = "live";
    private static final String TYPE_BANGUMI = "bangumi_2";
    private static final String GOTO_BANGUMI = "bangumi_list";
    private static final String TYPE_ACTIVITY = "activity";

    private int[] icons = new int[]{
            R.drawable.ic_header_hot, R.drawable.ic_head_live,
            R.drawable.ic_category_t13, R.drawable.ic_category_t1,
            R.drawable.ic_category_t3, R.drawable.ic_category_t129,
            R.drawable.ic_category_t4, R.drawable.ic_category_t119,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160,
            R.drawable.ic_category_t155, R.drawable.ic_category_t5,
            R.drawable.ic_category_t11, R.drawable.ic_category_t23
    };

    private String[] headTitles = new String[]{
            "热门焦点", "正在直播", "番剧推荐", "动画区",
            "音乐区", "舞蹈区", "游戏区", "鬼畜区",
            "科技区", "生活区", "时尚区", "娱乐区",
            "电视剧区", "电影区"};
    private List<String> headTitleList = Arrays.asList(headTitles);

    private Context context;
    private String title;
    private String type;
    private int liveCount;
    private List<RecommendInfo.ResultBean.BodyBean> datas = new ArrayList<>();
    private Random random;

    public RecommendSection(Context context, String title, String type, int liveCount, List<RecommendInfo.ResultBean.BodyBean> datas) {
        super(R.layout.item_recommend_head, R.layout.item_recommend_foot, R.layout.item_recommend_boby);
        this.context = context;
        this.title = title;
        this.type = type;
        this.liveCount = liveCount;
        this.datas = datas;
        random = new Random();
    }

    @Override
    protected int getContentItemsCount() {
        return datas.size();
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        CardView cardView = holder.getView(R.id.card_view);
        RecommendInfo.ResultBean.BodyBean bodyBean = datas.get(position);

        ImageLoader.display(holder.getImageView(R.id.video_preview), bodyBean.getCover(), R.drawable.bili_default_image_tv);
        holder.setText(R.id.video_title, bodyBean.getTitle());
        switch (type) {
            case TYPE_LIVE:
                //直播
                holder.setVisibility(View.VISIBLE, R.id.layout_live);
                holder.setVisibility(View.GONE, R.id.layout_video, R.id.layout_bangumi);
                holder.setText(R.id.item_live_up, bodyBean.getUp());
                holder.setText(R.id.item_live_online, bodyBean.getOnline() + "");
                break;
            case TYPE_BANGUMI:
                //番剧
                holder.setVisibility(View.VISIBLE, R.id.layout_bangumi);
                holder.setVisibility(View.GONE, R.id.layout_live, R.id.layout_video);
                holder.setText(R.id.item_bangumi_update, bodyBean.getDesc1());
                break;
//            case TYPE_ACTIVITY:
//                ViewGroup.LayoutParams params = cardView.getLayoutParams();
//                params.height = DisplayUtils.dp2px(context, 200f);
//                cardView.setLayoutParams(params);
//                holder.setVisibility(View.GONE, R.id.layout_bangumi, R.id.layout_live, R.id.layout_video);
//                break;
            default:
                holder.setVisibility(View.VISIBLE, R.id.layout_video);
                holder.setVisibility(View.GONE, R.id.layout_live, R.id.layout_video);
                holder.setText(R.id.video_play_num, bodyBean.getPlay());
                holder.setText(R.id.video_review_count, bodyBean.getDanmaku());
                break;
        }

        cardView.setOnClickListener(v -> {
            String gotoX = bodyBean.getGotoX();
            switch (gotoX) {
                case TYPE_LIVE:
                    LivePlayerActivity.launch((Activity) context,
                            Integer.valueOf(bodyBean.getParam()), bodyBean.getTitle(),
                            bodyBean.getOnline(), bodyBean.getUpFace(), bodyBean.getUp(), 0);
                    break;
                case GOTO_BANGUMI:
                    ToastUtil.show("bangumi");
                    break;
//                case TYPE_ACTIVITY:
//                    ToastUtil.show("activity");
//                    break;
                default:
                    ToastUtil.show("video");
                    break;
            }
        });

    }

    @Override
    public void bindHeaderView(BaseViewHolder holder) {
        int pos = headTitleList.indexOf(title);
        if (pos >= 0)
            holder.setImgResource(R.id.item_type_img, icons[pos]);
        holder.setText(R.id.item_type_tv, title);
        switch (type) {
            case TYPE_RECOMMENDED:
                holder.setVisibility(View.VISIBLE, R.id.item_type_rank_btn);
                holder.setVisibility(View.GONE, R.id.item_type_more, R.id.item_live_all_num);
                break;
            case TYPE_LIVE:
                holder.setVisibility(View.VISIBLE, R.id.item_type_more, R.id.item_live_all_num);
                holder.setVisibility(View.GONE, R.id.item_type_rank_btn);
                SpannableStringBuilder builder = new SpannableStringBuilder("当前" + liveCount + "个直播");
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(context.getResources()
                        .getColor(R.color.pink_text_color));
                builder.setSpan(colorSpan, 2, builder.length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                TextView tvAllNum = holder.getTextView(R.id.item_live_all_num);
                tvAllNum.setText(builder);
                break;
            default:
                holder.setVisibility(View.VISIBLE, R.id.item_type_more);
                holder.setVisibility(View.GONE, R.id.item_type_rank_btn, R.id.item_live_all_num);
                break;
        }
    }

    @Override
    public void bindFooterView(BaseViewHolder holder) {
        ImageView ivRecommendRefresh = holder.getImageView(R.id.item_recommend_refresh);
        ImageView ivItemRefresh = holder.getImageView(R.id.item_btn_refresh);

        holder.setText(R.id.item_dynamic, random.nextInt(200) + "条新动态，点这里刷新");
        ivRecommendRefresh.setOnClickListener(v -> {
            ivRecommendRefresh.animate().rotation(360)
                    .setInterpolator(new LinearInterpolator())
                    .setDuration(1000).start();
        });
        ivItemRefresh.setOnClickListener(v -> {
            ivItemRefresh.animate().rotation(360)
                    .setInterpolator(new LinearInterpolator())
                    .setDuration(1000).start();
        });
        switch (type) {
            case TYPE_RECOMMENDED:
                holder.setVisibility(View.VISIBLE, R.id.item_recommend_refresh_layout);
                holder.setVisibility(View.GONE, R.id.item_btn_more, R.id.item_refresh_layout,
                        R.id.item_btn_refresh);
                break;
            case TYPE_BANGUMI:
                holder.setVisibility(View.VISIBLE, R.id.item_bangumi_layout);
                holder.setVisibility(View.GONE, R.id.item_recommend_refresh, R.id.item_btn_more,
                        R.id.item_recommend_refresh_layout,R.id.item_btn_refresh);
                break;
//            case TYPE_ACTIVITY:
//                holder.setVisibility(View.GONE, R.id.foot_view);
//                break;
            default:
                holder.setVisibility(View.VISIBLE, R.id.item_btn_more, R.id.item_refresh_layout);
                holder.setVisibility(View.GONE, R.id.item_recommend_refresh_layout, R.id.item_bangumi_layout);
                break;
        }

        holder.setClickListener(R.id.item_btn_bangumi_index, v -> ToastUtil.show("bangumi index"));
        holder.setClickListener(R.id.item_btn_bangumi_timeline,v -> ToastUtil.show("bangumi timeline"));
    }
}
