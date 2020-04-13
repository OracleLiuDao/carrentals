package com.liudao.sys.service.impl;


import com.liudao.sys.domain.User;
import com.liudao.sys.mapper.UserMapper;
import com.liudao.sys.service.UserService;
import com.liudao.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(UserVo userVo) {
		//明文123456
		//生成密文
		String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
		userVo.setPwd(pwd);
		return userMapper.login(userVo);
	}

}
