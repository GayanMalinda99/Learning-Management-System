package com.example.backend.controller.login;

import com.example.backend.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<AppUser,Long> {

        AppUser findByUserEmail(String userEmail);
}
