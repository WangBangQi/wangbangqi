package com.zimo.wangbangqi.service.waiter.event;

import com.zimo.wangbangqi.model.Waiter;
import org.springframework.context.ApplicationEvent;

/**
 * 新增Waiter事件，事件源
 */
public class AddWaiterEvent extends ApplicationEvent{

    private Waiter waiter;

    /**
     *
     * @param source    发布事件的对象
     * @param waiter    携带的信息
     */
    public AddWaiterEvent(Object source,Waiter waiter) {
        super(source);
        this.waiter = waiter;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
