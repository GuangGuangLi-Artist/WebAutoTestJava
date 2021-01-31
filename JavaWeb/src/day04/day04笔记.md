### 循环
    if 
    
    switch
    
    switch语句的特殊之处: case后面可以跟常量与变量或者是表达式。
    
    循环语句：
    	
    	while
    		
    		格式：
    			while(判断的条件){
    				循环体内容	
    			}
    			
    
    
    
    	var count = 0 ; 
    	while(count<5){
    		document.write("hello world<br/>");
    		count++;
    	}
    
    需求： 计算1~100的总和。
    
    	var num = 1;
    	var result = 0;
    	while(num<=100){
    		result +=num;	
    		num++;
    	}
    	
    	document.write("结果："+result);
    
    do-while循环语句
    
    	do{
    		循环语句；
    	}while(判断条件);
    	
    需求；计算1~100奇数的总和。
    
    	var num = 1;
    	var result = 0;
    	do{
    		if(num%2!=0){
    			result +=num;
    		}
    		num++;
    	}while(num<=100);
    
    	document.write("结果："+result);
    
    
    for循环语句:
    	
    	格式：
    		for(初始化语句; 判断的条件 ; 循环后的语句){
    			循环体语句；	
    		}
    		
    for-in语句：
    
    	for-in语句的格式：
    		
    		for(var 变量名 in 遍历的目标){
    			
    		}
    
    for-in语句的作用：
    	1. 可以用于遍历数组的元素。  注意： 使用for-in语句遍历数组元素的时候遍历出来是数组的下标。
    	
    	2. 可以用于遍历对象的所有属性数据。 注意： 使用for-in语句遍历对象的属性的时候，遍历出来的是对象的属性名。
    	
    
	with语句:有了 With 语句，在存取对象属性和调用方法时就不用重复指定对象。

	
	格式：
		with(对象){
			
			
				
		}

### 函数
    
    
    函数的定义格式：
    	
    	function 函数名(形参列表){
    		函数体 ;	
    	}
    
    javascript的函数要注意的细节：
    	1. 在 javascript中函数 定义形参时是不能使用var关键字声明变量 的。
    	2. 在javascript中 的函数是没有 返回值类型 的，如果函数需要返回数据给调用者，直接返回即可，如果不需要返回则不返回。
    	3. 在 javascript中是没有函数 重载 的概念 的，后定义的同名函数会直接覆盖前面定义同名函数。
    	4. 在javascript中任何的函数内部都隐式的维护了一个arguments（数组）的对象，给函数 传递数据的时候，是会先传递到arguments对象中，
    	然后再由arguments对象分配数据给形参的。
    	
    	var str1 = new String("hello");
    	var str2 = new String("hello");
    	document.write("两个字符串的对象一样吗？"+(str1.toString()==str2.toString()));
    
    创建一个字符串的方式：
    方式1：
    	new String("字符串的内容");
    	
    方式2：
    	var str = "字符串的内容";
    
    
    
    字符串常用的方法：
    	anchor（）   生产锚点
    	blink（）     为元素添加blink标签 
    	charAt()     返回指定索引位置处的字符。
    	charCodeAt() 回一个整数，代表指定位置上字符的 Unicode 编码。
    	
    	
    	fontcolor()  把带有 COLOR 属性的一个 HTML <FONT> 标记放置在 String 对象中的文本两端
    	
    	indexOf()    返回 String 对象内第一次出现子字符串的字符位置
    	
    	
    	italics()    把 HTML <I> 标记放置在 String 对象中的文本两端。 
    	
    	link()         把一个有 HREF 属性的 HTML 锚点放置在 String 对象中的文本两端。
    	
    	replace()      返回根据正则表达式进行文字替换后的字符串的复制
    	
    	split()        切割   
    	
    	Substr()       截取子串
    	toUpperCase()  转大写
    	toLowerCase    转小写
### Number对象
    	创建Number对象的方式：	
    	
    	方式1：
    		var 变量=  new Number(数字)	
    		
    	方式2：  
    		var 变量 = 数字;	
    		
    常用的方法：	
    	toString()  把数字转换成指定进制形式的字符串。
    	toFixed()   指定保留小数位,而且还带四舍五入的功能。
    	
    Math对象常用的方法：
    
     ceil 		向上取整
     floor（）   向下取整
     random()  随机数方法 //  产生的伪随机数介于 0 和 1 之间（含 0，不含 1），
     round     四舍五入
     
### Array数组对象:
     	创建数组的方式1：
     		var 变量名 = new Array();  创建一个长度为0的数组。
     	
     	方式2：
     		var 变量名= new Array(长度) 创建一个指定长度的数组对象。
     		
     	方式3：
      		var 变量名 = new Array("元素1","元素2"...);  给数组指定元素创建数组 的对象。
     		
     	方式4： 
     		var 变量名 = ["元素1","元素2"...];
     			
     
     数组要注意的细节：
     	1.  在javascript中数组的长度是可以发生变化的。
     
     arr1 = arr1.concat(arr2); //concat把arr1与arr2的数组元素组成一个新的数组返回。
     	for(var index in arr1){
     		document.write(arr1[index]+",");	
     	}
     	
     	
     	var elements = arr1.join(","); // join使用指定的分隔符把数组中的元素拼装成一个字符串返回。
     	document.write("数组的元素："+elements);
     	
     	
     	pop ：移除数组中的最后一个元素并返回该元素。
     	
     	document.write("删除最后的一个元素并返回："+arr1.pop()+"<br/>");
     	
     	arr1.push("永康"); // 将新元素添加到一个数组中，并返回数组的新长度值。
     	
     	arr1.reverse(); //翻转数组的元素
     	
     	document.write("删除第一个元素并返回："+arr1.shift()+"<br/>"); //移除数组中第一个元素，并且返回。
     	
     	
     	var subArr = arr1.slice(1,2); //指定数组 的开始索引值与结束索引值截取数组的元素，并且返回子数组。
     	document.write("子数组的元素："+subArr.join(",")+"<br/>");
     	
     	
     	
     	
     	arr1 = [19,1,20,5];
     	arr1.sort(sortNumber);  //排序，排序的时候一定要传入排序的方法。
     	
     	function sortNumber(num1,num2){
     		return num1-num2;
     	}
     	
     		
     	arr1.splice(1,1,"张三","李四","王五"); //第一个参数是开始删除元素的 索引值， 第二参数是删除元素的个数，往后的数据就是插入的元素。
### 自定义对象
    在javascript没有类的概念，只要有函数即可创建对象。
    
    	
    	自定义对象的方式1： 使用无参的函数创建对象。
    	
    	例子：
    		
    		function Person(){}
    		var p = new Person(); //创建了一个Person对象了
    		p.id = 110;
    		p.name = "狗娃";
    	
    	方式2：使用带参的函数创建对象。
    		
    		function Person(id,name){
    			this.id = id;
    			this.name = name;	
    			this.say = function(){
    				alert(name+"呵呵");	
    			}
    		}
    	
    		var p = new Person(110,"狗剩");	//创建对象
    	
    
    	方式3： 使用Object函数创建对象
    		
    		var p = new Object();
    		p.id = 110;
    		p.name = "铁蛋";
    	
    	方式4：使用字面量的方式创建.
    		
    		
    		var p = {
    			id:110,
    			name:"狗娃",
    			say:function(){
    				alert(this.name+"呵呵");	
    		}	
    	}
    	
    需求：想把getMax与searchEle方法添加 到数组对象中。
    
    	functoin Array(){
    		this.prototype = new Object();	
    		
    		this.getMax = function(){
    		
    		}
    	}	
    Prototype注意的细节：
    	1.	prototype是函数(function)的一个必备属性(书面一点的说法是"保留属性")(只要是function,就一定有一个prototype属性)
    	2.	prototype的值是一个对象
    	3.	可以任意修改函数的prototype属性的值。
    	4.	一个对象会自动拥有prototype的所有成员属性和方法。
    	     	    	