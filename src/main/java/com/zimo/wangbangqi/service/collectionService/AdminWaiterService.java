package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.dao.AdminWaiterDao;
import com.zimo.wangbangqi.model.collection.AdminWaiterCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminWaiterService {
    @Autowired
    AdminWaiterDao adminWaiterDao;

    public AdminWaiterCollection save(AdminWaiterCollection adminWaiterCollection){
        return adminWaiterDao.save(adminWaiterCollection);
    }

    public List<AdminWaiterCollection> listCollectionByAdminId(Integer adminId){
        return adminWaiterDao.findAllByAdminId(adminId);
    }

    /**
     * 查询该Admin管理的所有的Waiter
     * @param adminId
     * @return 返回waiterId集合
     */
    public Integer[] getWaiterIdsByAdminId(Integer adminId){
        List<AdminWaiterCollection> collections = listCollectionByAdminId(adminId);
        List<Integer> list = new ArrayList<Integer>();
        for (AdminWaiterCollection adminWaiterCollection : collections){
            list.add(adminWaiterCollection.getWaiterId());
        }
        Integer[] ids = new Integer[list.size()];
        return list.toArray(ids);
    }
}
