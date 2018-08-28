# Excel-upload-demo

## 项目介绍

**公司用来上传员工课程数据的项目模块**
>Spring boot, thymleaf
>使用纯注解的开发方式，把数据建表过程也集成在工程当中。
>数据库连接信息
- mysql
- URL：jdbc:mysql://localhost:3306?useSSL=false
- username=root
- password=123456
- driverclass=com.mysql.jdbc.Driver
###前端比较简单
1. 使用了一个外国的websocket框架存储数据。
2. 没有添加CSS部分的内容。
3. 包括了json数据块的查看
4. 集成了ali的druid数据源，用来监控数据库信息
5. 提供下载功能，这里使用了一点easyUI的前端按钮
