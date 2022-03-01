package yfdc.baidu.app1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public final class Thing implements java.io.Serializable, Parcelable {
    public String phone;
    public String address;
    private transient static final long serialVersionUID = 0L;

    public Thing() {
        super();
        this.phone = "";
        this.address = "";
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(@NotNull final Parcel dest, int flags) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        dest.writeString(phone);
        dest.writeString(address);
    }

    public static final Parcelable.Creator<Thing> CREATOR = (new YCreator());

    private static final class YCreator implements Parcelable.Creator<Thing> {
        @NotNull
        @Override
        public final Thing createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkParameterIsNotNull(source, "source");
            final Thing a = new Thing();
            a.phone = source.readString();
            a.address = source.readString();
            return a;
        }

        private YCreator() {
            super();
        }

        @NotNull
        @Contract(value = "_ -> new", pure = true)
        @Override
        public final Thing[] newArray(int size) {
            return new Thing[size];
        }
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString("phone", String.valueOf(phone));
        b.putString("address", String.valueOf(address));
        return b;
    }
    @NotNull public final String toString() {
        final org.json.JSONObject o = new org.json.JSONObject();
        if (phone == null) phone = "";
        if (address == null) address = "";
        try {
            o.put("phone", phone);
            o.put("address", address);
        } catch (final Throwable ex) {
            //ignore
        }
        return o.toString();
    }
}
