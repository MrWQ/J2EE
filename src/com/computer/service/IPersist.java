package com.computer.service;


// 持久化接口
public interface IPersist<T> {
    /**
     * 添加一条
     *
     * @param t
     */
    public void addComputer(T t);

    /**
     * 修改电脑信息
     *
     * @param t
     * @param id
     *            主键
     */
    public void updateComputerById(T t, Integer id);

    /**
     * 删除电脑
     *
     * @param id
     *            主键
     */
    public void delComputerById(Integer id);
}
