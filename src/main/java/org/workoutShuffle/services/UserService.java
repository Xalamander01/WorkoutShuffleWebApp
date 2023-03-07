package org.workoutShuffle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workoutShuffle.entity.UserEntity;
import org.workoutShuffle.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers() {
        List<UserEntity> userList = new ArrayList<>();
        for (UserEntity user : userRepository.findAll()) {
            userList.add(user);
        }
        return userList;
    }

    /* a login system will be implemented eventually and it will keep track of user preferences
       and suggest variations to break habits
     */

    public UserEntity getUser(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public void addUser(UserEntity userToAdd) {
        userRepository.save(userToAdd);
    }

    public void updateUser(UserEntity userToUpdate) {
        userRepository.save(userToUpdate);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
