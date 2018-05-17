package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.dto.GirlDto;
import com.zimo.wangbangqi.dtoFactory.GirlDtoFactory;
import com.zimo.wangbangqi.enums.Code;
import com.zimo.wangbangqi.dao.GirlDao;
import com.zimo.wangbangqi.enums.DefaultValue;
import com.zimo.wangbangqi.enums.GirlStatusEnum;
import com.zimo.wangbangqi.enums.ResultEnum;
import com.zimo.wangbangqi.exception.GirlException;
import com.zimo.wangbangqi.model.Girl;
import com.zimo.wangbangqi.utils.RedisUtil;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlDao girlDao;
    @Autowired
    private RedisUtil redisUtil;

    public List<Girl> girlList(){
        return girlDao.findAll();
    }

    public Girl addGirl(Girl girl){
        if(girl.getWorkTime().toString().isEmpty())
            girl.setWorkTime(DefaultValue.GIRL_WORK_TIME);
        girl.setCupSize(DefaultValue.GIRL_CUP_SIZE);
        girl.setStatus(DefaultValue.GIRL_STATUS);
        girl.setMoney(DefaultValue.GIRL_MONEY);
        girl.setCreateTime(System.currentTimeMillis());
        girl.setUpdateTime(girl.getCreateTime());
        return girlDao.save(girl);
    }

    /**
     * 通过Id查找Girl
     * @param id
     * @return
     */
    public Girl searchById(Integer id){
        String key = StringKeyUtil.buildKey(this.getClass(),id);
        if(redisUtil.hasKey(key))
            return (Girl) redisUtil.get(key);
        Girl girl = girlDao.findById(id).get();
        redisUtil.save(key,girl);
        return girl;
    }

    /**
     * 更新该对象,会通过ID，查找对象，进行更新保存.
     * @param girl
     * @return
     */
    public Girl updateById(Girl girl){

        return girlDao.save(girl);
    }

    /**
     * 通过ID删除一个女生
     * @param id
     * @return  返回被删除的女生对象。
     */
    public Girl deleteById(Integer id){
        Girl girl = searchById(id);
        girlDao.deleteById(id);
        return girl;
    }

    public List<Girl> girlListByAge(Integer age){
        return girlDao.findByAge(age);
    }

    public List<Girl> girlListByName(String name){
//        return girlDao.findByNameLike(name);

        return girlDao.findAllByNameLike("%"+name+"%");
    }

    public void getAge(Integer id)throws Exception{
        Girl girl = searchById(id);
        Integer age = girl.getAge();
        if(age<=10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age>10 && age<=16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
/************************************************/
    /**
     * 通过GirlId来获取Dto返回的数据对象。
     * @param id
     * @return
     * @throws Exception
     */
    public GirlDto getGirlDao(Integer id) throws Exception {

        GirlDto girlDto = new GirlDtoFactory(searchById(id)).build();
        return girlDto;
    }

    /**
     * 获取Controller层传入的DTO对象，将其进行存储。
     * @param girlDto
     * @return
     */
    public GirlDto addGirl(GirlDto girlDto){
        return null;
    }


    public List<Girl> listGirl(Integer age,String cupSize){
        return girlDao.findByAgeAndCupSize(age,cupSize);
    }
}
