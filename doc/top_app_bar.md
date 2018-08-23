#Top App Bar

####简介
AppBarLayout是一个ViewGroup,常用来装饰Toolbar。Toolbar提供了许多材料设计功能，
以及和Top App Bar 的交互，换句话说也就是能够响应滚动（Scrolling）。
AppBarLayout作为Toolbar和其他View的容器，它可以和CoordinatorLayout一起协作，以此响应滚动技术。
AppBarLayout通常作为CoordinatorLayout的直接子View，对应一个支持滚动的兄弟View（比如NestedScrollView, RecyclerView）。
Flags可以添加给AppBarLayout的每个View，来控制它们如何响应滚动。它们会被AppBarLayout.LayoutParams所理解。
#####Available flags are:

* enterAlways
* enterAlwaysCollapsed
* exitUntilCollapsed
* scroll
* snap
*snapMargins

在AppBarLayout中，滚动Flag标识的view，应该被声明且明确的定位在其他View之前。这样可以确保它们处在屏幕的顶部，让fixed或pinned元素在后面。

####滚动中升起
AppBarLayout也可以固定在某个位置和内容有相同的高度，在向上滚动的时候，它们可以增加这个高度，让内容在它们后面滚动。这种设计模式叫做"Lift On Scroll"，
可以通过在AppBarLayout中设置app:liftOnScroll="true"来实现。
注意：liftOnScroll属性要求应用@string/appbar_scrolling_view_behavior到滚动View（比如NestedScrollView, RecyclerView等）的layout_behavior上。

CollapsingToolbarLayout通常被用来装饰Toolbar，来提供与滚动相关的其他UI功能。


