package com.computer.service;



// 查询接口
import java.util.List;

public interface ISelect<T> {
    /**
     *
     * @param id
     *            需要查询的id
     * @return 返回一个电脑信息
     */
    public T selectComputerById(Integer id);

    /**
     * 查询所有电脑信息
     *
     * @return 返回所有电脑信息的集合
     */
    public List<T> selectComputers();

    /**
     * 指定品牌查询
     *
     * @return 返回集合
     */
    public List<T> selectComputersByBrand(String brand);

    /**
     * 指定 内存查询
     *
     * @return 返回指定 集合
     */
    public List<T> selectStudentsByMemory(Integer memory);
}

