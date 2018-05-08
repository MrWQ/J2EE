package com.computer.thread;

import com.computer.mapper.ComputerMapper;
import com.computer.model.MemoryModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class MemThread extends Thread {
	private static final Logger logger = Logger.getLogger(MemThread.class);
	@Autowired
	ComputerMapper computerMapper;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				MemoryModel memoryModel = new MemoryModel();
				memoryModel.setMaxMemory((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024));
				memoryModel.setTotalMemory((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024));
				memoryModel.setFreeMemory((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024));
				computerMapper.addMemory(memoryModel);
				logger.info("记录一次内存信息");
			} catch (InterruptedException e) {
				logger.error("ERROR", e);
			}
		}
	}

	public ComputerMapper getComputerMapper() {
		return computerMapper;
	}

	public void setComputerMapper(ComputerMapper computerMapper) {
		this.computerMapper = computerMapper;
	}
}
