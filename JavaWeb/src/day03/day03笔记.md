### CSS
    
	html 在一个网页中负责的事情是一个页面的结构
    
    css(层叠样式表) 在一个网页中主要负责了页面的数据样式。
    
    编写css代码的方式：
	
    第一种： 在style标签中编写css代码。   只能用于本页面中，复用性不强。
    
        格式 ：
            
            <style type="text\css">
                编写css的代码。
            </style>   
        例子：
        	<style type="text\css">
        	   a{
                    color:#F00;
                    text-decoration:none;
				}
     	  </style>   
     
    第二种： 可以引入外部的css文件。  推荐使用。
     	
        方式1： 使用link标签。   推荐使用...
        	格式：
            	<link href="css文件的路径" rel="stylesheet">
            
            例子： <link href="1.css" rel="stylesheet"/>
     
        方式2：使用<style>引入
        			
             格式：	
             		<style type="text/css" >
                    	@import url("css的路径");
                    </style>
                    
             例子：
             	<style type="text/css" >
					@import url("1.css");
				</style>
    
    第三种方式：直接在html标签使用style属性编写。    只能用于本标签中，复用性较差。 不推荐使用。
    	  
          例子：
          	<a style="color:#0F0; text-decoration:none" href="#">新闻的标题1</a>
    
    
    选择器： 选择器的作用就是找到对应的数据进行样式化。
    
    	1.标签选择器： 就是找到所有指定的标签进行样式化。
    	
    		格式：	
    			标签名{
    				样式1；样式2....	
    			}
    			
    		例子：
    			div{
    				color:#F00;
    				font-size:24px;
    			}
    	2. 类选择器: 使用类选择器首先要给html标签指定对应的class属性值。
    		
    		格式：
    			.class的属性值{
    				样式1；样式2...	
    			}	
    			
    		例子：
    			.two{
    				background-color:#0F0;
    				color:#F00;
    				font-size:24px;
    			}
    	
    
    			
    	类选择器要注意的事项：
    		1. html元素的class属性值一定不能以数字开头.
    		2. 类选择器的样式是要优先于标签选择器的样式。
    		
    		
    	3. ID选择器： 使用ID选择器首先要给html元素添加一个id的属性值。
    			
    			ID选择器的格式：
    				
    				#id属性值{
    					样式1；样式2...	
    				}
    		id选择器要注意的事项：
    			1. ID选择器的样式优先级是最高的，优先于类选择器与标签选择器。
    			2. ID的属性值也是不能以数字开头的。
    			3. ID的属性值在一个html页面中只能出现一次。
    			
    	4. 交集选择器： 就是对选择器1中的选择器2里面的数据进行样式化。
    		
    	
    		选择器1 选择器2{
    			样式1，样式2....	
    		}
    		
    		例子：
    			.two span{
    				background-color:#999;
    				font-size:24px;
    			}
    			
    			
    			
    
    	5. 并集选择器： 对指定的选择器进行统一的样式化。
    		
    		格式：	
    			选择器1,选择器2..{
    				样式1；样式2...
    			}
    			
    		span,a{
    			border-style:solid;
    			border-color:#F00;
    		}
    	6. 通用选择器:
    		
    			*{
    				样式1；样式2...
    			}	
    	
    	
    */	
    	
    	*{
    		text-decoration:line-through;
    		background-color:#CCC;
    	}
    	
    伪类选择器：伪类选择器就是对元素处于某种状态下进行样式的。
     
     
     注意： 
     	1. a:hover 必须被置于 a:link 和 a:visited 之后
    	
    	2. a:active 必须被置于 a:hover 之后
    	
    常用的css样式
    	/*操作背景的属性 */
    	body{
    		/*background-color:#CCC;  设置背景颜色*/
    		background-image:url(2.jpg);
    		background-repeat:no-repeat;  /*  设置背图片是否要重复 */
    		background-position:370px 100px; /* 设置背景图片的位置， 第一个参数是左上角的左边距， 第二个参数是左上角的上边距 */
    	}
    	
    	
    	/* 操作文本的样式 */
    	
    	div{
    		color:#F00;
    		font-size:16px;
    		line-height:40px;
    		letter-spacing:10px;
    		text-align:center;
    		text-decoration:none;
    		text-transform:uppercase; 
    		
    	}
    
    盒子模型: 盒子模型就是把一个html边框比作成了一个盒子的边框，盒子模型要做用于操作数据与边框之间的距离或者 是边框与边框之间的距离。	
    盒子模型主要是用于操作内边距(padding)与外边距（margin）
    Margin（外边距） - 清除边框区域。Margin 没有背景颜色，它是完全透明
    Border（边框） - 边框周围的填充和内容。边框是受到盒子的背景颜色影响
    Padding（内边距） - 清除内容周围的区域。会受到框中填充的背景颜色影响
    Content（内容） - 盒子的内容，显示文本和图像
    
    css的定位：
    	
    	相对定位： 相对定位是相对于元素原本的位置进行移动的。
    		
    	使用方式：	position:relative;
    	
    	
    	绝对定位： 绝对定位是相对于整个页面而言。
    		position:absolute; 
    		top:200px;
    		left:380px;
    		
    	固定定位：
    		position:fixed; /* 固定定位: 固定定位是相对于整个浏览器而已的。 
    		top:380px;
    		left:1000px;
    		
### Javascript
      
    如何编写javascript的代码。
	
    方式1：可以使用<script>标签体内进行编写。
    
    	格式：
        	<script type="text/javascript">
            		js代码;;
            </script>	
    
	方式2：引入外部的javascript文件。
    
    	格式：	
        	<script src="1.js" type="text/javascript"></script>
            
    	注意： 
        	1.<script>是有开始标签与结束标签的，千万不要在一个标签中结束了。
    		2.如果<script>已经用于引入了js文件，那么该<script>标签体就不能再写js代码了，
            

    javascript常用的函数：
	
    alert("显示的内容..") ; 弹出框    
    
    document.write("数据") ; //向页面输出数据...
    
  
    页面的注释：
	
    html <!--  注释的内容
    
    css的注释  /* 注释的内容*/  
    
    javascript：  //注释的内容  单行注释  		/* 注释的内容*/ 多行注释
    
    javascript的变量声明：
    	格式：
    		var 变量名 = 数据;
    		
    		
    	声明变量要注意的事项：
    		1. 在javascript中声明变量是 使用var关键字声明的，javascript中的变量可以存储任意的数据类型数据.
    		2. javascript中变量数据类型是根据存储的值决定的，可以随时更改存储数据的类型。
    		3. 定义了多个同名的变量是，后定义的同名变量是覆盖前面定义的同名变量。
    		4. 声明变量的时候可以省略var关键字，但是不建议省略。
    
    
    javascript的数据类型：
    	
    	typeof 查看变量的数据类型。
    	
    	使用格式：
    			
    			typeof 变量名		
    	
    javascript的数据类型：
    
    	number 小数与整数
    	
    	string 字符串 注意： javascript中没有字符的概念，只有字符串，字符串可以写在单引号或双引号中。
    	
    	boolean 布尔数据类型，
    	
    	undefined  undefined代表该变量没有定义。
    	
    
	字符串转数字
		parseInt()  可以把一个字符串转换成整数。
		parseFloat() 可以把一个字符串转换成小数。
		
	运算符:	
    		+(加法、正数、 连接符)
    		
    		true 是1. false是0
    		
    比较运算符
    	
    
    字符串与字符串的比较规则是：
    	
    	情况1： 能找到对应位置上的不同字符，那么就比较第一个不同字符的大小。
    	
    	情况2： 不能找到对应位置上的不同字符，这时候比较的是两个字符串的长度。
    	
    逻辑运算符:
    
    三目运算符	
    
    	布尔表达式?值1:值2;
    	
    控制流程语句
    
    	if语句
    	
    	格式：
    		if(判断条件){
    			符合条件执行的代码	
    		}	
    	
    	if语句的特殊之处： 
    		1. 在javascript中的if语句条件不单止可以写布尔表达式，还可以写任何的数据。
    		
    		number  非0为true, 0为false.
    		string  内容不能空是true， 内容空的时候是false。
    		undefined：false
        	NaN:    false
    	
    	
    	
    	var workAge = 0;
    	var str ="";
    	var b;
    	if(b){
    		document.write("明天过来面试！！");
    	}else{
    		document.write("不要在投我们公司了，不要你！");	
    	}
    	
    
    选择语句： 
    	switch语句
    	
    		switch(变量){
    			case 值1:&nbsp;
    				
    				break;
    			case 值2：
    				
    				break;
    			case 值3:
    				
    				break;
    				
    			.....
    				
    			default：
    				
    				break;
    			
    		}
    		
    	特殊之处：
    		1. 	在javascript中case后面可以跟常量与变量还可以跟表达式。
    
    	