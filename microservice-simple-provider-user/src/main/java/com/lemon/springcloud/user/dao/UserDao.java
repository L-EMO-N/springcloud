package com.lemon.springcloud.user.dao;

import com.lemon.springcloud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/2
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {

}
