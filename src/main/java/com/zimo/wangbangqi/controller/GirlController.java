package com.zimo.wangbangqi.controller;



import com.zimo.wangbangqi.dto.GirlDto;
import com.zimo.wangbangqi.enums.Code;
import com.zimo.wangbangqi.model.Girl;
import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.service.GirlService;
import com.zimo.wangbangqi.utils.ResultUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GirlController {

    @Autowired
    GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlListAll(){
        return girlService.girlList();
    }

    /**
     * 新增一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Validated Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.fail(Code.FAIL,bindingResult.getFieldError().getDefaultMessage());
        }

       return ResultUtil.success(girlService.addGirl(girl));
    }

    /**
     * 新增Girl,不会改变。
     * UseCase：
     * 1.进行表单验证，验证成功继续执行。验证失败。返回验证失败信息
     * 2.通过传递的GirlDto获取Girl对象。girl = converFrom（GirlDto）
     * 3.调用girlService新增girl对象。
     * 4.返回添加成功的信息。
     * @param girlDto
     * @param bindingResult 表单验证结果
     * @return
     */
    @PostMapping(value = "/girls/girlDto/")
    public Result<GirlDto> addGirl(@Validated GirlDto girlDto,BindingResult bindingResult)throws Exception{
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(bindingResult.getFieldError().getDefaultMessage());
        }
        Girl girl = (Girl) converFor(girlDto);
        girl = girlService.addGirl(girl);
        GirlDto girlDto1 = girlService.getGirlDao(girl.getId());
        return ResultUtil.success();
    }

    /**
     * 通过Id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl searchGirlById(@PathVariable(value = "id",required = true)Integer id){
        return girlService.searchById(id);
    }

    /**
     * 更新信息
     * useCase：
     * 1.
     * @param girlDto
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(GirlDto girlDto) throws Exception{
        Girl girl = (Girl) converFor(girlDto);
        return girlService.updateById(girl);
    }
    /**
     * 通过ID删除一个女生
     * @param id
     * @return  返回被删除的女生的对象。
     */
    @DeleteMapping(value = "/girls/{id}")
    public Girl deleteById(@PathVariable(value = "id",required = true)Integer id){
        return girlService.deleteById(id);
    }

    /**
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age")
    public Result<List<Girl>> girlListByAge(@PathVariable(value = "age")Integer age){
        return ResultUtil.success(girlService.girlListByAge(age));

    }

    /**
     * 通过名字模糊查询
     * Get请求接收的参数为中文时后台出现乱码。
     * @param name
     * @return
     */
    @GetMapping(value = "/girls/name")
    public Result<List<Girl>> girlListByName(@RequestParam(value = "name",required = true) String name){
        return ResultUtil.success(girlService.girlListByName(name));
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable(value = "id")Integer id) throws Exception{
        girlService.getAge(id);
    }
/*******************************************************************************************/
    /*******
     *
     * @param id
     * @return
     * @throws Exception
     */

    @GetMapping(value = "/girls/getGirlDto/{id}")
    public Result<GirlDto> getGirlDtoById(@PathVariable(value = "id") Integer id) throws Exception{
        return ResultUtil.success(girlService.getGirlDao(id));
    }

    /**
     *  origin是PO，entity实体
     * @param dest DTO
     * @return
     * @throws Exception
     */
    private Object converFor(Object dest)throws Exception{
        Object origin = new Girl();
        BeanUtils.copyProperties(dest,origin);
        return origin;
    }

    @GetMapping(value = "/girls/list")
    public Result<List<Girl>> listGirl(Integer age,
                                       String cupSize){
        return ResultUtil.success(girlService.listGirl(age,cupSize));
    }
}
