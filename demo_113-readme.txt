1 创建一个空的jersey项目，使用以下以下命令创建一个空项目
	mvn archetype:generate -DarchetypeGroupId=org.glassfish.jersey.archetypes -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeVersion=3.1.11
设置groupId/artifactId后创建项目，将项目目录移动到eclipse的默认目录，从eclipse中导入项目
右键项目属性，Project Facets中修改以下内容		
	1 Runtimes中，Apache Tomcat v11.0前打勾	
	2 修改Dynamic Web Module版本为6.1	
	3 修改Java版本为21	
修改pom.xml，添加json支持，uncomment this to get JSON support

	使用jersey的原因
	1 将不同的URL映射到Servlet类的不同方法上去
	2 方法的返回值自动从实体类对象转成json，方法的参数从json转成实体类对象
	
2 导入数据库相关库
在demo_113\src\main\webapp\WEB-INF\目录创建lib目录，放入mysql-connector-j-9.4.0.jar文件
复制数据库连接测试代码到MyResource类的getIt方法中进行测试，一定要添加以下代码否则会报错
Class.forName("com.mysql.cj.jdbc.Driver");	

3 jsp页面table中循环输出数据时url的拼接方式如下
<td><a href="/demo_113/webapi/Practice1302servlet?id=${book.getId()}">${book.getId()}</a></td>

4 数据库访问类中sql拼接时，参数类型即便是字符串，问号的两边也不要加单引号，见下
String sql= "select * from practice_table where id=?";
statement.setString(1, id);

