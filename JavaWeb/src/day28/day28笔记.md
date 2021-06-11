### Servlet3.0
    
    一、要求
    1. MyEclipse10.0或以上版本！
    2. 发布到Tomcat7.0或以上版本！
    
    二、步骤
    1. 创建JavaEE6.0应用！
    
    -----------------------------
    
    三、概述
    * 注解代替web.xml配置文件
    * 异步处理
    * 对上传的支持
    
    　　Servlet3.0在市场上没有应用！
    
    -----------------------------
    
    四、注解代替配置文件
    
    1. 删除web.xml
    2. 在Servlet类上添加@WebServlet(urlPatterns={"/AServlet"})
    
    总结：
      * 注解好处：配置信息少！
      * 注解缺点：不方便修改！
    
    3. 在Filter类上添加@WebFilter(urlPatterns="/AFilter")
    
    4. 在Listener类上添加@WebListener
    
    
    -----------------------------
    
    五、异步处理
      1. 什么是异步处理
        原来，在服务器没有结束响应之前，浏览器是看不到响应内容的！只有响应结束时，浏览器才能显示结果！
        现在异步处理的作用：在服务器开始响应后，浏览器就可以看到响应内容，不用等待服务器响应结束！
    
      2. 实现异步的步骤
    
      * 得到AsyncContext，它异步上下文对象
        AsyncContext ac = request.startAsync(request,response);
      * 给上下文一个Runnable对象，启动它！（给上下文一个任务，让它完成！）
        ac.start(new Runnable() {
          public void run() {
            ...
          }
        });
    
      * @WebServlet(urlPatterns="/AServlet", asyncSupported=true)
      * resp.setContentType("text/html;charset=utf-8");
      * IE如果不能正常输出，这说明响应体大小不足512B，那你需要多输出点废话！
      * AsyncContext#complete()：通知Tomcat我们异步线程已经执行结束了！这让Tomcat才会及时的断开与浏览器的连接！
    				
    -----------------------------
    
    六、上传支持
    
    1. 上传
    
    　　* 上传对表单的要求：
    　　　　> method="post"
    　　　　> enctype="multipart/form-data"，它的默认值是：application/x-www-form-urlencoded
    　　　　> <input type="file" name="必须给"/>
    
    　　* 上传Servlet的使用：
    　　　　> request.getParameter()不能再用
    　　　　> request.getInputStream()使用它来获取整个表单的数据！
    
    　　* commons-fileupload
    　　　　> 创建工厂
    　　　　> 解析器
    　　　　> 使用解析器来解析request对象，得到List<FileItem>
    
    　　==============
    
    　　Servlet3.0对上传提供了支持：
    　　* 表单不变
    　　* 在Servlet中不需要再使用commons-fileupload，而是使用Servlet3.0提供的上传组件接口！
    
    　　==============
    
    　　上传的步骤：
    　　* 使用request.getPart("字段名")，得到Part实例，
    　　* Part：
    　　　> String getContentType()：获取上传文件的MIME类型
    　　　> String getName()：获取表单项的名称，不是文件名称
    　　　> String getHeader(String header)：获取指定头的值
    　　　> long getSize()：获取上传文件的大小
    　　　> InputStream getInputStream()：获取上传文件的内容
    　　　> void write(String fileName)：把上传文件保存到指定路径下
        * 默认Servlet是不支持使用上传组件：需要给Servlet添加一个注解: @MultipartConfig
    
        它没有提供获取上传文件名称的方法：
        * 这需要我们自己从Content-Disposition头中截取！
    
    -----------------------------
    
### 动态代理
    
    1. 只学一个方法
    　　方法的作用：在运行时，动态创建一组指定的接口的实现类对象！（在运行时，创建实现了指定的一组接口的对象）
    
    interface A {
    }
    
    interface B {
    }
    
    Object o = 方法(new Class[]{A.class,B.class})
    o它实现了A和B两个接口！
    
    
    -------------
    
    
    Object proxyObject = Proxy.newProxyInstance(ClassLoader classLoader, Class[] interfaces, InvocationHandler h);
    1. 方法作用：动态创建实现了interfaces数组中所有指定接口的实现类对象！
    参数；
    1. ClassLoader：类加载器！
      * 它是用来加载器的，把.class文件加载到内存，形成Class对象！
    2. Class[]　interfaces：指定要实现的接口们
    3. InvocationHandler：代理对象的所有方法(个别不执行，getClass())都会调用InvocationHandler的invoke()方法。
    
    
    ---------------------------------------------------------
    
    2. 动态代理作用
      最终是学习AOP（面向切面编程），它与装饰者模式有点相似，它比装饰者模式还要灵活！
    
    ----------------------------------------------------------
    
    InvocationHandler
    
    public Object invoke(Object proxy, Method method, Object[] args);
    
    这个invoke()方法在什么时候被调用！
    1. 在代理对象被创建时?错误的！
    2. 在调用代理对象所实现接口中的方法时?正确的！
    
    * Object proxy：当前对象，即代理对象！在调用谁的方法！
    * Method method：当前被调用的方法（目标方法）
    * Object[] args：实参！
    
    ----------------------------
    
    目标对象：被增强的对象
    代理对象：需要目标对象，然后在目标对象上添加了增强后的对象！
    目标方法：增强的内容
    
    代理对象 = 目标对象 + 增强
    
### 类加载器
    1. 什么是类加载器
      * 把.class文件加载到JVM的方法区中，变成一个Class对象！
    
    2. 得到类加载器
      * Class#getClassLoader()
    
    3. 类加载器的分类
      它们都是片警！
      * 引导：类库！
      * 扩展：扩展jar包
      * 系统：应用下的class，包含开发人员写的类，和第三方的jar包！classpath下的类！
    
      系统类加载器的上层领导：扩展
      扩展类加载器的上层领导：引导
      引导没上层，它是BOSS
    
      ======================================
    
    4. 类加载器的委托机制
      * 代码中出现了这么一行：new A();
        > 系统发现了自己加载的类，其中包含了new A()，这说明需要系统去加载A类
        > 系统会给自己的领导打电话：让扩展去自己的地盘去加载A类
        > 扩展会给自己的领导打电话：让引导去自己的地盘去加载A类
        > 引导自己真的去rt.jar中寻找A类
          * 如果找到了，那么加载之，然后返回A对应的Class对象给扩展，扩展也会它这个Class返回给系统，结束了！
          * 如果没找到：
            > 引导给扩展返回了一个null，扩展会自己去自己的地盘，去寻找A类
    	  * 如果找到了，那么加载之，然后返回A对应的Class对象给系统，结束了！
    	  * 如果没找到
    	    > 扩展返回一个null给系统了，系统去自己的地盘（应用程序下）加载A类
    	      * 如果找到了，那么加载之，然后返回这个Class，结束了！
    	      * 如果没找到，抛出异常ClassNotFoundException
    
    
    5. 类的解析过程
    
    class MyApp {//被系统加载
    
    main() {
      A a = new A();//也由系统加载
      String s = new String();//也由系统加载！
    }
    
    }
    
    class String {//引导
      private Integer i;//直接引导加载
    }
    
    =====================
    
    6.自定义类加载器
    
    * 继承ClassLoader
    * 重写findClass()
    
    =====================
    
    7. Tomcat的类加载器
      Tomcat提供了两种类加载器！
      * 服务器类加载器：${CATALINA_HOME}\lib，服务器类加载器，它负责加载这个下面的类！
      * 应用类加载器：${CONTEXT_HOME}\WEB-INF\lib、${CONTEXT_HOME}\WEB-INF\classes，应用类加载器，它负责加载这两个路径下的类！
    
      引导
      扩展
      系统
    
      特性：
      服务器类加载器：先自己动手，然后再去委托
      应用类加载器：：先自己动手，然后再去委托

