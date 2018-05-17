package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.collection.GirlClassCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlClassCollectionDao extends JpaRepository<GirlClassCollection,Long>{

    public void deleteByClassId(Integer id);
    public void deleteByGirlId(Integer id);
    public void deleteByGirlIdAndAndClassId(Integer girlId,Integer classId);

    public GirlClassCollection findByClassIdAndGirlId(Integer classId,Integer girlId);
    public List<GirlClassCollection> findAllByGirlId(Integer girlId);
    public List<GirlClassCollection> findAllByClassId(Integer classId);
    public List<GirlClassCollection> findAllByGirlIdAndClassId(Integer girlId,Integer classId);

}
