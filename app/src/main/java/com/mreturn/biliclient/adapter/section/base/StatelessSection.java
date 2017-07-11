package com.mreturn.biliclient.adapter.section.base;

/**
 * Created by mReturn
 * on 2017/7/10.
 *  Abstract Section with no States.
 */

public abstract class StatelessSection extends Section{

    public StatelessSection(int itemResourceId){
        super();
        this.itemResourceId = itemResourceId;
    }

    public StatelessSection(int headerResourceId,int itemResourceId) {
        this(itemResourceId);
        this.headerResourceId = headerResourceId;
        this.hasHeader = true;
    }

    public StatelessSection(int headerResourceId,int footerResourceId,int itemResourceId) {
        this(headerResourceId,itemResourceId);
        this.footerResourceId = footerResourceId;
        this.hasFooter = true;
    }

}
