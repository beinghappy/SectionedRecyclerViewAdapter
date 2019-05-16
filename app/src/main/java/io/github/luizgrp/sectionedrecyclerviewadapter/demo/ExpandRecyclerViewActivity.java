package io.github.luizgrp.sectionedrecyclerviewadapter.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ${desc} 类的功能描述
 * Created by tanglong on 2019/5/15 0015 0:56.
 *
 * @author tanglong
 * @since version ${version}
 */
public class ExpandRecyclerViewActivity extends AppCompatActivity {


    private List<GroupText> mobileOSes;

    ExpandableGridView expandableGridView;
    MyAdapter expandableGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_recyclerview_layout);
        mobileOSes = new ArrayList<>();

        setData();
        expandableGridView = (ExpandableGridView) findViewById(R.id.egv);
        expandableGridAdapter = new MyAdapter(mobileOSes);
        expandableGridView.setExpandableGridAdapter(expandableGridAdapter);
        expandableGridView.setGroupClickable(false);
        expandableGridView.setGroupIndicator(null);
        expandableGridView.expandAll(true);
        expandableGridView.setOnGridItemClickListener(new OnGridItemClickListener() {
            @Override
            public void onGridItemClick(View view, int gridGroupPosition, int gridChildPosition) {
                ChildText date = (ChildText) expandableGridAdapter.getChild(gridGroupPosition, gridChildPosition);
                Log.i("tang", "onGridItemClick: data == " + date.getName());
                Toast.makeText(ExpandRecyclerViewActivity.this, "p:" + gridGroupPosition + ",c:" + gridChildPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends ExpandableGridAdapter {

        List<GroupText> list;

        public MyAdapter(List<GroupText> dataList) {
            list = dataList;
        }

        @Override
        public int getGridGroupCount() {
            return list.size();
        }

        @Override
        public int getGridChildCount(int gridGroupPosition) {
            return list.get(gridGroupPosition).getItemCount();
        }

        @Override
        public View getGridGroupView(int gridGroupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(list.get(gridGroupPosition).getTitle());
            return convertView;
        }

        @Override
        public View getGridChildView(int gridGroupPosition, int gridChildPosition, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.text);
            textView.setText(list.get(gridGroupPosition).getItems().get(gridChildPosition).getName());
            return convertView;
        }

        @Override
        public int getNumColumns(int gridGroupPosition) {
            return gridGroupPosition % 3 + 3;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setData() {
        ArrayList<ChildText> iphones = new ArrayList<>();
        iphones.add(new ChildText("苹果"));
        iphones.add(new ChildText("橘子"));
        iphones.add(new ChildText("芒果"));
        iphones.add(new ChildText("香蕉"));
        iphones.add(new ChildText("火龙果"));
        iphones.add(new ChildText("草莓"));
        iphones.add(new ChildText("柚子"));
        iphones.add(new ChildText("哈密瓜"));

        ArrayList<ChildText> nexus = new ArrayList<>();
        nexus.add(new ChildText("足球"));
        nexus.add(new ChildText("篮球"));
        nexus.add(new ChildText("乒乓球"));
        nexus.add(new ChildText("棒球"));
        nexus.add(new ChildText("保龄球"));
        nexus.add(new ChildText("溜溜球"));
        nexus.add(new ChildText("橄榄球"));

        ArrayList<ChildText> windowPhones = new ArrayList<>();
        windowPhones.add(new ChildText("单击游戏"));
        windowPhones.add(new ChildText("主机游戏"));
        windowPhones.add(new ChildText("FPS游戏"));
        windowPhones.add(new ChildText("挂机游戏"));
        windowPhones.add(new ChildText("小游戏"));
        windowPhones.add(new ChildText("手游"));

        mobileOSes.add(new GroupText("水果", iphones));
        mobileOSes.add(new GroupText("球类", nexus));
        mobileOSes.add(new GroupText("游戏", windowPhones));
    }
}
