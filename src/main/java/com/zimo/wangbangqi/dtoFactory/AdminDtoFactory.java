package com.zimo.wangbangqi.dtoFactory;

import com.sun.tools.javac.util.Context;
import com.zimo.wangbangqi.dto.AdminDto;
import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.model.Admin;
import com.zimo.wangbangqi.service.collectionService.AdminWaiterService;
import com.zimo.wangbangqi.service.waiter.WaiterService;
import com.zimo.wangbangqi.service.waiter.WaiterServiceProxy;
import com.zimo.wangbangqi.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AdminDtoFactory extends BaseFactory<Admin,AdminDto> {
    private Logger logger = LoggerFactory.getLogger(AdminDtoFactory.class);

    WaiterServiceProxy waiterService = SpringUtil.getBean(WaiterServiceProxy.class);
    AdminWaiterService adminWaiterService = SpringUtil.getBean(AdminWaiterService.class);

    public AdminDtoFactory(Admin admin)throws InstantiationException, IllegalAccessException{
        super(admin,AdminDto.class);
    }

    public AdminDtoFactory(Admin admin, Class<AdminDto> clazz) throws InstantiationException, IllegalAccessException {
        super(admin, clazz);
    }

    @Override
    protected void doOrderThingForVo(AdminDto vo) {
        logger.info("AdminDtoFactory doOrderThingForVo process....");
        //获取Admin其下的Waiter的Ids
        Integer[] waiterIds = adminWaiterService.getWaiterIdsByAdminId(vo.getId());
        List<WaiterDto> waiterDtoList = new ArrayList<WaiterDto>();
        try {
            for (Integer id : waiterIds){
                WaiterDto waiterDto = waiterService.searchDtoById(id);
                waiterDtoList.add(waiterDto);
            }
        }catch (Exception e){
            logger.error("doOrderThingForVo exception {}",e);
            e.printStackTrace();
        }
        vo.setWaiterDtoList(waiterDtoList);

    }

    @Override
    public Admin make(Context context) {
        return null;
    }
}
