package com.liudao.sys.controller;


import com.liudao.sys.service.UserService;
import com.liudao.sys.utils.DataGridView;
import com.liudao.sys.utils.ResultObj;
import com.liudao.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 * 
 * @author LJH
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 加载用户列表返回DataGridView
	 */
	@RequestMapping("loadAllUser")
	public DataGridView loadAllUser(UserVo userVo) {
		return this.userService.queryAllUser(userVo);
	}
	
	
	/**
	 * 添加用户
	 */
	@RequestMapping("addUser")
	public ResultObj addUser(UserVo userVo) {
		try {
			this.userService.addUser(userVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping("updateUser")
	public ResultObj updateUser(UserVo userVo) {
		try {
			this.userService.updateUser(userVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	
	/**
	 * 删除用户
	 */
	@RequestMapping("deleteUser")
	public ResultObj deleteUser(UserVo userVo) {
		try {
			this.userService.deleteUser(userVo.getUserid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 批量删除用户
	 */
	@RequestMapping("deleteBatchUser")
	public ResultObj deleteBatchUser(UserVo userVo) {
		try {
			this.userService.deleteBatchUser(userVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	/**
	 * 重置用户密码
	 */
	@RequestMapping("resetUserPwd")
	public ResultObj resetUserPwd(UserVo userVo) {
		try {
			this.userService.resetUserPwd(userVo.getUserid());
			return ResultObj.RESET_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.RESET_ERROR;
		}
	}
	
}
