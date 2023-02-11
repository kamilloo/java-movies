package org.movies.services;

import jdk.jshell.spi.ExecutionControl;
import org.movies.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    private Map<String, User> users = new HashMap<>(){};

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
        return ;
    }

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public User editUser(User user) throws ExecutionControl.UserException {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return users.containsKey(id);
    }
}
