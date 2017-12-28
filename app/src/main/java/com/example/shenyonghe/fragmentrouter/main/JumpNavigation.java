package com.example.shenyonghe.fragmentrouter.main;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class JumpNavigation implements Parcelable {

    public JumpNavigation(int pageNum) {

        this.pageNum = pageNum;
    }
    private int pageNum;
    public String data;

    protected JumpNavigation(Parcel in) {
        pageNum = in.readInt();
        data = in.readString();
    }

    public static final Creator<JumpNavigation> CREATOR = new Creator<JumpNavigation>() {
        @Override
        public JumpNavigation createFromParcel(Parcel in) {
            return new JumpNavigation(in);
        }

        @Override
        public JumpNavigation[] newArray(int size) {
            return new JumpNavigation[size];
        }
    };

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pageNum);
        dest.writeString(data);
    }
}
