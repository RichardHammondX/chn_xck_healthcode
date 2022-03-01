package yfdc;
import kotlin.jvm.internal.Intrinsics;
import yfdc.baidu.app1.BuildConfig;
import yfdc.baidu.app1.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.felipecsl.gifimageview.library.GifImageView;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.text.SimpleDateFormat;
import java.util.Locale;
public final class Center extends android.widget.LinearLayout {
    @NotNull public final android.content.Context mContext;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss",
            Locale.SIMPLIFIED_CHINESE);
    private static final java.util.Date date = (new java.util.Date(System.currentTimeMillis()));
    private static void checkNotNull(@Nullable final Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        java.util.Objects.requireNonNull(obj);
    }
    public Center(@NotNull Context context) {
        super(context);
        checkNotNull(context);
        this.mContext = context;
        android.util.Log.d("CT",Util.buildStr(context,null,0));
    }
    public Center(@NotNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        checkNotNull(context);
        this.mContext = context;
        android.util.Log.d("CT",Util.buildStr(context,attrs,0));
    }
    public Center(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkNotNull(context);
        this.mContext = context;
        android.util.Log.d("CT",Util.buildStr(context,attrs,defStyleAttr));
    }
    public Center(@NotNull Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkNotNull(context);
        this.mContext = context;
    }
    @Override public final void onFinishInflate() {
        super.onFinishInflate();
        final android.widget.TextView time = findViewById(R.id.cur_time);
        checkNotNull(time);
        date.setTime(System.currentTimeMillis());
        time.setText(SDF.format(date));
        time.setOnClickListener((v) -> {
            date.setTime(System.currentTimeMillis());
            time.setText(SDF.format(date));
        });
        GifImageView iv = findViewById(R.id.gif_view);
        if (iv == null) {
            throw new NullPointerException("");
        }
        byte[] bytes = null;
        java.io.InputStream is = getResources().openRawResource(R.raw.green_xck_raw);
        checkNotNull(is);
        try {
            int len = is.available();
            bytes = new byte[len];
            int id = is.read(bytes, 0, len);
            if (BuildConfig.isDebugMode) android.util.Log.d("I", String.valueOf(id));
            iv.setBytes(bytes);
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
        }
        this.ivb = iv;
        //Glide.with(mContext).load(R.drawable.green_xck).into(iv);
    }

    public GifImageView ivb;

    @NotNull
    public static Center fromContext(@NotNull final Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        checkNotNull(context);
        final android.view.View v = LayoutInflater.from(context).inflate(R.layout.center, null, false);
        checkNotNull(v);
        return ((Center) v);
    }

    @NotNull @Contract("_ -> new") public static String phone(@Nullable final String s0) {
        if (s0 == null) {
            return "130****7905";
        }
        if (s0.length() != 11) {
            return "130****7905";
        }
        char[] old = s0.toCharArray();
        old = java.util.Arrays.copyOf(old, old.length);
        old[3] = ((char) 0x002A);
        old[4] = ((char) 0x002A);
        old[5] = ((char) 0x002A);
        old[6] = ((char) 0x002A);
        return new String(old);
    }
}
