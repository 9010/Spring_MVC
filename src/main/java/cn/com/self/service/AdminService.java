package cn.com.self.service;

import cn.com.self.domain.TbSysUser;

public interface AdminService {
    /**
     * 注册
     * @param tbSysUser
     */
    public void register(TbSysUser tbSysUser);

    /**
     * 登录
     * @param account
     * @param password
     */
    public TbSysUser login(String account, String password);
}
