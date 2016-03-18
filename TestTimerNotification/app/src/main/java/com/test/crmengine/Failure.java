package com.test.crmengine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public class Failure implements Parcelable {
    private String mMessage;

    public Failure() {

    }

    public Failure(String message) {
        mMessage = message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMessage);
    }

    public static final Parcelable.Creator<Failure> CREATOR
            = new Parcelable.Creator<Failure>() {
        public Failure createFromParcel(Parcel in) {
            return new Failure(in);
        }

        public Failure[] newArray(int size) {
            return new Failure[size];
        }
    };

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "message=" + mMessage + "]";
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    private Failure(Parcel in) {
        mMessage = in.readString();
    }
}
