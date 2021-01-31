### windows对象
    javascript组成部分：
    	EMCAScript（基本语法）
    	BOM( Browser Object MOdel) 浏览器对象模型.
    浏览器对象模型中把浏览器 的各个部分都是用了一个对象进行描述，如果我们要
    操作浏览器的一些属性，我就可以通过浏览器对象模型 的对象进行操作。
    	
    	window  代表了一个新开的窗口
    	location 代表了地址栏对象。
    	screen  代表了整个屏幕的对象
    
    window对象常用的方法：
    	
    	open()   打开一个新的窗口。
    	resizeTo() 将窗口的大小更改为指定的宽度和高度值。
    	moveBy()  相对于原来的窗口移动指定的x、y值。 
    	moveTo() 将窗口左上角的屏幕位置移动到指定的 x 和 y 位置。 
    	
    	setInterval() 每经过指定毫秒值后就会执行指定的代码。
    	clearInterval() 根据一个任务的ID取消的定时任务。
    	setTimeout() 经过指定毫秒值后执行指定 的代码一次。
    	
    注意： 使用window对象的任何属性与方法都可以省略window对象不写的。
    
       事件： 
            注册事件的方式：
                
                方式一： 直接在html元素上注册
                    <body onload="ready()">
                        
                    function ready(){
                        alert("body的元素被加载完毕了..");	
                    }
        
                
                方式二：可以js代码向找到对应的对象再注册。 推荐使用。
    			
    			var bodyNode = document.getElementById("body");
    			
    			bodyNode.onload = function(){
    				alert("body的元素被加载完毕");	
    			} 
        */	
        
    常用的事件：
    
    	鼠标点击相关：
    		onclick 在用户用鼠标左键单击对象时触发。 
    		ondblclick 当用户双击对象时触发。 
    		onmousedown 当用户用任何鼠标按钮单击对象时触发。 
    		onmouseup 当用户在鼠标位于对象之上时释放鼠标按钮时触发。 
    
    	鼠标移动相关：
    		onmouseout  当用户将鼠标指针移出对象边界时触发。 
    		onmousemove 当用户将鼠标划过对象时触发。 
    
    	焦点相关的：
    		onblur 在对象失去输入焦点时触发。 
    		onfocus 当对象获得焦点时触发。
    
    	其他：
    		onchange 当对象或选中区的内容改变时触发。 
    		onload 在浏览器完成对象的装载后立即触发。 
    		onsubmit 当表单将要被提交时触发。
    		
    地址栏对象(Location)
    
    	href : 设置以及获取地址栏的对象
    	reload() 刷新当前的页面
    	
    Screen(屏幕)对象
    
    	availHeight	获取系统屏幕的工作区域高度，排除 Microsoft Windows 任务栏。 	
    	availWidth	获取系统屏幕的工作区域宽度，排除 Windows 任务栏。 	
    	height		获取屏幕的垂直分辨率。 
    	width		获取屏幕的水平分辨率。 
### DOM(Document Object Model) 文档对象模型
      	
    一个html页面被浏览器加载的时候，浏览器就会对整个html页面上的所有标签都会创建一个对应的
    对象进行描述，我在浏览器上看到的信息只不过就是这些html对象的属性信息而已。我们只要能找到
    对应的对象操作对象的属性，则可以改变浏览器当前显示的内容。  	
  
    var allNodes = document.all;   //获取html文件中的所有标签节点 。
    for(var i = 0; i<allNodes.length ; i++){
        alert(allNodes[i].nodeName);	 //标签的名字  nodeName;
    }
    
    通过html元素的标签属性找节点。
    		document.getElementById("html元素的id") 
    		document.getElementsByTagName("标签名") 
    		document.getElementsByName("html元素的name")
    InnerHTml是用于设置标签体的内容的。 value是用于设置标签的value属性值.
    
    	通过关系(父子关系、兄弟关系)找标签。
    		parentNode	获取当前元素的父节点。
    		childNodes	获取当前元素的所有下一级子元素。
    		firstChild	获取当前节点的第一个子节点。
    		lastChild	获取当前节点的最后一个子节点。
    ------------------------------------------------------------	
    		nextSibling		获取当前节点的下一个节点。（兄节点）
    		previousSibling	获取当前节点的上一个节点。（弟节点）
    		
    我们可以通过标签的类型进行判断筛选：
    	
    	文本节点的类型： 3
    	注释的节点类型： 8
    	标签节点的类型： 1
    创建字节入插入节点、设置节点的属性。
     
     	
    	document.createElement("标签名")		创建新元素节点
    	elt.setAttribute("属性名", "属性值")	设置属性
    	elt.appendChild(e)						添加元素到elt中最后的位置
    	
    插入目标元素的位置	 
    	elt.insertBefore(newNode, oldNode);			添加到elt中，child之前。
    	注意： elt必须是oldNode的直接父节点。
    					               
    	elt.removeChild(child)					删除指定的子节点
    	
    	注意： elt必须是child的直接父节点。
    正则表达式的创建方式：
    		""	
    			
    	方式1：
    		/正则表达式/模式
    		
    	方式2：
    		new RegExp("正则表达式",模式);
    	
    正则表达式对象常用的方法：
    	 test()  使用正则对象去匹配字符串  如果匹配成功返回ture，否则返回false.	
    	 exec()  根据正则表达式去查找字符串符合规则的内容。
    
    模式：
    	g （全文查找出现的所有 pattern） 	
    	i （忽略大小写）
    
    
    
    	
    	var str = "hello123";
    	var reg = /^[A-Z0-9]+$/i;
    	alert("匹配吗？"+reg.test(str));	
    
    查找出三个字符组成的单词。
    
    昨天内容回顾
    	1、在末尾添加节点：
    		* 创建标签 createElement
    		* 创建文本 createTextNode
    		* 把文本添加到标签下面 appendChild
    	
    	2、获取标签下面的子标签的唯一有效方法
    		* getElementsByTagName
    	
    	3、nodeType
    		* 标签节点：1
    		* 属性节点：2
    		* 文本节点：3
    	
    		* 父节点：parentNode
    	
    	4、方法
    		* appendChild
    		* 在某个节点之前插入节点：insertBefore(new,old);
    			- 通过父节点插入
    		* 删除节点：removeChild方法
    			- 通过父节点删除
    		* 替换节点：replaceChild(new,old)
    			- - 通过父节点替换
    
    	5、innerHTML属性
    		* 获取文本内容
    		* 向标签内设置内容（可以是html代码）
    	
    	** 写js的方法的命名
    		add1()、add_1()
    
    		** 不要写单一的单词 add()
    		** 不要把下划线放在开始位置 _add()
    
    1、表单提交方式
    	* 使用submit提交
    	<form>
    		.....
    		<input type="submit" />
    	</form>
    
    	* 使用button提交表单
    		- 代码
    		//实现提交方法
    		function form1() {
    			//获取form
    			var form1 = document.getElementById("form1");
    			//设置action
    			form1.action = "hello.html";
    			//提交form表单
    			form1.submit();
    		}
    	
    	* 使用超链接提交
    		- 代码
    		<a href="hello.html?username=123456">使用超链接提交</a>
    	
    	* onclick：鼠标点击事件
    	  onchange：改变内容（一般和select一起使用）
    
    	  onfocus:得到焦点  (ie5、某些版本的ie6)
    	  onblur:失去焦点
    
    2、xml的简介（了解）
    	* eXtensible Markup Language：可扩展标记型语言
    		** 标记型语言：html是标记型语言
    			- 也是使用标签来操作
    		** 可扩展：
    			- html里面的标签是固定，每个标签都有特定的含义 <h1> <br/> <hr/>
    			- 标签可以自己定义,可以写中文的标签 <person></person、<猫></猫>
    	
    	* xml用途
    		** html是用于显示数据，xml也可以显示数据（不是主要功能）
    		** xml主要功能，为了存储数据
    
    	* xml是w3c组织发布的技术
    	
    	* xml有两个版本 1.0  1.1
    		- 使用都是1.0版本，（1.1版本不能向下兼容）
    
    3、xml的应用
    	* 不同的系统之间传输数据
    		** qq之间数据的传输
    		** 画图分析过程
    
    	* 用来表示生活中有关系的数据
    		
    	* 经常用在文件配置
    		* 比如现在连接数据库 肯定知道数据库的用户名和密码，数据名称 
    		* 如果修改数据库的信息，不需要修改源代码，只要修改配置文件就可以了
    		
    
    4、xml的语法
    	（1）xml的文档声明（***）
    		* 创建一个文件 后缀名是 .xml
    		* 如果写xml，第一步 必须要有 一个文档声明（写了文档声明之后，表示写xml文件的内容）
    		** <?xml version="1.0" encoding="gbk"?>
    		*** 文档声明必须写在 第一行第一列
    
    		* 属性
    			- version：xml的版本 1.0(使用) 1.1
    			- encoding：xml编码 gbk  utf-8  iso8859-1(不包含中文)
    			- standalone：是否需要依赖其他文件 yes/no
    		
    		* xml的中文乱码问题解决
    			** 画图分析乱码问题
    			** 保存时候的编码和设置打开时候的编码一致，不会出现乱码
    
    	（2）定义元素（标签）（***）
    	（3）定义属性（***）
    	（4）注释（***）
    	（5）特殊字符（***）
    	（6）CDATA区（了解）
    	（7）PI指令（了解）
    
    5、xml的元素（标签）定义（*****）
    	** 标签定义
    
    	** 标签定义有开始必须要有结束：<person></person>
    	** 标签没有内容，可以在标签内结束 ; <aa/>
    	** 标签可以嵌套，必须要合理嵌套
    		*** 合理嵌套 <aa><bb></bb></aa>
    		*** 不合理嵌套 <aa><bb></aa></bb>: 这种方式是不正确的
    	** 一个xml中，只能有一个根标签，其他标签都是这个标签下面的标签
    
    	** 在xml中把空格和换行都当成内容来解析，
    		**** 下面这两段代码含义是不一样的
    		* <aa>1111111</aa>
    		* <aa>
    			11111111111
    		  </aa>
    	
    	** xml标签可以是中文
    
    	** xml中标签的名称规则
    		（1）xml代码区分大小写
    			<p> <P>:这两个标签是不一样的
    		（2）xml的标签不能以数字和下划线(_)开头
    			<2a> <_aa>: 这样是不正确的
    		（3）xml的标签不能以xml、XML、Xml等开头
    			<xmla> <XmlB> <XMLC>: 这些都是不正确的
    		（4）xml的标签不能包含空格和冒号
    			<a b> <b:c> : 这些是不正确的
    
    6、xml中属性的定义（*****）
    	* html是标记型文档，可以有属性
    	* xml也是标记型文档，可以有属性
    
    	* <person id1="aaa" id2="bbb"></person>
    
    	** 属性定义的要求
    		（1）一个标签上可以有多个属性
    			<person id1="aaa" id2="bbb"></person>
    		（2）属性名称不能相同
    			<person id1="aaa" id1="bbb"></person>：这个是不正确，不能有两个id1
    		（3）属性名称和属性值之间使用= ，属性值使用引号包起来 （可以是单引号，也可以是双引号 ）
    		（4）xml属性的名称规范和元素的名称规范一致
    
    7、xml中的注释（*****）
    	* 写法 <!-- xml的注释 -->
    	** 注意的地方
    		**** 注释不能嵌套
    			<!--  <!-- -->  -->
    			<!-- <!-- <sex>nv</sex>--> -->
    	** 注释也不能放到第一行，第一行第一列必须放文档声明
    
    8、xml中的特殊字符（*****）
    	* 如果想要在xml中现在 a<b ,不能正常显示，因为把<当做标签
    	* 如果就想要显示，需要对特殊字符 < 进行转义
    	** <    &lt;
    	   >    &gt;
     
     9、CDATA区（了解）
    	* 可以解决多个字符都需要转义的操作 if(a<b && b<c && d>f) {}
    	* 把这些内容放到CDATA区里面，不需要转义了
    	** 写法
    		<![CDATA[ 内容  ]]>
    		- 代码
    		<![CDATA[ <b>if(a<b && b<c && d>f) {}</b> ]]>
    	** 把特殊字符，当做文本内容，而不是标签
    
    10、PI指令（处理指令）（了解）
    	* 可以在xml中设置样式
    	* 写法： <?xml-stylesheet type="text/css" href="css的路径"?>
    
    	* 设置样式，只能对英文标签名称起作用，对于中文的标签名称不起作用的。
    
    	** xml的语法的总结
    		所有 XML 元素都须有关闭标签
    		XML 标签对大小写敏感
    		XML 必须正确地嵌套顺序
    		XML 文档必须有根元素(只有一个)
    		XML 的属性值须加引号
    		特殊字符必须转义 --- CDATA
    		XML 中的空格、回车换行会解析时被保留
    
    11、xml的约束
    	* 为什么需要约束？
    	** 比如现在定义一个person的xml文件，只想要这个文件里面保存人的信息，比如name age等，但是如果在xml文件中
    	写了一个标签<猫>，发现可以正常显示，因为符合语法规范。但是猫肯定不是人的信息，xml的标签是自定义的，需要技术来
    	规定xml中只能出现的元素，这个时候需要约束。
    
    	* xml的约束的技术 ： dtd约束 和 schema约束 （看懂）
    
    12、dtd的快速入门
    	* 创建一个文件 后缀名 .dtd
    
    	步骤：
    		（1）看xml中有多少个元素 ，有几个元素，在dtd文件中写几个 <!ELEMENT>
    		（2）判断元素是简单元素还是复杂元素
    			- 复杂元素：有子元素的元素
    				<!ELEMENT 元素名称 (子元素)>
    			- 简单元素：没有子元素
    				<!ELEMENT 元素名称 (#PCDATA)>
    		（3）需要在xml文件中引入dtd文件
    			<!DOCTYPE 根元素名称 SYSTEM "dtd文件的路径">
    	
    	** 打开xml文件使用浏览器打开的，浏览器只负责校验xml的语法，不负责校验约束
    
    	** 如果想要校验xml的约束，需要使用工具（myeclipse工具）
    
    	** 打开myeclipse开发工具
    		*** 创建一个项目 day05
    		*** 在day05的src目录下面创建一个xml文件和一个dtd文件
    		*** 当xml中引入dtd文件之后，比如只能出现name age，多写了一个a，会提示出错
    
    13、dtd的三种引入方式
    	（1）引入外部的dtd文件
    		<!DOCTYPE 根元素名称 SYSTEM "dtd路径">
    	（2）使用内部的dtd文件
    		- <!DOCTYPE 根元素名称 [
    			<!ELEMENT person (name,age)>
    			<!ELEMENT name (#PCDATA)>
    			<!ELEMENT age (#PCDATA)>
    		]>
    	（3）使用外部的dtd文件（网络上的dtd文件）
    		<!DOCTYPE 根元素 PUBLIC "DTD名称" "DTD文档的URL">
    		- 后面学到框架 struts2 使用配置文件 使用 外部的dtd文件
    		- <!DOCTYPE struts PUBLIC   "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"    
    		   "http://struts.apache.org/dtds/struts-2.0.dtd">
    
    14、使用dtd定义元素
    	* 语法： <!ELEMENT 元素名 约束>
    
    	* 简单元素：没有子元素的元素
    		<!ELEMENT name (#PCDATA)>
    		*** (#PCDATA): 约束name是字符串类型
    		*** EMPTY : 元素为空（没有内容）
    			- <sex></sex>
    		*** ANY:任意
    	* 复杂元素：
    		<!ELEMENT person (name,age,sex,school)>
    			- 子元素只能出现一次
    		* <!ELEMENT 元素名称 (子元素)>
    
    		* 表示子元素出现的次数
    			+ : 表示一次或者多次
    			? ：表示零次或者一次
    			* ：表示零次或者多次
    		
    		* 子元素直接使用逗号进行隔开 ,
    			** 表示元素出现的顺序
    
    		* 子元素直接使用|隔开
    			** 表示元素只能出现其中的任意一个
    	
    15、使用dtd定义属性
    	* 语法： <!ATTLIST 元素名称
    			属性名称 属性类型 属性的约束
    		 >
    	
    	* 属性类型
    		- CDATA: 字符串
    			- 	<!ATTLIST birthday
    				ID1 CDATA #REQUIRED
    			>
    
    		- 枚举 ： 表示只能在一定的范围内出现值，但是只能每次出现其中的一个
    			** 红绿灯效果
    			** (aa|bb|cc)
    			- <!ATTLIST age
    				ID2 (AA|BB|CC)  #REQUIRED
    			>
    
    		- ID: 值只能是字母或者下划线开头
    			- <!ATTLIST name 
    				ID3 ID   #REQUIRED
    			>
    	
    	* 属性的约束
    		- #REQUIRED：属性必须存在
    
    		- #IMPLIED：属性可有可无
    
    		- #FIXED: 表示一个固定值 #FIXED "AAA"
    			- 属性的值必须是设置的这个固定值
    			- <!ATTLIST sex
    				ID4 CDATA #FIXED "ABC"
    			>
    		- 直接值
    			* 不写属性，使用直接值
    			* 写了属性，使用设置那个值
    			- <!ATTLIST school
    				ID5 CDATA "WWW"
    			>
    
    16、实体的定义
    	* 语法： <!ENTITY 实体名称 "实体的值">
    	*** <!ENTITY TEST "HAHAHEHE">
    	*** 使用实体 &实体名称;  比如 &TEST;
    
    	** 注意
    		* 定义实体需要写在内部dtd里面，
    		  如果写在外部的dtd里面，有某些浏览器下，内容得不到
    
    
    17、xml的解析的简介（写到java代码）（***今天最重要的内容*****）
    	* xml是标记型文档
    	* js使用dom解析标记型文档？
    		- 根据html的层级结构，在内存中分配一个树形结构，把html的标签，属性和文本都封装成对象
    		- document对象、element对象、属性对象、文本对象、Node节点对象
    	
    	* xml的解析方式（技术）：dom 和 sax
    		** 画图分析使用dom和sax解析xml过程
    		*** dom解析和sax解析区别：
    		** dom方式解析
    			* 根据xml的层级结构在内存中分配一个树形结构，把xml的标签，属性和文本都封装成对象
    			* 缺点：如果文件过大，造成内存溢出
    			* 优点：很方便实现增删改操作
    
    		** sax方式解析
    			* 采用事件驱动，边读边解析
    				- 从上到下，一行一行的解析，解析到某一个对象，返回对象名称
    			* 缺点：不能实现增删改操作
    			* 优点：如果文件过大，不会造成内存溢出，方便实现查询操作
    	
    	* 想要解析xml，首先需要解析器
    	** 不同的公司和组织提供了 针对dom和sax方式的解析器，通过api方式提供
    	*** sun公司提供了针对dom和sax解析器  jaxp
    	*** dom4j组织，针对dom和sax解析器    dom4j（*** 实际开发中****）
    	*** jdom组织，针对dom和sax解析器     jdom
    
    18、jaxp的api的查看
    	** jaxp是javase的一部分
    
    	** jaxp解析器在jdk的javax.xml.parsers包里面
    		** 四个类：分别是针对dom和sax解析使用的类
    		*** dom： 
    			DocumentBuilder  : 解析器类
    				- 这个类是一个抽象类，不能new，
    				此类的实例可以从 DocumentBuilderFactory.newDocumentBuilder() 方法获取
    
    				- 一个方法，可以解析xml  parse("xml路径") 返回是 Document 整个文档
    				- 返回的document是一个接口，父节点是Node，如果在document里面找不到想要的方法，到Node里面去找
    				
    				- 在document里面方法 
    					getElementsByTagName(String tagname) 
    					-- 这个方法可以得到标签
    					-- 返回集合 NodeList
    
    					createElement(String tagName)
    					-- 创建标签
    
    					createTextNode(String data) 
    					-- 创建文本
    
    					appendChild(Node newChild) 
    					-- 把文本添加到标签下面
    
    					removeChild(Node oldChild) 
    					-- 删除节点
    
    					getParentNode() 
    					-- 获取父节点
    
    					NodeList list
    					- getLength() 得到集合的长度
    					- item(int index)下标取到具体的值
    					for(int i=0;i<list.getLength();i++) {
    						list.item(i)
    					}
    
    					getTextContent()
    					- 得到标签里面的内容
    				
    			DocumentBuilderFactory： 解析器工厂
    				- 这个类也是一个抽象类，不能new
    				newInstance() 获取 DocumentBuilderFactory 的实例。
    
    		*** sax：
    			SAXParser：解析器类
    			SAXParserFactory: 解析器工厂
    
    19、使用jaxp实现查询操作
    	*** 查询xml中所有的name元素的值
    	* 步骤
    	//查询所有name元素的值
    	/*
    	 * 1、创建解析器工厂
    		DocumentBuilderFactory.newInstance();
    	 * 2、根据解析器工厂创建解析器
    		builderFactory.newDocumentBuilder();
    	 * 3、解析xml返回document
    	 *	Document document = builder.parse("src/person.xml");
    	 * 4、得到所有的name元素
    		使用document.getElementsByTagName("name");
    	 * 5、返回集合，遍历集合，得到每一个name元素
    		- 遍历 getLength() item()
    		- 得到元素里面值 使用 getTextContent()
    	 * */
    
    	 *** 查询xml中第一个name元素的值
    	 * 步骤
    	 /*
    		 * 1、创建解析器工厂
    		 * 2、根据解析器工厂创建解析器
    		 * 3、解析xml，返回document
    		 * 
    		 * 4、得到所有name元素
    		 * 5、使用返回集合，里面方法 item，下标获取具体的元素
    			NodeList.item(下标)： 集合下标从0开始
    		 * 6、得到具体的值，使用 getTextContent方法
    		 * 
    		 * */
    
    20、使用jaxp添加节点
    	*** 在第一个p1下面（末尾）添加 <sex>nv</sex>
    	**步骤
    	/*
    		 * 1、创建解析器工厂
    		 * 2、根据解析器工厂创建解析器
    		 * 3、解析xml，返回document
    		 * 
    		 * 4、得到第一个p1
    		 * 	- 得到所有p1，使用item方法下标得到
    
    		 * 5、创建sex标签 createElement
    		 * 6、创建文本 createTextNode
    		 * 7、把文本添加到sex下面 appendChild
    
    		 * 8、把sex添加到第一个p1下面　appendChild
    		 * 
    		 * 9、回写xml
    		 * */
    
    21、使用jaxp修改节点
    	*** 修改第一个p1下面的sex内容是nan
    	** 步骤
    	/*
    		 * 1、创建解析器工厂
    		 * 2、根据解析器工厂创建解析器
    		 * 3、解析xml，返回document 
    		 * 
    		 * 4、得到sex item方法
    		 * 5、修改sex里面的值  
    			*** setTextContent方法
    		 * 
    		 * 6、回写xml
    		 * */
    
    22、使用jaxp删除节点
    	*** 删除<sex>nan</sex>节点
    	** 步骤
    	/*
    		 * 1、创建解析器工厂
    		 * 2、根据解析器工厂创建解析器
    		 * 3、解析xml，返回document 
    		 * 
    		 * 4、获取sex元素
    		 * 5、获取sex的父节点  使用getParentNode方法
    		 * 6、删除使用父节点删除  removeChild方法
    		 * 
    		 * 7、回写xml
    		 * */
    
    23、使用jaxp遍历节点
    	** 把xml中的所有元素名称打印出来
    	** 步骤
    	/*
    		 * 1、创建解析器工厂
    		 * 2、根据解析器工厂创建解析器
    		 * 3、解析xml，返回document
    		 * 
    		 * ====使用递归实现=====
    		 * 4、得到根节点
    		 * 5、得到根节点子节点
    		 * 6、得到根节点子节点的子节点
    		 * */
    	** 遍历的方法
    	//递归遍历的方法
    	private static void list1(Node node) {
    		//判断是元素类型时候才打印
    		if(node.getNodeType() == Node.ELEMENT_NODE) {			
    			System.out.println(node.getNodeName());
    		}
    		
    		//得到一层子节点
    		NodeList list = node.getChildNodes();
    		//遍历list
    		for(int i=0;i<list.getLength();i++) {
    			//得到每一个节点
    			Node node1 = list.item(i);
    			//继续得到node1的子节点
    			//node1.getChildNodes()
    			list1(node1);
    		}
    	}