package com.ifreedom.beauty.iservice;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
public interface IFollowService {
     int isFollow(long  userId,long beFollowId);
     boolean addFollow(long userId,long beFollowId);
     boolean deleteFollow(long userId,long beFollowId);
}
