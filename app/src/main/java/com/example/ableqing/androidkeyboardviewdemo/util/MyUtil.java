package com.example.ableqing.androidkeyboardviewdemo.util;

import android.content.Context;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.text.TextUtils;
import android.view.WindowManager;

import com.example.ableqing.androidkeyboardviewdemo.MyApp;
import com.example.ableqing.androidkeyboardviewdemo.R;
import com.example.ableqing.androidkeyboardviewdemo.constants.DemoKeyCode;

import java.util.List;

public class MyUtil {


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = MyApp.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        final float scale = MyApp.getInstance().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 获得屏幕的宽度
     *
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获得屏幕的高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }





    /**
     * 键盘大小写切换
     */
    public static void switchUpperOrLowerCase(boolean isUpper, Keyboard keyboard) {
        Resources res = MyApp.getInstance().getResources();
        List<Keyboard.Key> keyList = keyboard.getKeys();
        if (isUpper) {// 大写切换小写
            for (Keyboard.Key key : keyList) {
                CharSequence label = key.label;
                if (!TextUtils.isEmpty(label) && key.codes[0] != DemoKeyCode.CODE_SPACE && key.codes[0] != DemoKeyCode.KEYCODE_DONE) {
                    String str = label.toString();
                    if (key.label != null && isLetter(str)) {
                        key.label = str.toLowerCase();
                        key.codes[0] = key.codes[0] + 32;
                    }
                } else if (key.sticky && key.codes[0] == Keyboard.KEYCODE_SHIFT) {
                    key.icon = res.getDrawable(R.mipmap.key_shift);
                    key.pressed = false;

                }
            }
        } else {// 小写切换大写
            for (Keyboard.Key key : keyList) {
                CharSequence label = key.label;
                if (!TextUtils.isEmpty(label) && key.codes[0] != DemoKeyCode.CODE_SPACE && key.codes[0] != DemoKeyCode.KEYCODE_DONE) {
                    String str = label.toString();
                    if (key.label != null && isLetter(str)) {
                        key.label = str.toUpperCase();
                        key.codes[0] = key.codes[0] - 32;
                    }
                } else if (key.sticky && key.codes[0] == Keyboard.KEYCODE_SHIFT) {
                    key.icon = res.getDrawable(R.mipmap.key_shift_down);
                    key.pressed = true;

                }

            }
        }
    }

    /**
     * 是否为字母
     *
     * @param str
     * @return
     */
    public static boolean isLetter(String str) {
        if (!TextUtils.isEmpty(str)) {
            char c = str.charAt(0);
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
        return false;
    }



}
