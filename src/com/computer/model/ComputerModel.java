package com.computer.model;

import java.util.Date;

/**
 * @author: Mr.Wang
 * @description: pojo类
 **/
public class ComputerModel {
    /**
     * @Description: 主键 id
     * @Author: Mr.Wang
     *
     */
    private int id;
    /**
     * @Description: 姓名 name
     * @Author: Mr.Wang
     *
     */
    private String name;
    /**
     * @Description: 品牌
     * @Author: Mr.Wang
     *
     */
    private String brand;
    /**
     * @Description: cpu 处理器
     * @Author: Mr.Wang
     *
     */
    private String cpu;
    /**
     * @Description: gpu显卡
     * @Author: Mr.Wang
     *
     */
    private String gpu;
    /**
     * @Description: ssd 固态硬盘
     * @Author: Mr.Wang
     *
     */
    private int ssd;
    /**
     * @Description: hdd 机械硬盘
     * @Author: Mr.Wang
     *
     */
    private int hdd;
    /**
     * @Description: 内存 memory
     * @Author: Mr.Wang
     *
     */
    private int memory;
    /**
     * @Description: 价格
     * @Author: Mr.Wang
     *
     */
    private int price;
    /**
     * @Description: 添加时间
     * @Author: Mr.Wang
     *
     */
    private Date optime;

    public ComputerModel() {
    }

    public ComputerModel(String name, String brand, String cpu, String gpu, int ssd, int hdd, int memory, int price) {
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.memory = memory;
        this.price = price;
    }

    public ComputerModel(int id, String name, String brand, String cpu, String gpu, int ssd, int hdd, int memory, int price, Date optime) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.memory = memory;
        this.price = price;
        this.optime = optime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }
}
