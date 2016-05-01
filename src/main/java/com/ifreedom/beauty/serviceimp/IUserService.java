package com.ifreedom.beauty.serviceimp;

import com.ifreedom.beauty.entity.UserEntity;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * Created by eavawu on 4/28/16.
 */
public interface IUserService {
    UserEntity saveUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
    boolean deleteUser(long userId);
    boolean isPhoneRegister(String phone);
    UserEntity getUser(long userId);
    List getUserListByPage(int pageIndex);
    UserEntity findByPhoneAndPassword(String phone, String password);
}
