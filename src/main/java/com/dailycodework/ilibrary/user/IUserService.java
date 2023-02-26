package com.dailycodework.ilibrary.user;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
   User getUser(String email);
    User update(User user);
}
