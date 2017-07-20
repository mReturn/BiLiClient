package com.mreturn.biliclient.adapter.section;

import android.content.Context;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.section.base.StatelessSection;

import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/20.
 */

public class UserHomeSection extends StatelessSection {
    private Context context;
    private List<Object> list;
    private int type;

    public static final int TYPE_ARCHIVE = 0;
    public static final int TYPE_FAVOURITE = 1;
    public static final int type_season = 2;
    public static final int TYPE_COMMUNITY = 3;
    public static final int TYPE_COIN = 4;
    public static final int TYPE_GAME = 5;

    public UserHomeSection( int itemResourceId, Context context, List<Object> list, int type) {
        super(R.layout.item_user_home_header, itemResourceId);
        this.context = context;
        this.list = list;
        this.type = type;
    }

    @Override
    protected int getContentItemsCount() {
        return list.size();
    }

}
