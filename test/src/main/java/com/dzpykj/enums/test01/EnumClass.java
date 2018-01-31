package com.dzpykj.enums.test01;

import java.util.Random;

public class EnumClass {
	public static void main(String[] args) {
		for (WEEKDAY w : WEEKDAY.values()) {
			System.out.println(w + " --> " + w.ordinal() + " : " + w.getDeclaringClass());
		}

		for (WEEKDAY w : WEEKDAY.values()) {
			System.out.println(w.getDescripiton());
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(randomEnum(WEEKDAY.class));
		}
	}

	// 随机选择enum元素
	public static <T extends Enum<T>> T randomEnum(Class<T> ec) {
		Random random = new Random();
		T[] enums = ec.getEnumConstants();
		return enums[random.nextInt(enums.length)];
	}
}

enum WEEKDAY {
	MONDAY("This is the First Day of the week") {
		@Override
		boolean test() {
			return false;
		}
	},
	TUESDAY("This is the Second Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	WEDNSDAY("This is the Third Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	THURSDAY("This is the Forth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	FRIDAY("This is the Fifth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	SATURDAY("This is the Sixth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	SUNDAY("this is the Seventh Day") {
		@Override
		boolean test() {
			return false;
		}
	};

	private String description; // 自定义成员变量

	private WEEKDAY(String des) {
		this.description = des;
	} // 自定义构造方法

	public String getDescripiton() {
		return this.description;
	} // 自定义成员方法

	abstract boolean test();// 由实例去实现的抽象方法
}
