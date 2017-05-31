package com.androidwanga.serenitynanian.serenityproject.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

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
 */
public class ScrollBehavior extends CoordinatorLayout.Behavior {

    /**
     * 必须重写两个参数的构造函数，因为在CoordinatorLayout里面利用两个参数的构造方法反射获取Behavior
     * @param context
     * @param attrs
     */
    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 此方法当CoordinatorLayout的子View试图开始嵌套滑动的时候被调用；
     * 当返回值为true的时候表明coordinatorlayout充当nested scroll parent处理这次滑动，
     * 需要注意的是只有当返回值为true的时候，Behavior才能收到后面的一些nested scroll事件回调（如：onNestedPreScroll、
     * onNestedScroll等）
     * @param coordinatorLayout 当前的CoordinatorLayout
     * @param child 就是我们设置behavior的View
     * @param directTargetChild 包含target嵌套滚动操作的CoordinatorLayout子View
     * @param target 开始嵌套滚动的CoordinatorLayout的后代view
     * @param nestedScrollAxes 嵌套滚动的轴心（轴线），表明处理滑动的方向：ViewCompat#SCROLL_AXIS_HORIZONTAL 和 ViewCompat#SCROLL_AXIS_VERTICAL
     * @return 这里的返回值表明这次滑动我们要不要关心，我们要关心什么样的滑动？
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 嵌套滚动发生之前被调用；
     * 在nested scroll child 消费掉自己的滚动距离之前，嵌套滚动每次被nested scroll child 更新都会调用onNestedPreScroll.
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx 用户水平方向的滚动距离
     * @param dy 用户垂直方向的滚动距离
     * @param consumed 可以修改这个数组表示child消费了多少距离；假设用户滑动了100px,child做了90px的位移，
     *                 你需要把consumed[1]的值修改为90，这样coordinatorLayout就知道只处理剩下的10px的滚动；
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    /**
     * 用户松开手指并且会发生惯性动作之前调用，参数提供了速度信息，可以根据这些速度信息
     * 决定最终状态，比如滚动Header，是让header处于展开状态还是折叠状态；返回true表示消费了fling
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param velocityX x方向上的速度
     * @param velocityY y方向上的速度
     * @param consumed
     * @return
     */
    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    /**
     * 进行嵌套滚动时被调用
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed target已经在x方向消费的距离
     * @param dyConsumed target已经在y方向消费的距离
     * @param dxUnconsumed x 方向上剩下的滚动距离
     * @param dyUnconsumed y 方向上剩下的滚动距离
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    /**
     * 嵌套滚动结束时被调用，这是一个清除滚动状态的时机
     * @param coordinatorLayout
     * @param child
     * @param target
     */
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    /**
     * onStartNestedScroll返回true才会触发此方法，接受滚动处理回调，可以在这个方法里做一些准备工作
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     */
    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 可以重写这个方法对子View进行重新布局
     * @param parent
     * @param child
     * @param layoutDirection
     * @return
     */
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        return super.onLayoutChild(parent, child, layoutDirection);
    }
}
