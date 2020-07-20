package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeptMapper;
import com.xiaoshu.dao.TeacherMapper;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.Teacher;
import com.xiaoshu.entity.TeacherExample;
import com.xiaoshu.entity.TeacherExample.Criteria;
import com.xiaoshu.entity.TeacherVo;
import com.xiaoshu.entity.User;


@Service
public class TeacherService {

	/*@Autowired
	UserMapper userMapper;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public User existUserWithUserName(String userName) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}*/
    @Autowired
    private TeacherMapper teacherMapper;
    
    @Autowired 
    private DeptMapper deptMapper;
	public PageInfo<TeacherVo> findUserPage(TeacherVo teacherVo, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"tid";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		List<TeacherVo> tlist=teacherMapper.findPage(teacherVo);
		PageInfo<TeacherVo> pageInfo = new PageInfo<TeacherVo>(tlist);
		return pageInfo;
	}

	public List<Dept> findDept() {
		
		return deptMapper.selectAll();
	}
	
	   // 新增
		public void addUser(Teacher t) throws Exception {
			teacherMapper.insert(t);
		};

		// 修改
		public void updateUser(Teacher t) throws Exception {
			teacherMapper.updateByPrimaryKeySelective(t);
		};

		// 删除
		public void deleteUser(int i) throws Exception {
			teacherMapper.deleteByPrimaryKey(i);
		};
		// 通过用户名判断是否存在，（新增时不能重名）
		public Teacher existUserWithUserName(String teacherName) throws Exception {
			TeacherExample example = new TeacherExample();
			Criteria criteria = example.createCriteria();
			criteria.andTnameEqualTo(teacherName);
			List<Teacher> userList = teacherMapper.selectByExample(example);
			return userList.isEmpty()?null:userList.get(0);
		};


}
