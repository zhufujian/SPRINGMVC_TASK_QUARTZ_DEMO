package com.study.demo.task;

import org.apache.log4j.Logger;

public class DemoTimerComp {

	private static Logger logger = Logger.getLogger(DemoTimerComp.class);
	//private IDemoService demoService;

	public void demoTimerHandle() {
		logger.info("进入XXX定时任务。");
		boolean result = false;
		try {
			//result = demoService.close();
		} catch (Exception e) {
			logger.info("XXX定时任务异常。" + e);
		}
		if (result==false) {
			logger.info("XXX定时任务执行失败。");
		}
		logger.info("XXX定时任务成功完成。");
	}

}
