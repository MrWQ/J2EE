package com.computer.mapper;

import com.computer.model.ComputerModel;
import com.computer.model.MemoryModel;

import java.util.List;

public interface ComputerMapper {
    /**
    * @Description: 添加一条数据
    * @Param: [computerModel]
    * @return: void
    * @Author: Mr.Wang
    *
    */
    public void addComputer(ComputerModel computerModel);
    /**
    * @Description: 删除一条数据
    * @Param: [id]
    * @return: void
    * @Author: Mr.Wang
    *
    */
    public void deleteComputerById(int id);
    /**
    * @Description: 根据id更新一条数据
    * @Param: [computerModel, id]
    * @return: void
    * @Author: Mr.Wang
    *
    */
    public void updateComputerById(ComputerModel computerModel, int id);
    /**
    * @Description: 根据id查找一条数据
    * @Param: [id]
    * @return: com.computer.model.ComputerModel
    * @Author: Mr.Wang
    *
    */
    public  ComputerModel selectComputerById(int id);
    /**
    * @Description: 查询所有
    * @Param: []
    * @return: java.util.List<com.computer.model.ComputerModel>
    * @Author: Mr.Wang
    *
    */
    public List<ComputerModel> selectComputers();
    /**
    * @Description: 根据品牌查询
    * @Param: [brand]
    * @return: com.computer.model.ComputerModel
    * @Author: Mr.Wang
    *
    */
    public List<ComputerModel> selectComputersByBrand(String brand);
    /**
     * @Description: 根据内存查询
     * @Param: [memory]
     * @return: com.computer.model.ComputerModel
     * @Author: Mr.Wang
     *
     */
    public List<ComputerModel> selectComputersByMemory(int memory);
    /**
     * 定时插入当前内存值
     */
    public void addMemory(MemoryModel memoryModel);
}
