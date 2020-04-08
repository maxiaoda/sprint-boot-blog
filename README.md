# sprint-boot-blog

这是基于SpringBoot框架的多人博客平台

## 项目结构

- configuration：用于存放 web 安全配置
- controller：处理接收到的 HTTP 请求，对获取的请求参数进行验证和清洗，并将参数传递给业务逻辑 service 层。
- dao：提供访问数据库所需操作的方法
- entity：主要用于存放实体类
- service：主要处理业务逻辑的方法实现，依赖于 dao 层对数据库的操作


## 自动化测试

- 单元测试

    提供对 service 层进行 JUnit 单元测试，
    使用 Mockito mock 相关依赖对象的行为，实现在不涉及依赖关系的情况下对单元代码的测试，
    并配置 travisCI 实现对 GtiHub 项目的自动化测试。

- 自动化测试

    使用开源数据库迁移工具 Flyway 完成自动建表工作。
    配置 TravisCI 对 Github 仓库进行管理，使每次 commit 都自动进行以上测试，保证项目可演进性。
    
## 进展
- 已完成登录模块
- 已完成注册模块
- 已完成登录后保持状态模块
- 已完成注销模块
- 添加了Travis-CI
- 添加了Service的单元测试
- 自动化初始化数据库
- 已完成首页显示博客的模块

## How to build

clone 项目至本地目录：

```
git clone https://github.com/maxiaoda/sprint-boot-blog.git
```

从 Docker 启动 MySQL 数据库：

* [Docker 下载地址](https://www.docker.com/)
* 如果需要持久化数据需要配置 -v 磁盘文件映射

```
docker run --name blog -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
```

使用 IDEA 打开项目，刷新 Maven，再使用开源数据库迁移工具 Flyway 完成自动建表工作：

```
mvn flyway:migrate
```

项目测试：

```
mvn test
```

运行项目：

* Run Application 类

* 访问 [localhost:8080/index.html](localhost:8080/index.html) 就可以开始玩耍啦！