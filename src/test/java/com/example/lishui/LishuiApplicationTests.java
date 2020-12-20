package com.example.lishui;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LishuiApplicationTests {
//    @Autowired
//    UserService userService;
//    @Autowired
//    PageInfoService pageInfoService;
//    @Autowired
//    PageInfoRepository pageInfoRepository;
    @Test
    void contextLoads() {
//        Duration.between(LocalTime.now(),LocalTime.now());


    }

//    @Test
//    void addUser() {
//        User user = new User(null, "jeese", "pass", "186023", "admin",
//                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
//
//        try {
//            User user1 = userService.addUser(user);
//            Assert.notNull(user1.getId(), "add user failed");
//            User user2 = userService.addUser(user);
//
//        } catch (Exception e) {
//            Assert.hasText("用户已存在", "用户已存在");
//        }
//
//    }
//
//    @Test
//    void updateUser() {
//        User user = new User(null, "jesse", "pass", "186023", "admin",
//                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
//        try {
//            userService.addUser(user);
//            Optional<User> old = userService.findUserByUsername("jesse");
//            Assert.isTrue(old.isPresent(), "don't has user name jesse");
//            User oldUser = old.get();
//            String oldTel = oldUser.getTel();
//            oldUser.setTel("new" + oldTel);
//            User newUser = userService.updateUser(oldUser);
//            Assert.isTrue(newUser.getTel().equals("new" + oldTel), "update success");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void deleteUser() {
//        User user = new User(null, "jesse", "pass", "186023", "admin",
//                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
//        Optional<User> old = null;
//        try {
//            user = userService.addUser(user);
//            Assert.notNull(user.getId(), "[deleteUser]: user add failed");
//            userService.deleteUserById(user.getId());
//            userService.deleteUserById(user.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.hasText(e.getMessage(), "删除不存在 不出现异常");
//        }
//
//
//    }
//
//    @Test
//    void findAllUser() throws Exception {
//        User user1 = new User(null, "jeese1", "pass", "186023", "admin",
//                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
//        User user2 = new User(null, "jeese2", "pass", "186023", "admin",
//                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
//        userService.addUser(user1);
//        userService.addUser(user2);
//        List<User> allUser = userService.findAllUser();
//        Assert.notEmpty(allUser, "not empty");
//        for (User user : allUser) {
//            userService.deleteUserById(user.getId());
//        }
//        List<User> allUser1 = userService.findAllUser();
//        Assert.isTrue(allUser1.isEmpty(), "no users");
//    }
//
//    @Test
//    public void addPageInfoTest() {
//        PageInfo pageInfo = new PageInfo(null, "page1", "alias1", "www.baidu.com", 1);
//
//        pageInfo = pageInfoService.addPageInfo(pageInfo);
//        System.out.println(pageInfo.getId());
//
//        Assert.notNull(pageInfo.getId(), "add pageInfo success");
//    }
//
//
//    @Test
//    public void updatePageInfoTest() {
//        PageInfo pageInfo = pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
//        pageInfo.setName("new name");
//        PageInfo newPageInfo = pageInfoService.updatePageInfo(pageInfo);
//        Assert.isTrue("new name".equals(newPageInfo.getName()), "update pageInfo success");
//    }
//
//    @Test
//    public void deletePageInfoTest() {
//        PageInfo pageInfo = pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
//        Long id = pageInfo.getId();
//        pageInfoService.deletePageInfo(id);
//        Assert.isTrue(pageInfoService.findById(id).isEmpty(), "delete pageInfo failed");
//    }
//
//    @Test
//    public void ErrorDeletePageInfoTest() {
//        Assert.isTrue(pageInfoService.findById(1L).isEmpty(), "no id is 1 page info");
//        try {
//            pageInfoService.deletePageInfo(1L);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            Assert.hasText(e.getMessage(), "删除不存在的页面不出现异常");
//        }
//
//    }
//
//
//    @Test
//    public void listPageInfoTest() {
//        pageInfoRepository.deleteAll();
//        List<PageInfo> pageInfos = pageInfoService.listAll();
//        Assert.isTrue(pageInfos.isEmpty(), "begin it is not empty");
//        pageInfoService.addPageInfo(new PageInfo(null, "page1", "alias1", "www.baidu.com", 1));
//        pageInfoService.addPageInfo(new PageInfo(null, "page2", "alias2", "www.baidu.com", 1));
//        pageInfos = pageInfoService.listAll();
//        Assert.isTrue(pageInfos.size() == 2, "get 2 pageInfo success");
//    }

}
