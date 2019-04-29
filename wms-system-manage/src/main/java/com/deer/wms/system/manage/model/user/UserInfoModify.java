package com.deer.wms.system.manage.model.user;

/**
 * 修改用户的信息类
 *
 * Created by Floki on 2017/10/6.
 */
public class UserInfoModify {
    /**
     * 用户信息id
     */
    private Integer userId;
    
    /**
     * 公司id
     */
    private Integer companyId;
    
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 性别：1=先生；2=女士；
     */
    private Integer gender;

    /**
     * 电子邮箱
     */
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
    
}
