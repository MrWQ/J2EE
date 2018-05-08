package com.computer.handlers;

import com.computer.model.ComputerModel;
import com.computer.service.IPersist;
import com.computer.service.ISelect;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Mr.Wang
 * @description: 控制器
 **/
@Controller
public class ComputerHandler {

    Logger logger = Logger.getLogger(this.getClass());
    @Autowired()
//    @Resource(name = "selectService")
    @Qualifier("selectService")
    protected ISelect<ComputerModel> selectService;

    @Autowired()
//    @Resource(name = "persistService")
    @Qualifier("persistService")
    IPersist<ComputerModel> persistService;

    /**
     * 查询所有computer信息
     *
     * @param //模型数据
     * @return ModelAndView
     */
    @RequestMapping("/computers")
    public String list(Map<String,Object> map) {
        logger.info("开始调用computers");
        // 查询所有的信息
        map.put("computers", selectService.selectComputers());
        return "list";
    }



    /**
     * 进入新增页面
     *
     * @param //模型数据
     * @return ModelAndView
     */
    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {

        map.put("computer", new ComputerModel());
        return "input";
    }

    /**
     * 确认新增信息
     *
     * @param computer
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.POST)
    public String save(ComputerModel computer) {

//        System.out.println(computer.getBrand()+computer.getMemory());
        persistService.addComputer(computer);
        /**
         * 此处为重定向
         */
        return "redirect:/computers";
    }
//
    /**
     *
     * @param id
     *            编号
     * @param map
     *            隐式模型数据
     */
    @RequestMapping(value = "/computer/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        // 要开始修改
        map.put("computer", selectService.selectComputerById(id));
        return "modify";
    }
//
    /**
     * 修改提交
     *
     * @param computerModel
     *
     */
    @RequestMapping(value = "/computer", method = RequestMethod.PUT)
    public String update(ComputerModel computerModel) {
        // 修改提交computer
        persistService.updateComputerById(computerModel, computerModel.getId());
        return "redirect:/computers";
    }
//
    /**
     * 删除信息
     *
     * @param id
     *
     */
    @RequestMapping(value = "/computer/computer/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        logger.info("删除" + id);
        // 删除指定id的computer信息
        persistService.delComputerById(id);
        return "redirect:/computers";
    }




}
