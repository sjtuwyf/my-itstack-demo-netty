package org.itstack.demo.netty.service;

import org.itstack.demo.netty.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public interface UserService {

    void save(User user);

    void deleteById(String id);

    User queryUserById(String id);

    Iterable<User> queryAll();

    Page<User> findByName(String name, PageRequest request);

}
