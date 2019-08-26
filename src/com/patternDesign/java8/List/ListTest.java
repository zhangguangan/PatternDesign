package com.patternDesign.java8.List;

import com.patternDesign.java8.model.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {
    public static void main(String[] args) {
        List<UserInfo> userList = Stream.of(new UserInfo("张三"), new UserInfo("李四")).collect(Collectors.toList());
        System.out.println(userList.size());


        userList.stream().forEach(userInfo -> {
            System.out.println(userInfo.getUserName());
        });

        List<String> userNameList = userList.stream().map(UserInfo::getUserName).collect(Collectors.toList());

        Map<String, List<UserInfo>> userNameMap = userList.stream().collect(Collectors.groupingBy(UserInfo::getUserName));
    }
}
