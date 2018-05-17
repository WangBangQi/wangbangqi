package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.model.Review;
import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.ReviewService.ReviewService;
import com.zimo.wangbangqi.service.waiter.WaiterService;
import com.zimo.wangbangqi.service.waiter.WaiterServiceProxy;
import com.zimo.wangbangqi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/admin")
public class AdminWaiterController {

    @Autowired
    WaiterService waiterService;

    @Autowired
    private WaiterServiceProxy waiterServiceProxy;
    @Autowired
    ReviewService reviewService;

    @GetMapping(value = "{adminId}/waiter/{waiterId}")
    public Result<WaiterDto> searchById(@PathVariable(value = "adminId") Integer adminId,
                                        @PathVariable(value = "waiterId") Integer waiterId) throws Exception {
        return ResultUtil.success(waiterService.searchDtoById(waiterId));
    }

    /**
     *
     * @param adminId
     * @param waiterDto
     * @return
     * @throws Exception
     */
    @PostMapping(value = "{adminId}/waiter")
    public Result<WaiterDto> addWaiter(@PathVariable(value = "adminId")Integer adminId,
                                       WaiterDto waiterDto)throws Exception{
        return ResultUtil.success(waiterService.save(waiterDto));
    }

    @PutMapping(value = "{adminId}/waiter")
    public Result<WaiterDto> updateWaiterDto(@PathVariable(value = "adminId") Integer adminId,
                                             WaiterDto waiterDto) throws Exception {
        return ResultUtil.success(waiterService.updateDto(waiterDto));
    }

    @PatchMapping(value = "{adminId}/waiter/{waiterId}")
    public Result<WaiterDto> patchWaiterDto(@PathVariable(value = "adminId")Integer adminId,
                                            @PathVariable(value = "waiterId")Integer waiterId,
                                            @RequestBody HashMap map){


        return ResultUtil.success();
    }

    @DeleteMapping(value = "{adminId}/waiter/{waiterId}")
    public Result deleteByWaiterId(@PathVariable(value = "adminId")Integer adminId,
                                   @PathVariable(value = "waiterId")Integer waiterId)throws Exception{
        waiterService.delete(waiterId);
        return ResultUtil.success();
    }

    @PostMapping(value = "/waiter")
    public Result addWaiter(Waiter waiter){
        return ResultUtil.success(waiterServiceProxy.save(waiter));
    }

    @GetMapping(value = "/waiter/{waiterId}/review")
    public Result listWaiterReview(@PathVariable(value = "waiterId")Integer waiterId,
                                   @RequestParam(value = "pageNo")Integer pageNo,
                                   @RequestParam(value = "pageSize")Integer pageSize){
        //TODO: 获取评价标签。

        return ResultUtil.success(reviewService.listByWaiterId(waiterId,pageNo,pageSize));
    }
    @PostMapping(value = "/review")
    public Result addReview(Review review){
        return ResultUtil.success(reviewService.save(review));
    }

}
