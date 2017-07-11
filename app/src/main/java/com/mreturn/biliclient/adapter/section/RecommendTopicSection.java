package com.mreturn.biliclient.adapter.section;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public class RecommendTopicSection extends StatelessSection {

    private String imgUrl;
    private String title;
    private String link;

    public RecommendTopicSection( String imgUrl, String title, String link) {
        super(R.layout.item_recommend_topic, R.layout.layout_none_view);
        this.imgUrl = imgUrl;
        this.title = title;
        this.link = link;
    }

    @Override
    protected int getContentItemsCount() {
        return 1;
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        ImageLoader.display(holder.getImageView(R.id.iv_topic_cover),imgUrl,R.drawable.bili_default_image_tv);
        holder.setText(R.id.tv_topic_title,title);
        holder.setClickListener(R.id.card_view,v -> {
            ToastUtil.show("topic link: "+link);
        });
    }
}
