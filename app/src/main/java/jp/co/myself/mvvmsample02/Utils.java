package jp.co.myself.mvvmsample02;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {

    public static float convertDp2Px(float dp, Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * metrics.density;
    }

}
