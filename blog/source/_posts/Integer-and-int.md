---
title: Java中Integer 与 int 的区别？
date: 2017-07-12 11:49:01
tags:
---
1. Integer是int的封装类型，是类对象；int是基本数据类型。
2. Integer创建对象需要实例化，初始值是null，int不需要实例化，初始值是0；
3. Integer一般作类型转换，int一般作数值参数
4. 当Integer和int比较大小时，Integer会自动解装，然后进行比较；


>关于Integer有道面试题,以下程序输出的结果是什么？<br/>
```

	Integer a = 100;
	Integer b = 100;
	System.out.println(a==b);
	Integer x = 1000;
	Integer y = 1000;
	System.out.println(x==y);
```
>以上程序输出的结果是：true  false
为什么是这个答案呢？
	两个Integer进行==比较是对象之间的比较，所以我们要考虑两个对象是不是同一个对象就可以了。
	查看Integer对象的valueOf方法源码：<br/>
```

	public static Integer valueOf(int paramInt){
		assert (IntegerCache.high >= 127);
		if ((paramInt >= -128) && (paramInt <= IntegerCache.high)) {
	      return IntegerCache.cache[(paramInt + 128)];
	    }
    return new Integer(paramInt);
  }
```<br/>
可知放Integer的值在-128~127之间时，如果常量池中存在该值，那么就直接指向，不需要重新创建，反之创建。
所以答案就是true  false。