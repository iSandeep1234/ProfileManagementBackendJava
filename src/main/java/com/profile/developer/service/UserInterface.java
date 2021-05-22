package com.profile.developer.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profile.developer.bean.User;

@Repository
public interface UserInterface extends JpaRepository<User, Integer> {

	List<User> findByUserNameAndDateOfBirth(String userName, Date dateOfBirth);





}
