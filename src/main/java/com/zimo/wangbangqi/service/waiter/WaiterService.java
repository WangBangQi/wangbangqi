package com.zimo.wangbangqi.service.waiter;

import com.zimo.wangbangqi.dao.WaiterDao;
import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.dtoFactory.WaiterDtoFactory;
import com.zimo.wangbangqi.enums.WaiterValue;
import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.waiter.event.AddWaiterEvent;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WaiterService {

    @Autowired
    private WaiterDao waiterDao;
    @Autowired
    ApplicationContext applicationContext;

    public Waiter save(Waiter waiter){
        waiter = initWaiter(waiter);
        //事件的发布
        waiter = waiterDao.save(waiter);
        applicationContext.publishEvent(new AddWaiterEvent(this,waiter));
        return waiter;
    }
    public void delete(Integer id){
        waiterDao.deleteById(id);
    }
    public Waiter update(Waiter waiter){
        return waiterDao.save(waiter);
    }
    public Waiter searchById(Integer id){
        return waiterDao.findById(id).get();
    }

    /**************************/
    public WaiterDto searchDtoById(Integer id) throws Exception{
        Waiter waiter = searchById(id);
        WaiterDto waiterDto = new WaiterDtoFactory(waiter).build();
        return waiterDto;
    }

    public WaiterDto updateDto(WaiterDto waiterDto)throws Exception{
        Waiter waiter = waiterDao.save(conventFrom(waiterDto));
        return new WaiterDtoFactory(waiter).build();
    }

    private Waiter conventFrom(WaiterDto waiterDto )throws Exception{
        Waiter waiter = new Waiter();
        BeanUtils.copyProperties(waiter,waiterDto);
        return waiter;
    }

    //
    public Waiter save(WaiterDto waiterDto)throws Exception{
        Waiter waiter = conventFrom(waiterDto);
        return this.save(waiter);
    }

    private Waiter initWaiter(Waiter waiter){
        if(waiter.getName() == null)
            waiter.setName(WaiterValue.DEFAULT_WAITER_NAME);
        if(waiter.getAge() == null)
            waiter.setAge(WaiterValue.DEFAULT_WAITER_AGE);
        if (waiter.getSex() == null)
            waiter.setSex(WaiterValue.DEFAULT_WAITER_SEX);
        if(waiter.getAddress()== null)
            waiter.setAddress(WaiterValue.DEFAULT_WAITER_ADDRESS);
        if(waiter.getAreaNo()== null)
            waiter.setAreaNo(WaiterValue.DEFAULT_WAITER_AREA_NO);
        if (waiter.getCityNo()== null)
            waiter.setCityNo(WaiterValue.DEFAULT_WAITER_CITY_NO);
        if(waiter.getFakeServiceCount() == null)
            waiter.setFakeServiceCount(WaiterValue.DEFAULT_WAITER_FAKE_SERVICE_COUNT);
        if (waiter.getIntroduction()== null)
            waiter.setIntroduction(WaiterValue.DEFAULT_WAITER_INTRODUCTION);
        if (waiter.getPrice() == null)
            waiter.setPrice(WaiterValue.DEFAULT_WAITER_PRICE);
        if (waiter.getHeadPic()== null)
            waiter.setHeadPic(WaiterValue.DEFAULT_WAITER_HEAD_PIC);
       /*     private Integer id;
        private String name;
        private Integer age;
        private String headPic;
        private Boolean sex;    //true为男，false为女
        private String introduction;   //自我介绍
        private String address;
        private Double price;
        private String areaNo;      //与所属的管理员保持一致。
        private String cityNo;
        private Integer fakeServiceCount;   //初始订单数。*/
       return waiter;
    }
}
