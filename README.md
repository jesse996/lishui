数据库表：
    用户表 user:
        id,username,password,role,tel,create_at,update_at
            角色表:
                id,name
            用户_角色表:
                id,uid,rid
    文章表:
        id,title,content,author,uid(添加此文章的管理员),create_at,update_at,status(可见范围)
    操作记录表 option：
        id,uid,option,datetime
    轮波图表 slide：
        id,link
    页面管理表 page_info：
        id,name,alias,link,order
        
        
