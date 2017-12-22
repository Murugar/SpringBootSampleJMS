package com.iqmsoft.jms.services;

import java.util.List;

import com.iqmsoft.jms.domain.User;

/**
 * Get a random User
 * User: Cliff
 */
public interface UserService {

    User getRandomUser();

    List<User> getAllUsers();
}
