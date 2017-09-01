package demo.webview.com;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by tech60 on 2017/8/28.
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context, AttributeSet attrs, boolean noScroll) {
        super(context, attrs);
        this.noScroll = noScroll;
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, boolean noScroll) {
        super(context, attrs, defStyleAttr);
        this.noScroll = noScroll;
    }

    private boolean noScroll = false;

    public MyScrollView(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(arg0);
        }
    }
}
