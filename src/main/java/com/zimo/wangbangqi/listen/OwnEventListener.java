package com.zimo.wangbangqi.listen;


import com.zimo.wangbangqi.model.CommentTag;
import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.model.collection.WaiterCommentTagCollection;
import com.zimo.wangbangqi.service.CommentTagService;
import com.zimo.wangbangqi.service.collectionService.WaiterCommentTagService;
import com.zimo.wangbangqi.service.waiter.event.AddWaiterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnEventListener {
    @Autowired
    CommentTagService commentTagService;
    @Autowired
    WaiterCommentTagService waiterCommentTagService;

    @EventListener
    public void listenAddWaiterEvent(AddWaiterEvent addWaiterEvent){
        Waiter waiter = addWaiterEvent.getWaiter();
        List<CommentTag> tagList = commentTagService.listAll();
        for (CommentTag commentTag : tagList){
            WaiterCommentTagCollection wctCollection = new WaiterCommentTagCollection();
            wctCollection.setCommentTagId(commentTag.getId());
            wctCollection.setWaiterId(waiter.getId());
            waiterCommentTagService.save(wctCollection);
        }
    }
}
