package com.computer.service;


import com.computer.mapper.ComputerMapper;
import com.computer.model.ComputerModel;

import java.util.List;

/**
 * @author: Mr.Wang
 * @description: 查询服务
 **/
public class SelectService extends AbstractDao implements ISelect<ComputerModel> {
    @Override
    public ComputerModel selectComputerById(Integer id) {
        try {
            logger.info("selectComputerById 完毕");
            return  computerMapper.selectComputerById(id);
        } catch (Exception e) {
            logger.error( "ERROR", e);
            return null;
        }
    }

    @Override
    public List<ComputerModel> selectComputers() {
        try {
            logger.info("selectComputers 完毕");
            List<ComputerModel> list = computerMapper.selectComputers();
            return list;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }

    @Override
    public List<ComputerModel> selectComputersByBrand(String brand) {
        try {
            logger.info("selectComputersByBrand 完毕");
            List<ComputerModel> list = computerMapper.selectComputersByBrand(brand);
            return list;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }

    @Override
    public List<ComputerModel> selectStudentsByMemory(Integer memory) {
        try {
            logger.info("selectStudentsByMemory 完毕");
            List<ComputerModel> list = computerMapper.selectComputersByMemory(memory);
            return list;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }
}
