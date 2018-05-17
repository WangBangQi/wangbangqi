package com.zimo.wangbangqi.dtoFactory;

import com.sun.tools.javac.util.Context;
import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.model.collection.WaiterCommentTagCollection;
import com.zimo.wangbangqi.service.CommentTagService;
import com.zimo.wangbangqi.service.collectionService.WaiterCommentTagService;
import com.zimo.wangbangqi.utils.SpringUtil;

import java.util.ArrayList;
import java.util.List;

public class WaiterDtoFactory extends BaseFactory<Waiter,WaiterDto> {

    WaiterCommentTagService waiterCommentTagService = SpringUtil.getBean(WaiterCommentTagService.class);
    CommentTagService commentTagService = SpringUtil.getBean(CommentTagService.class);

    public WaiterDtoFactory(Waiter waiter) throws InstantiationException, IllegalAccessException{
        super(waiter,WaiterDto.class);
    }

    @Override
    public Waiter make(Context context) {
        return null;
    }

    @Override
    protected Waiter getTb() {
        return super.getTb();
    }

    @Override
    protected void doOrderThingForVo(WaiterDto vo) {
        //TODO:拼装不属于waiter的字段。
        List<String> list = new ArrayList<String>();
        List<WaiterCommentTagCollection> collections = waiterCommentTagService.listALLByWaiterId(getTb().getId());
        for (WaiterCommentTagCollection wctCollection: collections){
            list.add(commentTagService.searchById(wctCollection.getCommentTagId()).getContent());
        }
        vo.setCommentTag(list);
    }
}
