package com.ifreedom.beauty.service;

import com.ifreedom.beauty.constants.LogConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.repository.UserRepository;
import com.ifreedom.beauty.serviceimp.IUserService;
import com.ifreedom.beauty.util.LogUtil;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eavawu on 4/28/16.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity) {
        if (userEntity==null){
            LogUtil.error(LogConstants.DB,"save user is null");
            return null;
        }
        if (userEntity.getName()==null){
            LogUtil.error(LogConstants.DB,"save user userName is null");
            return null;
        }
        UserEntity save = userRepository.save(userEntity);
        return save;
    }


    public boolean updateUser(UserEntity userEntity) {
        if (userEntity==null){
            LogUtil.error(LogConstants.DB,"update user param is null");
            return false;
        }


        return false;
    }


    @Override
    public boolean deleteUser(long userId) {
        return false;
    }

    @Override
    public UserEntity getUser(long userId) {
        return null;
    }


    @Override
    public List getUserListByPage(int pageIndex) {
        return null;
    }
}
