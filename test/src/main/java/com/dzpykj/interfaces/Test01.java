package com.dzpykj.interfaces;

//@FunctionalInterface标记在接口上，“函数式接口”是指仅仅只包含一个抽象方法的接口
@FunctionalInterface
public interface Test01 {

	// 抽象方法
	public void sub();

	// java.lang.Object中的方法不是抽象方法
	public boolean equals(Object var1);

	// default不是抽象方法
	//函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
	public default void defaultMethod() {

	}

	// static不是抽象方法
	//函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
	public static void staticMethod() {

	}
}
