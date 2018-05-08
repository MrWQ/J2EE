package com.computer.service;

import com.computer.model.ComputerModel;

/**
 * @author: Mr.Wang
 * @description: 持久化服务
 **/
public class PersistService extends AbstractDao implements IPersist<ComputerModel>{
    public PersistService() {
        super();
        System.out.println("PersistService调用无参构造方法");
    }
    @Override
    public void addComputer(ComputerModel computerModel) {
        computerMapper.addComputer(computerModel);
        logger.info("addComputer 完毕");
    }

    @Override
    public void updateComputerById(ComputerModel computerModel, Integer id) {
        try {
            // 在删除之前检查黑名单,在黑名单中数据 不可以更新
            if (super.checkBlackPermission(id)){
                String string = String.format("记录%s无法更新!", id);
                logger.warn(string);
                return;
            }
            // 不在黑名单,可以更新
            computerMapper.updateComputerById(computerModel,id);
            logger.info("updateComputerById 完毕");
            logger.info("记录" + id + "已经更新");
        }catch (Exception e){
            logger.error("Error", e);
        }
    }

    @Override
    public void delComputerById(Integer id) {
        try {
            // 在删除之前检查白名单,在白名单中数据才可以删除
            if (!super.checkWhitePermission(id)){
                String string = String.format("记录%s无法删除!", id);
                logger.warn(string);
                return;
            }
            // 在白名单,可以删除
            computerMapper.deleteComputerById(id);
            logger.info("记录" + id + "已经删除");
        }catch (Exception e){
            logger.error("Error", e);
        }

    }
}
