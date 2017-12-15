package com.slcf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slcf.pojo.DeptBean;
import com.slcf.pojo.UserBean;
import com.slcf.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Resource
	DeptService deptService;
	
	@RequestMapping("goDept.action")
	public String goDeptPage(){
		return "dept";
	}
	/**
	 * 添加部门
	 * @param dept
	 * @param request
	 * @return
	 */
	@RequestMapping("/addDept.action")
	public int insertDept(DeptBean dept,HttpServletRequest request){
		UserBean user=(UserBean)request.getSession().getAttribute("USER");
		int i=deptService.insertDept(dept, user.getUser_name());
		return i;
	}
	
	/**
	 * 分页查询所以部门
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deptList.action")
	public Map<String,Object> queryDeptListByPages(
			@RequestParam(value="pageNumber",defaultValue="1",required=false)int pageNumber,
			@RequestParam("pageSize")int pageSize){
		
		Map<String,Object>map=new HashMap<String, Object>();
		int count=deptService.queryDeptCount();
		List<DeptBean>dlist=deptService.queryDeptList((pageNumber-1)*pageSize, pageSize);
		map.put("total", count);
		map.put("rows", dlist);
		return map;
	}
	
	/**
	 * 根据部门id查询部门信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deptById.action")
	public DeptBean queryDeptById(@RequestParam("did")int id){
		return deptService.queryDeptById(id);
	}
	
	/**
	 * 修改信息
	 * @param dept
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upDept.action")
	public Integer upDept(DeptBean dept,HttpServletRequest request){
		UserBean user=(UserBean)request.getSession().getAttribute("USER");
		int i=deptService.upDept(dept, user.getUser_name());
		return i;
	}
}
