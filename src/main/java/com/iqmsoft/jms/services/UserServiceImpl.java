package com.iqmsoft.jms.services;

import org.springframework.stereotype.Component;

import com.iqmsoft.jms.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Component
public class UserServiceImpl implements UserService {

    private List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>(  );
        User user1 = new User( "Test1", "Test1",30 );
        User user2 = new User("Test2","Test2",25);
        User user3 = new User("Test3","Test3",44);
        userList.add( user1 );
        userList.add( user2 );
        userList.add( user3 );
    }

    @Override
    public User getRandomUser() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, userList.size());
        return userList.get( randomNum );
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
