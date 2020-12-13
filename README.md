数据库表：  
    用户表 user:  
        id,username,password,role,tel,create_at,update_at,last_login_datetime  
            角色表:  
                id,name  
            用户_角色表:  
                id,uid,rid
    机构简介表 （org）：
        id,description（简介），inner_org(改革办内设机构，图片链接)
    机构部门表（department）:
        id,name(部门名称),number(部门人数),weight(排序)
    机构成员表 (member) :
        id,name(姓名),job(职务),department(部门),pic(照片),weight(排序)
    通知公告表 （announcement）：
        id,name(公告名),content(正文),username(发布人),create_at(发布时间),status(状态，0为隐藏，1为显示),weight(排序)
    公告规则表 (announcement_rule):
        id,rule(0代表不显示公告，1代表显示1个月公告，2代表显示2个月公告)
    大屏模块表 (my_module):
        id,name,img
    闪光时刻表 (highlight):
        id,name,img,content
    荣誉展示表 (honor):
        id,name,create_at,img,content,status(0不可见，1可见)
    领导关怀表 (leader):
        id,title,cover_img(封面图片),type(文章类型。0：图文，1：链接，2：视频),content,status(0不可见，1可见)
    改革指数表 (reform):
        id,link
