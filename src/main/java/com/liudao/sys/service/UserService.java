package com.liudao.sys.service;


import com.liudao.sys.domain.User;
import com.liudao.sys.vo.UserVo;

/**
 * 用户服务接口
 * @author LJH
 *
 */
public interface UserService {

	User login(UserVo userVo);
}
