package io.github.luizgrp.sectionedrecyclerviewadapter.demo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ${desc} 类的功能描述
 * Created by tanglong on 2019/5/15 0015 0:56.
 *
 * @author tanglong
 * @since version ${version}
 */
public class ChildText implements Parcelable {
    private String name;

    public ChildText(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildText(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChildText> CREATOR = new Creator<ChildText>() {
        @Override
        public ChildText createFromParcel(Parcel in) {
            return new ChildText(in);
        }

        @Override
        public ChildText[] newArray(int size) {
            return new ChildText[size];
        }
    };
}