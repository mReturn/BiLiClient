package com.mreturn.biliclient.adapter.section;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mreturn.biliclient.adapter.BaseViewHolder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mReturn
 * on 2017/7/10.
 * <p/>
 * A custom RecyclerView Adapter that allows {@link Section Sections} to be added to it.
 * Sections are displayed in the same order they were added.
 */

public class SectionedRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public final static int VIEW_TYPE_HEADER = 0;
    public final static int VIEW_TYPE_FOOTER = 1;
    public final static int VIEW_TYPE_ITEM_LOADED = 2;
    public final static int VIEW_TYPE_LOADING = 3;
    public final static int VIEW_TYPE_FAILED = 4;

    private LinkedHashMap<String, Section> sections;
    private HashMap<String, Integer> sectionViewTypeNumbers;
    private int viewTypeCount = 0;
    private final static int VIEW_TYPE_QTY = 5;

    public SectionedRecyclerViewAdapter() {
        sections = new LinkedHashMap<>();
        sectionViewTypeNumbers = new HashMap<>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Integer resId = null;
        for (Map.Entry<String, Integer> entry : sectionViewTypeNumbers.entrySet()) {
            if (viewType >= entry.getValue() && viewType < entry.getValue() + VIEW_TYPE_QTY) {
                Section section = sections.get(entry.getKey());
                int sectionViewType = viewType - entry.getValue();
                switch (sectionViewType) {
                    case VIEW_TYPE_HEADER:
                        resId = section.getHeaderResourceId();
                        if (resId == null)
                            throw new NullPointerException("Missing 'header' resource id");
                        break;
                    case VIEW_TYPE_FOOTER:
                        resId = section.getFooterResourceId();
                        if (resId == null)
                            throw new NullPointerException("Missing 'footer' resource id");
                        break;
                    case VIEW_TYPE_ITEM_LOADED:
                        resId = section.getItemResourceId();
                        break;
                    case VIEW_TYPE_LOADING:
                        resId = section.getLoadingResourceId();
                        if (resId == null)
                            throw new NullPointerException("Missing 'loading state' resource id");
                        break;
                    case VIEW_TYPE_FAILED:
                        resId = section.getFailedResourceId();
                        if (resId == null)
                            throw new NullPointerException("Missing 'failed state' resource id");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid viewType");
                }
            }

        }
        if (resId == null)
            throw new NullPointerException("resource id is null");
        View view = LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int currentPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible())
                continue;
            int sectionCount = section.getSectionItemsCount();
            if (position >= currentPos && position <= (currentPos + sectionCount - 1)) {
                if (section.hasHeader) {
                    if (position == currentPos) {
                        getSectionForPosition(position).bindHeaderView(holder);
                    }
                }
            }
        }
    }

    private Section getSectionForPosition(int position) {
        int curPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            // ignore invisible sections
            if (!section.isVisible())
                continue;
            int sectionCount = section.getSectionItemsCount();
            // check if position is in this section
            if (position >= curPos && position <= (curPos + sectionCount - 1)) {
                return section;
            }
            curPos += sectionCount;
        }
        throw new IndexOutOfBoundsException("IndexOutOfBounds");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
