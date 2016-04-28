package com.ifreedom.beauty.serviceimp;

import com.ifreedom.beauty.entity.UserEntity;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by eavawu on 4/28/16.
 */
public interface IUserService {
    UserEntity saveUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
    boolean deleteUser(long userId);
    UserEntity getUser(long userId);
    List getUserListByPage(int pageIndex);
}
