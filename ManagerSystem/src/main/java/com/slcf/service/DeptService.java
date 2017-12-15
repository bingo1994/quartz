package com.slcf.service;

import java.util.List;

import com.slcf.pojo.DeptBean;

public interface DeptService {

	//添加部门信息
	public int insertDept(DeptBean dept,String name);
	
	//统计部门数量
	public int queryDeptCount();
	
	//查询所有
	public List<DeptBean> queryDeptList(int spage,int epage);
	
	//根据部门id查询
	public DeptBean queryDeptById(int id);
	
	//更新部门信息
	public int upDept(DeptBean dept,String name);
}
