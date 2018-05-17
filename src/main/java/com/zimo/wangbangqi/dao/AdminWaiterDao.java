package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.collection.AdminWaiterCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminWaiterDao extends JpaRepository<AdminWaiterCollection ,Integer> {

    public List<AdminWaiterCollection> findAllByAdminId(Integer adminId);
    public List<AdminWaiterCollection> findAllByWaiterId(Integer waiterId);
}
