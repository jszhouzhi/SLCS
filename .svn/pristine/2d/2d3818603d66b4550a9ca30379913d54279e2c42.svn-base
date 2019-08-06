package com.slzr.common.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

public class PathUtils {
	public static String AbsolutePath(String folderpath)
	{		
		File path = null;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
			File upload = new File(path.getAbsolutePath(),folderpath);
			if(!upload.exists()) upload.mkdirs();
			return upload.getAbsolutePath();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return e1.getMessage();
		}
	}
}
