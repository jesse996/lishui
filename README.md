数据库表：
    用户表:
        id,username,password,role,tel,create_at,update_at
    角色表:
        id,name
    用户_角色表:
        id,uid,rid
    文章表:
        id,title,content,author,uid(添加此文章的管理员),create_at,update_at
    操作记录表：
        id,uid,option,datetime
    轮波图表：
        id,picture
        
        
