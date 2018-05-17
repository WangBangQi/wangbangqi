package com.zimo.wangbangqi.dtoFactory;

import com.sun.tools.javac.util.Context;
import com.zimo.wangbangqi.dto.GirlDto;
import com.zimo.wangbangqi.model.Class;
import com.zimo.wangbangqi.model.Girl;
import com.zimo.wangbangqi.model.collection.GirlClassCollection;
import com.zimo.wangbangqi.service.ClassService;
import com.zimo.wangbangqi.service.GirlService;
import com.zimo.wangbangqi.service.collectionService.GirlClassCollectionService;
import com.zimo.wangbangqi.utils.SpringUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GirlDtoFactory extends BaseFactory<Girl,GirlDto> {

    //通过springUtils获取一个service
//    GirlService girlService = (GirlService) SpringUtil.getBean("girlService");
    GirlClassCollectionService girlClassCollectionService = (GirlClassCollectionService) SpringUtil.getBean(GirlClassCollectionService.class);

    ClassService classService = (ClassService) SpringUtil.getBean(ClassService.class);
    //在这里直接写入一个VO的class
    public GirlDtoFactory(Girl girl) throws InstantiationException, IllegalAccessException{
        super(girl,GirlDto.class);
    }

    @Override
    public void setTb(Girl tb) {
        super.setTb(tb);
    }

    @Override
    public GirlDto build() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
        return super.build();
    }

    @Override
    protected Girl getTb() {
        return super.getTb();
    }

    @Override
    public Girl make(Context context) {
        return null;
    }

    /**
     * 特殊字段的处理。
     * @param vo
     */
    @Override
    protected void doOrderThingForVo(GirlDto vo) {

        vo.setBeauty(getTb().getCupSize()+getTb().getAge());
        List<Class> list = new ArrayList<>();
        ArrayList<GirlClassCollection> lists = (ArrayList)girlClassCollectionService.listAllByGirlId(getTb().getId());
        for (GirlClassCollection girlClassCollection : lists){
            list.add(classService.getClassById(girlClassCollection.getClassId()));
        }
        vo.setClasses(list);
    }

}
