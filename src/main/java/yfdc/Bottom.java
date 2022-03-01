package yfdc;

import android.content.Context;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;
import yfdc.baidu.app1.R;

import android.content.Intent;

import androidx.core.app.ActivityCompat;

public final class Bottom extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    @Override
    public void onClick(@Nullable final android.view.View view) {
        if (view != null) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(android.net.Uri.parse("https://getsimnum.caict.ac.cn/m/"));
            ActivityCompat.startActivity(mContext, i, null);
        }
    }

    @NotNull
    private final Context mContext;

    @NotNull
    @Contract("null -> fail")
    private static <T> T requireNN(@Nullable final T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        Intrinsics.checkNotNull(t);
        return java.util.Objects.requireNonNull(t);
    }

    public Bottom(@NotNull Context ct) {
        super(requireNN(ct));
        this.mContext = ct;
    }

    public Bottom(@NotNull Context ct, @Nullable android.util.AttributeSet attr) {
        super(requireNN(ct), attr);
        this.mContext = ct;
    }

    public Bottom(@NotNull Context ct, @Nullable android.util.AttributeSet attr, int var3) {
        super(requireNN(ct), attr, var3);
        this.mContext = ct;
    }

    public Bottom(@NotNull Context ct, @Nullable android.util.AttributeSet attr, int var3, int var4) {
        super(requireNN(ct), attr, var3, var4);
        this.mContext = ct;
    }

    @Override
    public final void onFinishInflate() {
        super.onFinishInflate();
        addOnClickLister(findViewById(R.id.id1));
        addOnClickLister(findViewById(R.id.id2));
        addOnClickLister(findViewById(R.id.id3));
        addOnClickLister(findViewById(R.id.id4));
    }

    private void addOnClickLister(android.view.View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }
}
