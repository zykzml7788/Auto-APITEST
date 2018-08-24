package com.djcps.api.utils;

import java.io.File;

import org.apache.log4j.Logger;



public class CleanFileUtil {
	
	private static Logger logger=Logger.getLogger(CleanFileUtil.class);
	//确定保留文件数
	public void clean(String dirpath,int filesnum) {
		logger.info("检查目录ing...");
		File file = new File(dirpath);
		File[] tempList = file.listFiles();
		int delSize = tempList.length;
		for (int i = 0; i < tempList.length; i++) {
		    if (tempList[i].isFile()) {
		        logger.info("文件:" + tempList[i]);
		     }
		     if (tempList[i].isDirectory()) {
		        logger.info("文件夹：" + tempList[i]);
		     }
		}
		for (int i=tempList.length-1-filesnum;i>=0;i--) {
			logger.info("临时图片删除任务启动...");
			tempList[i].delete();
			logger.info("删除图片文件："+tempList[i]);
		}
	}
	
	}
	
