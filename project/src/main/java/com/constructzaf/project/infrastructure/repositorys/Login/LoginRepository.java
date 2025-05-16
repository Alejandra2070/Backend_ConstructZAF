package com.constructzaf.project.infrastructure.repositorys.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import com.constructzaf.project.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
