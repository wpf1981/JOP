package com.wpf.jop1.repository;

import com.wpf.jop1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

/**
 * @outhor wpf
 * @date 2018/12/24 - 10:56
 */
public interface UserRepository extends JpaRepository<User,String> {

}
