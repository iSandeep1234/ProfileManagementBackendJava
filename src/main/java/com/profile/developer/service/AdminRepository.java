package com.profile.developer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profile.developer.bean.Admin;
import com.profile.developer.bean.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByUserName(String userName);

	Admin findByUserNameAndUserPassword(String adminName, String adminPass);

}
