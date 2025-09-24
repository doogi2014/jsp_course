spring mysql				
https://spring.io/guides/gs/accessing-data-mysql				
该项目对docker有依赖，需要安装docker			
				
安装docker			
https://docs.docker.com/desktop/setup/install/windows-install/			
				
1 从eclipse导入项目时应该从gs-accessing-data-mysql-main的下面一层的目录开始				
	C:\Users\doogi\eclipse-workspace\gs-accessing-data-mysql-main\complete			
2 安装java jdk 21，确认环境变量会自动设置好				
3 安装docker并更新，启动docker服务，确认正常运行				
4 不要修改gs-accessing-data-mysql-main\complete\compose.yml文件中的内容，则否启动服务时报错				
	这个项目默认就得连接docker中的mysql，不支持修改，又待进一步确认			
