package com.sea.lottery.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout


/**
 * 其实Behavior就是一个应用于View的观察者模式，一个View跟随着另一个View的变化而变化，或者说一个View监听另一个View。
 * 在Behavior中，被观察View 也就是事件源被称为denpendcy，而观察View，则被称为child。
 *
 * 自定义Behavior，这里分为两类:
 * Dependent机制
 * layoutDependsOn和onDependentViewChanged作为一组
 * Nested机制
 * onStartNestedScroll和onNestedScroll作为一组.CoordinatorLayout包含了一个实现了 NestedScrollingChild 接口的滚动视图控件
 * 设置 Behavior属性的Child View会随着这个控件的滚动而发生变化
 * */
class SampleHeaderBehavior(context: Context, attrs: AttributeSet) :
    CoordinatorLayout.Behavior<FrameLayout>(context, attrs) {


    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: FrameLayout, // 观测目标的View
        dependency: View  //目标View
    ): Boolean {
        //决定被观察的View
        //决定观察View依赖于哪个被观察的View
        //此方法用于判断给定的View和同级View是否作为布局依赖关系。
        //如果返回true，那么parent将做两件事：
        //          1.将忽略View的顺序，总是先去布局dependency，之后布局child。
        //          2.当dependency视图的布局或位置发生改变时，调用onDependentViewChanged方法。
        //
        Log.d("Behavior","child = "+child.id)
        Log.d("Behavior","dependency = "+dependency.id)

        return true
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: FrameLayout,
        dependency: View
    ): Boolean {
        //被观察View变化的时候回调的方法
        //方法用于对依赖视图的改变做出响应。开发者可以复写此方法从而改变child的大小和位置，并返回true。

        Log.d("Behavior","child = "+child.id)
        Log.d("Behavior","dependency = "+dependency.id)

        return super.onDependentViewChanged(parent, child, dependency)
    }


    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FrameLayout,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        //此方法用于判断是否进行嵌套滚动。与CoordinatorLayout的任何直接子项相关联的任何Behavior都可以响应此事件。
        // 如果返回true，表明CoordinatorLayout应该充当此滚动的嵌套滚动父项。
        // 只有返回true，才会执行后续的嵌套滚动方法。
        return super.onStartNestedScroll(
            coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type
        )
    }

    /**
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed 水平方向滚动增量，
     * @param dyConsumed 垂直方向滚动增量，如果大于0，手指上滑中；如果小于0,手指下滑中。
     * @param dxUnconsumed 同dyUnconsumed描述
     * @param dyUnconsumed 正常情况下，始终为0，当View处于最顶部或最底部，用户仍然强制下滑或上滑时，dy则不为0
     */
    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FrameLayout,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type
        )
        //此方法用于处理嵌套滚动。
        //每次嵌套滚动由嵌套滚动子元素更新时，onNestedScroll被调用，滚动的消费组件和未消费组件以像素提供。
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FrameLayout,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }
}