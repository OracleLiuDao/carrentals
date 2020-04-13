package com.liudao.sys.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liudao.sys.constast.SysConstast;
import com.liudao.sys.domain.User;
import com.liudao.sys.mapper.RoleMapper;
import com.liudao.sys.mapper.UserMapper;
import com.liudao.sys.service.UserService;
import com.liudao.sys.utils.DataGridView;
import com.liudao.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public User login(UserVo userVo) {
		//明文123456
		//生成密文
		String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
		userVo.setPwd(pwd);
		return userMapper.login(userVo);
	}
	@Override
	public DataGridView queryAllUser(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
		List<User> data = this.userMapper.queryAllUser(userVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addUser(UserVo userVo) {
		// 设置默认密码
		userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
		// 设置用户类型 都是普通用户type=2
		userVo.setType(SysConstast.USER_TYPE_NORMAL);
		this.userMapper.insertSelective(userVo);

	}

	@Override
	public void updateUser(UserVo userVo) {
		this.userMapper.updateByPrimaryKeySelective(userVo);
	}

	@Override
	public void deleteUser(Integer userid) {
		// 删除用户
		this.userMapper.deleteByPrimaryKey(userid);
		// 根据用户id删除sys_role_user里面的数据
		this.roleMapper.deleteRoleUserByUid(userid);
	}

	@Override
	public void deleteBatchUser(Integer[] ids) {
		for (Integer uid : ids) {
			this.deleteUser(uid);
		}
	}

	@Override
	public void resetUserPwd(Integer userid) {
		User user = new User();
		user.setUserid(userid);
		// 设置默认密码
		user.setPwd(DigestUtils.md5DigestAsHex(SysConstast.USER_DEFAULT_PWD.getBytes()));
		//更新
		this.userMapper.updateByPrimaryKeySelective(user);
	}


}
