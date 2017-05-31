package com.androidwanga.serenitynanian.serenityproject.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by serenitynanian on 2017/5/26.
 *
 * 在自定义Behavior的时候 我们关心两组四个方法
 * 第一组：
 *   某个View监听另一个View的状态变化，比如：位置，大小，显示状态等；
 *   关心两个方法：
 *      layoutDependsOn方法
 *      onDependentViewChanged方法
 *
 * 第二组：
 *   某个View监听CoordinatorLayout里的滑动状态
 *   关心两个方法：
 *      onStartNestedScroll方法
 *      onNestedPreScroll方法
 *      onNestedFling方法--可选--防止瞬间停止
 *
 *
 *
 */

public class DependencyBehavior extends CoordinatorLayout.Behavior{
    /**
     * 必须重写两个参数的构造方法，因为在CoordinatorLayout里面是利用反射获取这个Behavior，反射时就是使用的这个
     * 构造方法；
     * @param context
     * @param attrs
     */
    public DependencyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *表示是否给使用了Behavior的View指定一个依赖的布局；通常当依赖的View布局发生变化是，不管被
     * 依赖的View的顺序怎样，被依赖的View也会重新布局；
     * @param parent 就是当前的CoordinatorLayout
     * @param child 是我们设置这个Behavior的View
     * @param dependency 是我们关心的那个View；如果知道关心的哪个呢？layoutDependsOn的返回值决定；
     * @return 关心的那个View
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        return super.layoutDependsOn(parent, child, dependency);
        return dependency instanceof TextView;
    }

    /**
     * 被依赖的View状态（位置、大小）发生变化时，这个方法就会被调用
     * 关心的View的状态发生变化的时候，我们在下面的方法中做自己的逻辑处理
     * 这个方法中参数的意思同layoutDependsOn方法
     * @param parent
     * @param child
     * @param dependency
     * @return true if the Behavior changed the child view's size or position, false otherwise
     *         也就是说如果行为改变了子视图的大小或者位置，返回true，否则为false
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int offset = dependency.getTop() - child.getTop();
        System.out.println("-------->"+offset);
        //垂直偏移指定的像素数
        ViewCompat.offsetTopAndBottom(child,offset);
        return true;
    }
}
