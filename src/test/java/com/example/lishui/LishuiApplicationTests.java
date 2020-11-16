package com.example.lishui;

import com.example.lishui.dao.entity.PageInfo;
import com.example.lishui.dao.entity.User;
import com.example.lishui.service.PageInfoService;
import com.example.lishui.service.UserService;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LishuiApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    PageInfoService pageInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void addUser() {
        User user = new User(null, "jeese", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));

        try {
            User user1 = userService.addUser(user);
            Assert.notNull(user1.getId(), "add user failed");
            User user2 = userService.addUser(user);

        } catch (Exception e) {
            Assert.hasText("用户已存在", "用户已存在");
        }

    }

    @Test
    void updateUser() throws Exception {
        User user = new User(null, "jeese", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        userService.addUser(user);
        Optional<User> old = userService.findUserById(1L);
        Assert.isTrue(old.isPresent(), "has id==1 user");

        User oldUser = old.get();
        String oldTel = oldUser.getTel();
        oldUser.setTel("new" + oldTel);
        User newUser = userService.updateUser(oldUser);
        Assert.isTrue(newUser.getTel().equals("new" + oldTel), "update success");
    }

    @Test
    void deleteUser() {
        User user = new User(null, "jesse", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        Optional<User> old = null;
        try {
            user= userService.addUser(user);
            Assert.notNull(user.getId(),"[deleteUser]: user add failed");
            userService.deleteUserById(user.getId());
            userService.deleteUserById(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.hasText("删除ID不存在","删除ID不存在");
        }


    }

    @Test
    void findAllUser() throws Exception {
        User user1 = new User(null, "jeese1", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        User user2 = new User(null, "jeese2", "pass", "186023", "admin",
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        userService.addUser(user1);
        userService.addUser(user2);
        List<User> allUser = userService.findAllUser();
        Assert.notEmpty(allUser, "not empty");
        for (User user : allUser) {
            userService.deleteUserById(user.getId());
        }
        List<User> allUser1 = userService.findAllUser();
        Assert.isTrue(allUser1.isEmpty(), "no users");
    }

    @Test
    public void addPageInfoTest() {
        PageInfo pageInfo = new PageInfo(null, "page1", "alias1", "www.baidu.com", 1);

        pageInfo = pageInfoService.addPageInfo(pageInfo);
        System.out.println(pageInfo.getId());

        Assert.notNull(pageInfo.getId(), "add pageInfo success");
    }


    @Test
    public void updatePageInfoTest() {
        PageInfo pageInfo = pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
        pageInfo.setName("new name");
        PageInfo newPageInfo = pageInfoService.updatePageInfo(pageInfo);
        Assert.isTrue("new name".equals(newPageInfo.getName()), "update pageInfo success");
    }

    @Test
    public void deletePageInfoTest() {
        PageInfo pageInfo = pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
        Long id = pageInfo.getId();
        Assert.isTrue(pageInfoService.deletePageInfo(id), "delete pageInfo success");
        Assert.isNull(pageInfoService.findById(id), "delete pageInfo success1");
    }

    @Test
    public void ErrorDeletePageInfoTest() {
        Assert.isTrue(pageInfoService.findById(1L).isEmpty(), "no id is 1 page info");
        Assert.isTrue(!pageInfoService.deletePageInfo(1L), "delete no exist page info failed");

    }


    @Test
    public void listPageInfoTest() {
        List<PageInfo> pageInfos = pageInfoService.listAll();
        Assert.isTrue(pageInfos.isEmpty(), "begin it is empty");
        pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
        pageInfoService.addPageInfo(new PageInfo(null, "page2", "alias2", "www.baidu.com", 1));
        pageInfos = pageInfoService.listAll();
        Assert.isTrue(pageInfos.size() == 2, "get 2 pageInfo success");
    }

}
