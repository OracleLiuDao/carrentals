package com.liudao.sys.service;


import com.liudao.sys.domain.Menu;
import com.liudao.sys.utils.DataGridView;
import com.liudao.sys.vo.MenuVo;

import java.util.List;

/**
 * 菜单管理的服务接口
 * @author LJH
 *
 */
public interface MenuService {

	/**
	 * 查询所有菜单返回
	 * List<Menu>
	 */
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	/**
	 * 根据用户id查询用户的可用菜单
	 */
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId);

	/**
	 * 查询所有菜单
	 * @param menuVo
	 * @return
	 */
	public DataGridView queryAllMenu(MenuVo menuVo);
	
	/**
	 * 添加菜单
	 * @param menuVo
	 */
	public void addMenu(MenuVo menuVo);
}
