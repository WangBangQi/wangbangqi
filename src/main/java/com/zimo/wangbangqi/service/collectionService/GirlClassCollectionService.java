package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.dao.GirlClassCollectionDao;
import com.zimo.wangbangqi.model.collection.GirlClassCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlClassCollectionService {

    @Autowired
    private GirlClassCollectionDao girlClassCollectionDao;

    public GirlClassCollection addGirlClassCollection(GirlClassCollection girlClassCollection){
        return girlClassCollectionDao.save(girlClassCollection);
    }
    public void deleteGirlClassCollectionById(Integer id){
        girlClassCollectionDao.deleteById(id.longValue());
    }
    public void deleteGirlClassCollectionByClassId(Integer classId){
        girlClassCollectionDao.deleteByClassId(classId);
    }
    public void deleteGirlClassCollectionByGirlId(Integer girlId){
        girlClassCollectionDao.deleteByGirlId(girlId);
    }
    public void deleteGirlClassCollectionByGirlIdAndClassId(Integer girlId,Integer classId){
        girlClassCollectionDao.deleteByGirlIdAndAndClassId(girlId,classId);
    }
    public List<GirlClassCollection> listAllByGirlId(Integer girlId){
        return girlClassCollectionDao.findAllByGirlId(girlId);
    }
    public List<GirlClassCollection> listAllByClassId(Integer classId){
        return girlClassCollectionDao.findAllByClassId(classId);
    }
    public GirlClassCollection searchById(Integer id){
        return girlClassCollectionDao.getOne(id.longValue());
    }
    public GirlClassCollection searchByClassIdAndGirlId(Integer classId,Integer girlId){
        return girlClassCollectionDao.findByClassIdAndGirlId(classId,girlId);
    }
}
