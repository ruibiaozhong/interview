## 本项目为JAVA后端机试题



* 采⽤用Spring实现 http://api.haomo-studio.com/org/swagger-ui.html 中的以下⼏几个接⼝：
* 登录接⼝口：http://api.haomo-studio.com/org/swagger-ui.html#!/accountcontroller/login  POST方式
* 创建⽤用户：http://api.haomo-studio.com/org/swagger-ui.html#!/hm-usercontroller/createUser
* 更更新⽤用户：http://api.haomo-studio.com/org/swagger-ui.html#!/hm-usercontroller/getHmUserUsing  PUT方式
* 查询某个⽤用户信息：http://api.haomo-studio.com/org/swagger-ui.html#!/hm-usercontroller/getHmUserUsingGET
* 查询⽤用户列列表：（注意接⼝口参数需要实现X-Auth-
Token/pageNo/pageSize/sortItem/sortOrder/filters/includes/refers，不需要实现relates）：
http://api.haomo-studio.com/org/swagger-ui.html#!/hm-user-controller/getHmUsersUsingGET_1

    查询接⼝口参数说明如下： 
    @param pageNo 整数,如1 起始⻚页⻚页数<br/>
    @param pageSize 整数,如10 每⻚页显示条数 <br/>
    @param sortItem 格式为"id, name" 根据字段排序 (sortItem与sortOrder一一对应) <br/>
    @param sortOrder 格式为"asc, desc" 排序的关 键字 (asc正序,desc倒叙)<br/>
    @param filters JSON字符串串, ⽤用来过滤列列表的数据, 格式为<br/>
    {
    	'table': 表名{
    		'column1': {
    			表中的字段like: '%abc%',
    			模糊查询,
    			包含字符”abc”notLike: ''模糊查询,
    			不不包含字符between: [1,
    			10],
    			取值在[1,
    			10]之间,
    			包含1与10notBetween: [1,
    			10],
    			取值⼩小于1⼤大于10isNull: true,
    			//只能为true判断字段是否为空isNotNull: true,
    			//只能为true判断字段是否不不为空equalTo: "abc",
    			相等于notEqualTo: "abc",
    			不不等于greaterThan: 10,
    			⼤大于greaterThanOrEqualTo: Í10,
    			⼤大于等于lessThan: 10,
    			⼩小于lessThanOrEqualTo: 10,
    			⼩小于等于in: [],
    			包含[]中字段notIn: []不不包含[]中字段
    		}
    	}
    }
    <br>
    @param includes JSON字符串串, ⽤用来将本表的外链字段(table_id类似的字段)指向的外链表相关联
    同时返回两张表的数据, 格式为:
    {
    'include_table1': { //外链表 表名1 （本表所对应的主键表）
    includes: ['include_table11', 'include_table12'] 与主表所对应的外键
    },
    'include_table2': { //外链表 表名2
    includes: ['include_table21', 'include_table22'] 与主表所对应的外键
    }
    }
    @param refers JSON字符串串, ⽤用来将其他表的外链字段指向本表关联，同时返回数据, 格式为:
    {
    'refer_table1': { //主键id所对应的外键表 表名1 （本表所对应的外键表）
    includes: ['include_table11', 'include_table12'] //外键表的外键字段
    },
    'refer_table2': { //主键id所对应的外键表 表名2
    includes: ['include_table21', 'include_table22'] //外键表的外键字段
    }
    }
    
    
    * API地址：http://api.haomo-studio.com/org/swagger-ui.html（编写的代码，必须严格按照我们接⼝口定义
    * 返回的格式返回）
    * 数据库设计⽂文档 （请上传到http://www.dmanywhere.cn/打开预览）
    * 数据库连接⽅方式：haomo-tech.com:3317，⽤用户名：org，密码：org@haomo
    * Redis连接⽅方式：haomo-studio.com:6377
    * RabbitMQ连接⽅方式：http://haomo-studio.com:15673，⽤用户名：rabbitmq，密码：v7NoH2Agw037c5Ye，服务地址：5673
    
    
    2.3 要求
    实现我们要求的接⼝口定义⽂文档中的内容。
    将代码推送到 https://github.com， 并将填写好的excel表发送给HR
    笔试结束，请向HR演示已经完成的接⼝口
    
    
    成功启动项⽬目：1分
    完成登录接⼝口：2分
    完成⼀一般登录功能：0.5分
    完成⾼高并发登录功能：1.5分
    2.3 要求
    2.4 评分标准
    完成创建⽤用户接⼝口：2分
    完成⼀一般创建⽤用户功能：0.5分
    完成⾼高并发创建⽤用户功能：1.5分
    完成更更新⽤用户接⼝口：1分
    完成⼀一般创建⽤用户功能：0.5分
    完成⾼高并发创建⽤用户功能：0.5分
    查询某个⽤用户信息接⼝口：1分
    完成⼀一般查询⽤用户功能：0.5分
    完成⾼高并发查询⽤用户功能：0.5分
    完成查询⽤用户接⼝口：3分
    未实现pageNo/pageSize/sortItem/sortOrder/filters/includes/relates等接⼝口参数过滤，0.5分
    实现pageNo/pageSize：0.5分
    实现sortItem/sortOrder：0.5分
    实现filters：0.5分
    实现includes：0.5分
    实现relates：0.5分
    
    





