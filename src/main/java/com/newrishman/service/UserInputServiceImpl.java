package com.newrishman.service;

import com.newrishman.domain.UserInput;
import com.newrishman.repository.UserInputRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInputServiceImpl implements UserInputService{
    private UserInputRepository repository;

    @Override
    public List<UserInput> getAllUserInput() {
        return repository.findAll();
    }
}
