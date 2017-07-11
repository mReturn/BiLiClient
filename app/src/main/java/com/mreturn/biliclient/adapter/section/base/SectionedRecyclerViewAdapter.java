package com.mreturn.biliclient.adapter.section.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.utils.MyLog;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

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
                if (section.isHasHeader()) {
                    if (position == currentPos) {
                        getSectionForPosition(position).bindHeaderView(holder);
                        return;
                    }
                }

                if (section.isHasFooter()) {
                    if (position == (currentPos + sectionCount - 1)) {
                        getSectionForPosition(position).bindFooterView(holder);
                        return;
                    }
                }

                getSectionForPosition(position).bindContentView(holder, getSectionPosition(position));
                return;
            }
            currentPos += sectionCount;
        }
        throw new IndexOutOfBoundsException("IndexOutOfBounds");
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible())
                continue;
            count += section.getSectionItemsCount();
            MyLog.e("section item",section.getSectionItemsCount()+"");
        }
        MyLog.e("section count",count+"");
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int curPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible())
                continue;
            int sectionCount = section.getSectionItemsCount();
            if (position >= curPos && position <= (curPos + sectionCount - 1)) {
                int viewType = sectionViewTypeNumbers.get(entry.getKey());
                if (section.isHasHeader()) {
                    if (position == curPos)
                        return viewType;
                }

                if (section.isHasFooter()) {
                    if (position == (curPos + sectionCount - 1))
                        return viewType + 1;
                }

                switch (section.getState()) {
                    case LOADED:
                        return viewType + VIEW_TYPE_ITEM_LOADED;
                    case LOADING:
                        return viewType + VIEW_TYPE_LOADING;
                    case FAILED:
                        return viewType + VIEW_TYPE_FAILED;
                    default:
                        throw new IllegalStateException("Invalid state");
                }
            }
            curPos += sectionCount;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /**
     * Returns the Section object for a position in the adapter
     *
     * @param position position in the adapter
     * @return Section object for that position
     */
    public Section getSectionForPosition(int position) {
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


    /**
     * Return the item position relative to the section.
     *
     * @param position position of the item in the adapter
     * @return position of the item in the section
     */
    public int getSectionPosition(int position) {
        int curPos = 0;
        for (Map.Entry<String, Section> entry : sections.entrySet()) {
            Section section = entry.getValue();
            if (!section.isVisible())
                continue;
            int sectionCount = section.getSectionItemsCount();
            if (position >= curPos && position <= (curPos + sectionCount - 1)) {
                return position - curPos - (section.isHasHeader() ? 1 : 0);
            }
            curPos += sectionCount;
        }
        throw new IndexOutOfBoundsException("IndexOutOfBounds");
    }


    /**
     * Returns the Section ViewType of an item based on the position in the adapter:
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_FOOTER
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_ITEM_LOADED
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_LOADING
     * - SectionedRecyclerViewAdapter.VIEW_TYPE_FAILED
     *
     * @param position position in the adapter
     * @return SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER, VIEW_TYPE_FOOTER,
     * VIEW_TYPE_ITEM_LOADED, VIEW_TYPE_LOADING or VIEW_TYPE_FAILED
     */
    public int getSectionItemViewType(int position) {
        int viewType = getItemViewType(position);
        return viewType % VIEW_TYPE_QTY;
    }


    /**
     * Add a section to this recyclerview.
     *
     * @param tag     unique identifier of the section
     * @param section section to be added
     */
    public void addSection(String tag, Section section) {
        this.sections.put(tag, section);
        this.sectionViewTypeNumbers.put(tag, viewTypeCount);
        viewTypeCount += VIEW_TYPE_QTY;
    }


    /**
     * Add a section to this recyclerview with a random tag;
     *
     * @param section section to be added
     * @return generated tag
     */
    public String addSection(Section section) {
        String tag = UUID.randomUUID().toString();
        addSection(tag, section);
        return tag;
    }


    /**
     * Return the section with the tag provided
     *
     * @param tag unique identifier of the section
     * @return section
     */
    public Section getSection(String tag) {
        return this.sections.get(tag);
    }


    /**
     * Remove section from this recyclerview.
     *
     * @param tag unique identifier of the section
     */
    public void removeSection(String tag) {
        this.sections.remove(tag);
    }


    /**
     * Remove all sections from this recyclerview.
     */
    public void removeAllSections() {
        this.sections.clear();
    }

}
