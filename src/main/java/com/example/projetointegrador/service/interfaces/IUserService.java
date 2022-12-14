package com.example.projetointegrador.service.interfaces;

import com.example.projetointegrador.dto.UserDTO;
import com.example.projetointegrador.exceptions.UserUNotFoundException;
import com.example.projetointegrador.model.UserU;

import java.util.List;

public interface IUserService {
    UserU saveUser(UserU user);

    boolean existsById(Long userId);

    UserU getUserByNameAndPassword(String name, String password);
    List<UserDTO> getUsers();

    UserDTO updateUser(Long userId, UserDTO userDTO) throws UserUNotFoundException;

    Void deleteUser(Long userId) throws UserUNotFoundException;

    UserDTO getUserById(Long userId) throws UserUNotFoundException;
}
