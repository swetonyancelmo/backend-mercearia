package br.com.mercearia.gerenciador.service;

import br.com.mercearia.gerenciador.controller.dto.RegisterRequestDTO;
import br.com.mercearia.gerenciador.model.User;
import br.com.mercearia.gerenciador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequestDTO registerRequest){
        if(userRepository.findByEmail(registerRequest.email()).isPresent()){
            throw new RuntimeException("Erro: E-mail já está em uso!");
        }

        User newUser = new User();
        newUser.setName(registerRequest.name());
        newUser.setEmail(registerRequest.email());

        newUser.setPassword(passwordEncoder.encode(registerRequest.password()));

        return userRepository.save(newUser);
    }
}
