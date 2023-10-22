package br.com.luishmalafaia.santanderdevweek2023.service.impl;

import br.com.luishmalafaia.santanderdevweek2023.domain.model.User;
import br.com.luishmalafaia.santanderdevweek2023.domain.repository.UserRepository;
import br.com.luishmalafaia.santanderdevweek2023.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(user.getId() != null && userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("This User ID already exists!");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
