package cn.com.self.service.impl;

import cn.com.self.domain.TbSysUser;
import cn.com.self.mapper.TbSysUserMapper;
import cn.com.self.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true)  //数据库只读
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    @Transactional(readOnly = false)  //需要插入数据，取消只读
    public void register(TbSysUser tbSysUser) {
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));  //对密码进行MD5加密
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String password) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);

        if(tbSysUser.equals(null)){
            return null;
        }

        String checkPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if(checkPassword.equals(tbSysUser.getPassword())){  //检查密码是否正确
            return tbSysUser;
        }
        return null;
    }
}
