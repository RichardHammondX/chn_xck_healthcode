package yfdc.baidu.app1;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import androidx.annotation.UiThread;
import kotlin.jvm.internal.Intrinsics;
public final class MainApplication extends android.app.Application {
    @NotNull public static synchronized MainApplication getInstance() {
        MainApplication rtn = null;
        synchronized (MainApplication.class) {
            rtn = instance;
        }
        if (rtn == null) {
            throw new NullPointerException("fetal");
        }
        Intrinsics.checkNotNull(rtn);
        return java.util.Objects.requireNonNull(rtn);
    }
    private static volatile MainApplication instance = null;
    private static final String TAG = MainApplication.class.getSimpleName();
    public MainApplication() {
        super();
        android.util.Log.d(TAG, "constructor:void MainApplication.<init>() called");
        synchronized (MainApplication.class) {
            if (instance != null) {
                instance = null;
            }
            instance = this;
        }
    }
    @NotNull
    @UiThread
    @SuppressLint("ShowToast") public static android.widget.Toast makeAppToast(@NotNull final android.content.Context context,@Nullable final String text, final int duration) {
        Intrinsics.checkParameterIsNotNull(context,"context");
        java.util.Objects.requireNonNull(context);
        final android.widget.Toast m = android.widget.Toast.makeText(context, "", duration);
        java.util.Objects.requireNonNull(m);
        Intrinsics.checkNotNull(m);
        m.setText((text == null) ? "" : text);
        m.setDuration(duration);
        return m;
    }
    @NotNull public final SharedPreferences getSp(){
        final SharedPreferences spss = this.getSharedPreferences("save", android.content.Context.MODE_PRIVATE);
        Intrinsics.checkNotNull(spss,"spss is null");
        return java.util.Objects.requireNonNull(spss);
    }
    @NotNull public final String getBadCity(){
        try{
            return getResources().getString(R.string.str_bad_city);
        }catch (final Throwable ex){
            return "(注: *表示当前城市存在中风险或高风险地区, 并不表示用户实际到访过这些中高风险地区。)";
        }
    }
}
