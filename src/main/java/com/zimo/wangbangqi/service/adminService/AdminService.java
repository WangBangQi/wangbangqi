package com.zimo.wangbangqi.service.adminService;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zimo.wangbangqi.dao.AdminDao;
import com.zimo.wangbangqi.dto.AdminDto;
import com.zimo.wangbangqi.dtoFactory.AdminDtoFactory;
import com.zimo.wangbangqi.exception.JudgeException;
import com.zimo.wangbangqi.model.Admin;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;
    @Autowired
    AdminRedis adminRedis;

    public Admin save(Admin admin) {
        //TODO:密码加密
        Admin localAdmin = null;
        localAdmin = adminDao.save(admin);
        String key = StringKeyUtil.buildKey(Admin.class,admin.getAccNum());
        try {
            if (adminRedis.hasKey(key))
                adminRedis.remove(key);

        } catch (Exception e){
            e.printStackTrace();
        }
        return localAdmin;
    }

    /**
     * 管理员登录，我想是不是应该只去数据库查找数据来进行验证，保证Admin是正确的？
     * @param accNum
     * @return
     * @throws Exception
     */
    public Admin searchByAccNum(String accNum) throws Exception{
        Admin admin = null;
        String key = StringKeyUtil.buildKey(Admin.class,accNum);
        if (adminRedis.hasKey(key)){
            return adminRedis.getByKey(key);
        } else {
            admin = adminDao.findByAccNum(accNum);
            //疑问，缓存中没有，如果数据库中返回的也是空，则应当返回为空。
            if (admin == null)
                return null;
            //查找到admin才放入缓存中。
            adminRedis.addAdmin(key,admin);
        }
        return admin;
    }

    public AdminDto getAdminDto(String accNum,String password) throws Exception{
        if(this.judgeAdmin(accNum,password))
            return new AdminDtoFactory(searchByAccNum(accNum)).build();
        return null;
    }

    public Boolean accNumIsExist(String accNum)throws Exception{
        if(accNum == null)
            return false;

        return this.searchByAccNum(accNum) == null ? false : true;
    }

    public Boolean judge(Admin admin) throws Exception{
        if(admin == null)
            return false;
        if (!accNumIsExist(admin.getAccNum()))
            throw new JudgeException("管理员账号不存在");
        Admin localAdmin = searchByAccNum(admin.getAccNum());
        if(admin.getPassword() == null || !localAdmin.getPassword().equals(admin.getPassword()))
            throw new JudgeException("登录密码错误");
        return true;
    }

    public Boolean judgeAdmin(Admin admin) throws Exception{
        //TODO:密码解密
        return this.judge(admin);
    }
    public Boolean judgeAdmin(String accNum,String password) throws Exception{
        Admin admin = new Admin();
        admin.setAccNum(accNum);
        admin.setPassword(password);
        return judgeAdmin(admin);
    }
}
