1. 选择依赖
    - jap
    - web
    - lomxxx

2. 配置数据库
    - {projectPath}/src/main/resources/application.properties

3. 创建数据模型
    - 模型类
        - user
        - person
        - student
    - 找工具辅助设计
        - xmind

    - 例如： 
        - student
            - id
            - sid str
                - 学号
                - 数字 ~~Long~~
                - 递增
                - 唯一
                - 不可变
            - name str
            - age unsint
            - gender  int
                - __未知__ 0 女 1 男 2 
                - 20+
            - mark str
4. JpaRepository
    - 完成
    - 两个泛型 对的上号

5. Controller
    - 增 POST
    - 查 GET
        - 单查 根据id  GET  id
        - 多查 查询所有  
        - 分页查询 10 1->n  query > 第几页
    - 删 DELETE
    - 改 PUT

    - 路径如何定义
        - restful
        - 学生资源
            - student
            - /student

6. 实现 业务代码
