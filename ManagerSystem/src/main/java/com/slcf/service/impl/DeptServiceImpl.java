package com.slcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slcf.dao.DeptDao;
import com.slcf.pojo.DeptBean;
import com.slcf.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDao deptDao;
	
	/**
	 * 添加部门
	 */
	public int insertDept(DeptBean dept,String name) {
		int j=0;
		int i=deptDao.insertDept(dept);
		if(i>0){
			List<DeptBean> deptList=deptDao.queryDeptList(0,2);
			j=deptDao.insertDeptOpt(deptList.get(0).getDept_id(), name, "添加");
		}
		return j;
	}

	/**
	 * 统计数量
	 */
	public int queryDeptCount() {

		return deptDao.getDeptCount();
	}

	/**
	 * 查询所有
	 */
	public List<DeptBean> queryDeptList(int spage, int epage) {
		
		return deptDao.queryDeptList(spage, epage);
	}

	/**
	 * 根据部门id查找
	 */
	public DeptBean queryDeptById(int id) {
		
		return deptDao.getDeptById(id);
	}

	//更新
	public int upDept(DeptBean dept,String name) {
		int i=deptDao.upDept(dept);
		int j=0;
		if(i>0){
			j=deptDao.insertDeptOpt(dept.getDept_id(), name, "更新");
		}
		return j;
	}

}
