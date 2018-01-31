package com.dzpykj.enums.test02;

public class Constant {
	
	public enum Gender{
		//男,女,未知
		man,woman,unkown
	}

	public enum Color {
		RED("红色", 1){
			@Override
			public String getName() {
				return "红色:就跟你们不一样";
			}

			@Override
			String getAll() {
				return "红色enum的个性内容->"+this.getIndex()+" : "+this.getName();
			}
		}, 
		GREEN("绿色", 2) {
			@Override
			public String getName() {
				return "绿色:你爱怎样就怎样";
			}
			
			@Override
			String getAll() {
				return "绿色enum的个性内容->"+this.getIndex()+" : "+this.getName();
			}
		}, 
		BLANK("白色", 3) {
			@Override
			String getAll() {
				return "白色enum的个性内容->"+this.getIndex()+" : "+this.getName();
			}
		}, 
		YELLO("黄色", 4) {
			@Override
			String getAll() {
				return "黄色enum的个性内容->"+this.getIndex()+" : "+this.getName();
			}
		};
		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private Color(String name, int index) {
			this.name = name;
			this.index = index;
		}

		abstract String getAll();// 由实例去实现的抽象方法
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
}
