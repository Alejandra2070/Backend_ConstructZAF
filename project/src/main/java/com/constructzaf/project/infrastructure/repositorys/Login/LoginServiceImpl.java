package com.constructzaf.project.infrastructure.repositorys.Login;

import org.springframework.stereotype.Service;

import com.constructzaf.project.application.service.LoginService;
import com.constructzaf.project.domain.Login;

@Service
public class LoginServiceImpl implements LoginService{

    private LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login crearLogin(Login login) {
        return loginRepository.save(login);
    }

}
