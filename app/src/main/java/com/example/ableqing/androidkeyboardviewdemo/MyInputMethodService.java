package com.example.ableqing.androidkeyboardviewdemo;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.TextView;

/**
 * 
 * 类说明: 
 *
 * @author qing
 * @time 31/01/2018 17:59
 */
public class MyInputMethodService extends InputMethodService {


    /**
     * 初始化键盘视图
     *
     * @return
     */
    @Override
    public View onCreateInputView() {

        View view = getLayoutInflater().
                inflate(R.layout.keyboard_global, null);

        return view;
    }

    @Override
    public View onCreateCandidatesView() {
        TextView textView = new TextView(getBaseContext());
        textView.setText("fdsfdsf");
        return textView;
    }
}
