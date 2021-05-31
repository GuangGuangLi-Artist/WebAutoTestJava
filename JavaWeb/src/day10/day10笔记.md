### http请求
    请求响应对象
    
    request和response
      * 当服务器接收到请求后，服务器会创建request和response对象，把请求数据封装到request对象中；
      * 然后调用Servlet的service()方法时把这两个对象传递给service()方法；
      * 在service()方法中可以通过request对象获取请求数据，可以使用response对象向客户端完成响应；
      
      * 每次请求服务器都会创建新的request和response对象，即每个请求有自己独自的request和response对象。
    
    ==============================
    ==============================
    ==============================
    
    response对象
    
    1. response简介
      response是响应对象，用来在Servlet的service()方法中向客户端响应数据。
      response的功能如下：
      * 设置响应头
      * 发送状态码
      * 设置响应正文
      * 重定向
    
    2. response响应正文
      * ServletOutputStream getOutputStream()：用来向客户端响应字节数据；
      * PrintWriter getWriter()：用来向客户端响应字符数据；
    
      response.getWriter().print("你好");//向客户端响应字符数据
      byte[] bytes = ...;
      response.getOutputStream().write(bytes);//向客户端响应字节数据
    
    3. response字符编码
      * Tomcat响应数据默认使用ISO-8859-1
      * 通常浏览器默认使用GBK编码
      * response.setCharacterEncoding("utf-8");//设置response.getWriter()的字符编码
    
      1)
      response.getWriter().print("大家好");
      因为Tomcat默认使用的是ISO-8859-1编码，不支持中文。所以一定编码！
    
      2)
      response.setCharacterEncoding("utf-8");
      response.getWriter().print("大家好");
      因为已经设置了字符流编码为utf-8，所以响应给客户端的数据为utf-8编码！
      但因为浏览器默认使用的是gbk来解析响应数据，所以乱码！如果浏览器使用utf-8编码，那么就不会乱码了。
    
      3)
      response.setCharacterEncoding("gbk");
      response.getWriter().print("大家好");
      因为设置了字符流编码为gbk，所以响应给客户端的数据为gbk编码！
      因为浏览器默认使用gbk来解析数据，所以不会出现乱码！如果浏览器使用utf-8编码，那么就会出现乱码！
    
      4)
      response.setContentType("text/html;charset=utf-8");
      response.getWriter().print("大家好");
      setContentType()方法有两个作用：
      * 设置字符流编码。等同与调用了response.setCharacterEncoding("utf-8")；
      * 设置Content-type响应头，即通知浏览器响应数据的编码为utf-8。
      因为设置字符流的编码为utf-8，所以响应给客户端数据为utf-8编码
      因为设置了Content-type头为utf-8，所以浏览器会使用utf-8来解析响应数据
      没有乱码！
    
      5)
      response.setContentType("text/html;charset=gbk");
      response.getWriter().print("大家好");
      * 设置了字符流为gbk，所以响应给客户端的数据为gbk
      * 设置了Content-type头为gbk，所以通知浏览器响应数据为gbk编码
      没有乱码！
    
      6)
      response.setHeader("Content-type", "text/html;charset=utf-8")
      等同于
      repsonse.setContentType("text/html;charset=utf-8")
    
      7)
      response.getOutputStream().write("大家好".getBytes("gbk"));
      响应的数据是gbk编码
      客户端浏览器默认使用gbk编码
      所以没有乱码
    
    ======================
    
    4. response字符流缓冲区
      response字符流缓冲区大小为8KB，当向字符流中写入数据后，数据可能只在缓冲区中，而没有发送到浏览器。
      可以调用response.flushBuffer()或response.getWriter().flush()方法刷新缓冲区，把数据发送到浏览器。
    
    ======================
    
    5. 设置响应头
    
      response.setHeader("Content-type", "text/html;charset=utf-8");
      等同与
      response.setContentType("text/html;charset=utf-8");
    
      response.setHeader("Refresh", "5; URL=http://www.itcast.cn");
    
    ======================
    
    6. 指定状态码
    
    response.setStatus(200)：设置状态码为200
    response.sendError(404, “您要查找的资源不存在”)：设置状态码为404
    repsonse.sendError(500, “服务器出氏了”)：设置状态码为500
    
    在调用sendError()方法时，不只是设置了状态码，而且还会给浏览器一个显示错误的页面。
    
    ======================
    
    7. 重定向
    
    response.sendStatus(302);
    repsonse.setHeader("Location", "http://www.baidu.com");
    
    快捷的方法重定向：
    
    response.sendRedirect("http://www.baidu.com");
    
    * 重定向是两次请求
    * 重定向不局限与当前应用，也可以是其他应用，例如重定向到百度
    * 重定向响应码为302，而且必须有Location响应头
    * 重定向与response响应流同时使用。
    
    ======================
    ======================
    ======================
    
    request
    
    1. request功能介绍
     * 获取请求头
     * 获取请求参数
     * Servlet三大域对象之一
     * 请求包含和请求转发
    
    2. request域方法
     * void setAttribute(String name, Object value)：添加或替换request域属性
     * Object getAttribute(String name)：获取request域指定名称的域属性
     * void removeAttribute(String name)：移除request域指定名称的域属性
     * Enumeration getAttributeNames()：获取所有request域的属性名称
    
    3. request获取请求头
     * String getHeader(String name)：获取指定名称的请求头
     * int getIntHeader(String name)：获取指定名称的请求头，把值转换成int类型。
     * Enumeration getHeaderNames()：获取所有请求头名称
    
    4. request请求数据相关其他方法
     重点：
     * String getMethod()：获取请求方式
     * String getContextPath()：获取上下文路径，即“/” + 应用名称，例如：/day05_1 非常常用的方法
     * void setCharacterEncoding(String)：设置请求体的编码
     * String getRemoteAddr()：获取客户端IP地址
    
     非重点：
     * int getContentLength()：获取请求体字节数
     * Locale getLocale()：获取请求Locale，例如zh_CN表示中文，中国
     * String getCharacterEncoding()：获取请求体编码，在没有调用setCharacterEncoding()之前该方法返回null
     * String getQueryString()：获取参数列表，例如：username=zhangSan&password=123
     * String getRequestURI()：返回请求URI路径，从应用名称开始，到参数之前这一段，例如：/day05_1/AServlet
     * StringBuffer getRequestURL()：整个请求URL，不包含参数部分
     * String getServletPath()：返回Servlet路径，从应用名称后开始，到参数之前这一段，不包含应用名称。
     * String getServerName()：返回主机名，例如：localhost
     * int getServerPort()：返回服务器端口号，例如：8080
    
    5. 请求参数
     获取请求参数，即获取超链接上的参数和表单中的参数
     * String getParameter(String name)：获取指定名称的参数，如果存在同名参数，那么该方法只获取第一个参数值
     * String[] getParameterValues(String name)：获取指定名称的参数，因为同名参数的存在，所以返回值为String[]
     * Enumeration getParameterNames():获取所有参数名称
     * Map getParameterMap()：获取所有参数，封装到Map中，key为参数名称，value为参数值。
    
    6. 请求包含和请求转发
     * 请求包含和请求转发都是在一个请求中，访问两个Servlet。
     * 请求包含和请求转发都是有一个Servlet去调用执行另一个Servlet
     * 请求包含和请求转发都可以共享request中的数据，因为都是一个请求。
     
     * 从AServlet请求转发到BServlet
       > 在AServlet中可以设置响应头
       > 在AServlet中不能使用响应流输出
     
     如果在AServlet中执行了响应操作，那么有两种可能：
     * 如果在AServlet中响应的数据导致response提交，那么在转发时抛出异常；
     * 如果在AServlet中响应的数据没有导致response提交，那么response中的数据会被清空。
    
     * 从AServlet请求包含BServlet
       > 在AServlet可以设置响应头
       > 在AServlet可以使用响应流输出
    
     * 请求转发和请求包含都要使用RequestDispatcher对象：RequestDispatcher rd = request.getRequestDispatcher("/BServlet");
     * 请求转发执行RequestDispatcher的forward()方法：rd.forward(request,response);
     * 请求包含执行RequestDispatcher的include()方法：rd.include(request,response);
     * 请求转发和请求包含的路径都是服务器端路径，相对当前应用
    
    
    7. 请求转发与重定向
     * 请求转发是一个请求，而重定向是两个请求
     * 请求转发，是使用RequestDispatcher来完成，重定向使用response对象来完成
     * 请求转发的路径都是服务器端路径，而重定向是客户端路径，需要给出应用名称
     * 请求转发在浏览器地址栏中的地址是第一个Servlet的路径，而重定向在地址栏中的地址是第二个请求的Servlet的路径
     * 请求转发中的两个Servlet是可以共享request数据的，而重定向因为是两个请求，所以不能共享request数据
     * 请求转发只能转发到本应用的其他Servlet，而重定向可以重定向到其他应用中。
    
    8. request.getParameter()和request.getAttribute()
     * getParameter()是获取客户端参数，它是从客户端传递给服务器的数据。
     * getAttribute()是获取服务器端自己设置的数据，而不是客户端的数据。
     * request没有setParameter()方法，不能自己设置参数，参数都由客户端传递
     * request有setAttribute()方法，在getAttribute()之前，需要先setAttribute()才能获取到。
     * getAttribute()和setAttribute()是用来在请求转发和请求包含中的多个Servlet中共享数据。
    
    ======================
    ======================
    ======================
    
    路径
    
    1. 客户端路径和服务器端路径
     * 客户端路径需要给出应用名称，例如：/day05_1/AServlet
     * 服务器端路径无需给出应用名称，例如：/AServlet
    
    2. 客户端路径
     1). 页面中都是客户端路径：
     * 超链接的href
     * 表单的action
     * <img>的src
     2). 重定向也是客户端路径：response.sendRedirect("/day05_1/BServlet");
    
    3. 服务器端路径
     * <url-pattern>
     * 请求转发和请求包含
     * ServletContext获取资源等
    
    ======================
    ======================
    ======================
    
    乱码
    
    1. 请求编码
     * 客户端发送的数据编码：由浏览器来决定：
      1). 如果是在地址栏中直接给出url，那么一般都是默认为GBK，但这个可能不太大。
      2). 如果是通过页面上的表单或超链接发出请求，那么由当前页面的编码来决定发送的参数的编码。
    
     * 无论浏览器发送过来的是什么编码的数据，Tomcat都默认使用ISO-8859-1来解码
      1). POST：可以使用request.setCharacterEncoding()方法来设置请求体数据的编码，因为POST请求参数在请求体中，所以是可以设置编码的。在使用request.getParameter()方法获取参数之前，先使用request.setCharacterEncoding()方法来设置编码即可。
      2). GET：没有方法可以设置它，因为参数在url中。所以使用request.getParameter()获取到的数据一定是错误的使用了iso-8859-1解码的。可以再使用iso-8859-1把字符串转回到byte[]，再重新使用正确的编码来解码即可。
      String s = request.getParameter("s");//使用iso-8859-1错误的解码了
      byte[] bytes = s.getBytes("iso-8859-1");//退回错误的解码，让字符串通过iso-8859-1返回到字节数据，即还原字节数据
      s = new String(bytes, "utf-8");//重新使用正确的utf-8来解码。
      
      
     
     =============================================================================
     内容：
     * response
     * request
     * 编码
     * 路径
     
     ------------------
     
     服务器处理请求的流程：
       服务器每次收到请求时，都会为这个请求开辟一个新的线程。
       服务器会把客户端的请求数据封装到request对象中，request就是请求数据的载体！（袋子）
       服务器还会创建response对象，这个对象与客户端连接在一起，它可以用来向客户端发送响应。（手机）
     
     ------------------
     
     
     response：其类型为HttpServletResponse
       ServletResponse-->与协议无关的类型
       HttpServletResponse-->与http协议相关的类型
     
     　　回忆一下http协议！http协议中响应的内容包含哪些东西呢？
     　　* 状态码：200表示成功、302表示重定向、404表示客户端错（访问的资源不存在）、500表示服务器端错
     　　　　> sendError(int sc) --> 发送错误状态码，例如404、500
     　　　　> sendError(int sc, String msg) --> 也是发送错误状态码，还可以带一个错误信息！
     　　　　> setStatus(int sc) --> 发送成功的状态码，可以用来发送302
     　　　　案例：
     　　　　> 发送404
     　　* 响应头：Content-Type、Refresh、Location等等
     　　　　头就是一个键值对！可能会存在一个头（一个名称，一个值），也可能会存在一个头（一个名称，多个值！）
     　　　　> *****setHeader(String name, String value)：适用于单值的响应头，例如：response.setHeader("aaa", "AAA");
     　　　　> addHeader(String name, String value)：适用于多值的响应头
     		response.addHeader("aaa", "A");
     		response.addHeader("aaa", "AA");
     		response.addHeader("aaa", "AAA");
     　　　　> setIntHeader(String name, int value)：适用于单值的int类型的响应头
     	`	response.setIntHeader("Content-Length", 888);
     　　　　> addIntHeader(String name, int value)：适用于多值的int类型的响应头
     　　　　> setDateHeader(String name, long value)：适用于单值的毫秒类型的响应头
     		response.setDateHeader("expires", 1000 * 60 * 60 * 24);
     　　　　> addDateHeader(String name, long value)：适用于多值的毫秒类型的响应头
     　　　　案例：
     　　　　> 发送302，设置Location头，完成重定向！
     　　　　> 定时刷新：设置Refresh头，你可以把它理解成，定时重定向！
     　　　　> 禁用浏览器缓存：Cache-Control、pragma、expires
     　　　　> <meta>标签可以代替响应头：<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     　　* 响应体：通常是html、也可以是图片！
     　　　　> response的两个流：
     　　　　　　<> ServletOutputStream，用来向客户端发送字节数据。ServletOutputStream out = resopnse.getOutputStream();
     　　　　　　<> PrintWriter，用来向客户端发送字符数据！需要设置编码。PrintWriter writer = response.getWriter();
     　　　　　　<> 两个流不能同时使用！
     　　　　案例：
     　　　　> 使用PrintWriter发送字符数据
     　　　　> 使用ServletOutputStream发送字节数据（图片）
     　　* 重定向：设置302，设置Location！其中变化的只有Location，所以java提供了一个快捷方法，完成重定向！
     　　　> sendRedirect(String location)方法
     
     ------------------
     
     request --> 封装了客户端所有的请求数据！
     请求行
     请求头
     空行
     请求体（GET没体）
     
     　　回忆一下http协议！请求协议中的数据都可以通过request对象来获取！
     　　* 获取常用信息
     　　　　> 获取客户端IP，案例：封IP。request.getRemoteAddr()
     　　　　> 请求方式，request.getMethod()，可能是POST也可能是GET
     　　* 获取HTTP请求头
     　　　　> *****String getHeader(String name)，适用于单值头
     　　　　> int getIntHeader(String name)，适用于单值int类型的请求头
     　　　　> long getDateHeader(String name)，适用于单值毫秒类型的请求头
     　　　　> Enumeration<String> getHeaders(String name)，适用于多值请求头
     
     　　　案例：
     　　　　> 通过User-Agent识别用户浏览器类型
     　　　　> 防盗链：如果请求不是通过本站的超链接发出的，发送错误状态码404。Referer这个请求头，表示请求的来源！
     　　* 获取请求URL
     	http://localhost:8080/day10_2/AServlet?username=xxx&password=yyy
     　　　　> String getScheme()：获取协议，http
     　　　　> String getServerName()：获取服务器名，localhost
     　　　　> String getServerPort()：获取服务器端口，8080
     　　　　> *****String getContextPath()：获取项目名，/day10_2
     　　　　> String getServletPath()：获取Servlet路径，/AServlet
     　　　　> String getQueryString()：获取参数部分，即问号后面的部分。username=xxx&password=yyy
     　　　　> String getRequestURI()：获取请求URI，等于项目名+Servlet路径。/day10_2/AServlet
     　　　　> String getRequestURL()：获取请求URL，等于不包含参数的整个请求路径。http://localhost:8080/day10_2/AServlet
     
     　　* 获取请求参数：请求参数是由客户端发送给服务器的！有可能是在请求体中（POST），也可能是在URL之后（GET）
     　　　　请求参数：有一个参数一个值的，还有一个参数多个值！
     　　　　> *****String getParameter(String name)：获取指定名称的请求参数值，适用于单值请求参数
     　　　　> String[] getParameterValues(String name)：获取指定名称的请求参数值，适用于多值请求参数
     　　　　> Enumeration<String> getParameterNames()：获取所有请求参数名称
     　　　　> *****Map<String,String[]> getParameterMap()：获取所有请求参数，其中key为参数名，value为参数值。
     　　　　案例：超链接参数
     　　　　案例：表单数据
     
     　　* 请求转发和请求包含
     　　　　RequestDispatcher rd = request.getRequestDispatcher("/MyServlet");  使用request获取RequestDispatcher对象，方法的参数是被转发或包含的Servlet的Servlet路径
     　　　　请求转发：*****rd.forward(request,response);
     　　　　请求包含：rd.include(request,response);
     
     　　　　有时一个请求需要多个Servlet协作才能完成，所以需要在一个Servlet跳到另一个Servlet！
     　　　　> 一个请求跨多个Servlet，需要使用转发和包含。
     　　　　> 请求转发：由下一个Servlet完成响应体！当前Servlet可以设置响应头！（留头不留体）
     　　　　> 请求包含：由两个Servlet共同未完成响应体！（都留）
     　　　　> 无论是请求转发还是请求包含，都在一个请求范围内！使用同一个request和response！
     　　* request域
     　　　　Servlet中三大域对象：request、session、application，都有如下三个方法：
     　　　　> void setAttribute(String name, Object value)
     　　　　> Object getAttribute(String name)
     	> void removeAttribute(String name);
     　　　　> 同一请求范围内使用request.setAttribute()、request.getAttribute()来传值！前一个Servlet调用setAttribute()保存值，后一个Servlet调用getAttribute()获取值。
     
     　　* 请求转发和重定向的区别
     　　　　> 请求转发是一个请求一次响应，而重定向是两次请求两次响应
     　　　　> 请求转发地址栏不变化，而重定向会显示后一个请求的地址
     　　　　> 请求转发只能转发到本项目其他Servlet，而重定向不只能重定向到本项目的其他Servlet，还能定向到其他项目
     　　　　> 请求转发是服务器端行为，只需给出转发的Servlet路径，而重定向需要给出requestURI，即包含项目名！
     　　　　> 请求转发和重定向效率是转发高！因为是一个请求！
     　　　　　　<> 需要地址栏发生变化，那么必须使用重定向！
     　　　　　　<> 需要在下一个Servlet中获取request域中的数据，必须要使用转发！
     　　
     ------------------
     
     编码
     　　常见字符编码：iso-8859-1(不支持中文)、gb2312、gbk、gb18030(系统默认编码，中国的国标码)、utf-8(万国码，支持全世界的编码，所以我们使用这个)
     
     1. 响应编码
     　　* 当使用response.getWriter()来向客户端发送字符数据时，如果在之前没有设置编码，那么默认使用iso，因为iso不支持中文，一定乱码
     　　* 在使用response.getWriter()之前可以使用response.setCharaceterEncoding()来设置字符流的编码为gbk或utf-8，当然我们通常会选择utf-8。这样使用response.getWriter()发送的字符就是使用utf-8编码的。但还是会出现乱码！因为浏览器并不知道服务器发送过来的是什么编码的数据！这时浏览器会使用gbk来解码，所以乱码！
     　　* 在使用response.getWriter()之前可以使用response.setHeader("Content-type","text/html;charset=utf-8")来设置响应头，通知浏览器服务器这边使用的是utf-8编码，而且在调用setHeader()后，还会自动执行setCharacterEncding()方法。这样浏览器会使用utf-8解码，所以就不会乱码了！
     　　* setHeader("Content-Type", "text/html;charset=utf-8")的快捷方法是：setContentType("text/html;charset=utf-8)。
     2. 请求编码
     　　* 客户端发送给服务器的请求参数是什么编码：
     　　　　客户端首先要打开一个页面，然后在页面中提交表单或点击超链接！在请求这个页面时，服务器响应的编码是什么，那么客户端发送请求时的编码就是什么。
     　　* 服务器端默认使用什么编码来解码参数：
     　　　　服务器端默认使用ISO-8859-1来解码！所以这一定会出现乱码的！因为iso不支持中文！
     　　* 请求编码处理分为两种：GET和POST：GET请求参数不在请求体中，而POST请求参数在请求体中，所以它们的处理方式是不同的！
     　　* GET请求编码处理：
     　　　　> String username = new String(request.getParameter("iso-8859-1"), "utf-8");
     　　　　> 在server.xml中配置URIEncoding=utf-8
     　　* POST请求编码处理：
     　　　　> String username = new String(request.getParameter("iso-8859-1"), "utf-8");
     　　　　> 在获取参数之前调用request.setCharacterEncoding("utf-8");
     
     3. URL编码
     　　表单的类型：Content-Type: application/x-www-form-urlencoded，就是把中文转换成%后面跟随两位的16进制。
     　　为什么要用它：在客户端和服务器之间传递中文时需要把它转换成网络适合的方式。
     
     　　* 它不是字符编码！
     　　* 它是用来在客户端与服务器之间传递参数用的一种方式！
     　　* URL编码需要先指定一种字符编码，把字符串解码后，得到byte[]，然后把小于0的字节+256，再转换成16进制。前面再添加一个%。
     　　* POST请求默认就使用URL编码！tomcat会自动使用URL解码！
     　　* URL编码：String username = URLEncoder.encode(username, "utf-8");
     　　* URL解码：String username = URLDecoder.decode(username, "utf-8");
     
     　　最后我们需要把链接中的中文参数，使用url来编码！今天不行，因为html中不能给出java代码，但后面学了jsp就可以了。
     
     ------------------
     
     路径
     　　* web.xml中<url-pattern>路径，（叫它Servlet路径！）
     　　　　> 要么以“*”开关，要么为“/”开头
     　　* 转发和包含路径
     　　　　> *****以“/”开头：相对当前项目路径，例如：http://localhost:8080/项目名/　request.getRequestdispacher("/BServlet").for...();
     　　　　> 不以“/”开头：相对当前Servlet路径。 request.getRequestdispacher("/BServlet").for...();，假如当前Servlet是：http://localhost:8080/项目名/servlet/AServlet，　就是http://localhost:8080/项目名/servlet/BServlet
     　　* 重定向路径（客户端路径）
     　　　　> 以“/”开头：相对当前主机，例如：http://localhost:8080/，　所以需要自己手动添加项目名，例如；response.sendRedirect("/day10_1/Bservlet");
     　　* 页面中超链接和表单路径
     　　　　> 与重定向相同，都是客户端路径！需要添加项目名
     	> <form action="/day10_1/AServlet">
     	> <a href="/day10_/AServlet">
     	> <a href="AServlet">，如果不以“/”开头，那么相对当前页面所在路径。如果是http://localhost:8080/day10_1/html/form.html。　即：http://localhost:8080/day10_1/html/ASevlet
     	> *****建立使用以“/”开头的路径，即绝对路径！
     　　* ServletContext获取资源路径
     　　　　> 相对当前项目目录，即当然index.jsp所在目录
     　　* ClassLoader获取资源路径
     　　　　> 相对classes目录
     　　* Class获取资源路径
     　　　　> 以“/”开头相对classes目录
     　　　　> 不以“/”开头相对当前.class文件所在目录。
