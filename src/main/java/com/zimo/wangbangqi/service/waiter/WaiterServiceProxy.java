package com.zimo.wangbangqi.service.waiter;

import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaiterServiceProxy extends WaiterService {
    @Autowired
    private WaiterRedis waiterRedis;

    /**
     * 对象进行存储，然后移除缓存中的key
     * @param waiter
     * @return
     */
    @Override
    public Waiter save(Waiter waiter){
        return super.save(waiter);
    }

    /**
     * 更新策略。
     * @param waiter
     * @return
     */
    @Override
    public Waiter update(Waiter waiter) {
        waiter = super.update(waiter);
        String key = StringKeyUtil.buildKey(Waiter.class,waiter.getId());
        try {
            waiterRedis.remove(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return waiter;
    }

    /**
     * 检测缓存中是否存在该Key，存在则取出，
     * 不存在则从数据库中取出，然后存入缓存中。
     * @param id
     * @return
     */
    @Override
    public Waiter searchById(Integer id) {
        Waiter waiter = null;
        String key = StringKeyUtil.buildKey(Waiter.class,id);
        try {
            if(waiterRedis.hasKey(key)){
                waiter = waiterRedis.getByKey(key);
            } else {
                waiter = super.searchById(id);
                waiterRedis.addWaiter(key,waiter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return waiter;
    }
}
