package io.github.luizgrp.sectionedrecyclerviewadapter.demo;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * ${desc} 类的功能描述
 * Created by tanglong on 2019/5/15 0015 0:57.
 *
 * @author tanglong
 * @since version ${version}
 */
public class GroupText extends ExpandableGroup<ChildText> {
    public GroupText(String title, List<ChildText> items) {
        super(title, items);
    }
}
