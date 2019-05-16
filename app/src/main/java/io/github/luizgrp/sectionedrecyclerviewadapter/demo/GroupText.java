package io.github.luizgrp.sectionedrecyclerviewadapter.demo;


import java.util.List;

/**
 * ${desc} 类的功能描述
 * Created by tanglong on 2019/5/15 0015 0:57.
 *
 * @author tanglong
 * @since version ${version}
 */
public class GroupText {
    private String title;
    private List<ChildText> items;

    public GroupText(String title, List<ChildText> items) {

        this.title = title;
        this.items = items;
    }

    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildText> getItems() {
        return items;
    }

    public void setItems(List<ChildText> items) {
        this.items = items;
    }
}
