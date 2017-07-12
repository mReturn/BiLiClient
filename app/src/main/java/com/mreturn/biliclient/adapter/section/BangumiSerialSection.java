package com.mreturn.biliclient.adapter.section;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;
import com.mreturn.biliclient.bean.BangumiAppIndexInfo;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/12.
 */

public class BangumiSerialSection extends StatelessSection {

    private Context context;
    private List<BangumiAppIndexInfo.ResultBean.SerializingBean> serialList;

    public BangumiSerialSection(Context context, List<BangumiAppIndexInfo.ResultBean.SerializingBean> serialList) {
        super(R.layout.item_bangumi_serial_head, R.layout.item_bangumi_serial_body);
        this.context = context;
        this.serialList = serialList;
    }

    @Override
    protected int getContentItemsCount() {
        return serialList.size();
    }

    @Override
    public void bindItemView(BaseViewHolder holder, int position) {
        ImageLoader.display(holder.getImageView(R.id.iv_cover),serialList.get(position).getCover(),R.drawable.bili_default_image_tv);
        holder.setText(R.id.tv_watch,serialList.get(position).getWatching_count()+"人在看");
        holder.setText(R.id.tv_title,serialList.get(position).getTitle());
        holder.setText(R.id.tv_update,"更新至第"+serialList.get(position).getNewest_ep_index()+"话");
        holder.setClickListener(R.id.card_view,v -> {
            // TODO click event
            ToastUtil.show("serial");
        });
    }
}
