package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.dao.WaiterCommentTagDao;
import com.zimo.wangbangqi.model.collection.WaiterCommentTagCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterCommentTagService {
    @Autowired
    private WaiterCommentTagDao wctDao;

    public List<WaiterCommentTagCollection> listALLByWaiterId(Integer waiterId){
        return wctDao.findAllByWaiterId(waiterId);
    }
    public WaiterCommentTagCollection save(WaiterCommentTagCollection waiterCommentTagCollection){
        return wctDao.save(waiterCommentTagCollection);
    }
}
