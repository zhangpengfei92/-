package com.jcl.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import javax.imageio.ImageIO;

import com.jcl.pojo.FileUploadPathObject;
import com.jcl.util.DeployProperties;

public class FileUtil {
	public FileUtil() {
	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return boolean
	 */
	public void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @return boolean
	 */
	public void newFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();

		} catch (Exception e) {
			System.out.println("新建文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹
	 * 
	 * @param filePathAndName
	 *            String 文件夹路径及名称 如c:/fqf
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹

		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 */
	public void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
			}
		}
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);

	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);

	}

	// 拷贝文件
	@SuppressWarnings("unused")
	private void copyFile2(String source, String dest) {
		try {
			File in = new File(source);
			File out = new File(dest);
			FileInputStream inFile = new FileInputStream(in);
			FileOutputStream outFile = new FileOutputStream(out);
			byte[] buffer = new byte[1024];
			int i = 0;
			while ((i = inFile.read(buffer)) != -1) {
				outFile.write(buffer, 0, i);
			}// end while
			inFile.close();
			outFile.close();
		}// end try
		catch (Exception e) {

		}// end catch
	}// end copyFile

	public static void writerFile(String sourceFileName, String content,
			boolean isAppend, String encode) {
		FileOutputStream stream = null; // provides file access
		OutputStreamWriter writer = null; // writes to the file
		try {
			stream = new FileOutputStream(sourceFileName, isAppend);
			writer = new OutputStreamWriter(stream, encode);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Can not write the file. "+sourceFileName,e);
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public static void downLoadImg(String imgUrl, String path) {
		BufferedImage image = null;
		try {
			URL url = new URL(imgUrl);
			image = ImageIO.read(url);
			ImageIO.write(image, "jpg", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static FileUploadPathObject createUploadPathProjectLocal(String folderName) throws Exception {
		/*String base = ServletActionContext.getServletContext().getRealPath("/");
		String uploadPath = base + "/uploadfiles/" + folderName + "/";*/
		String uploadPath = DeployProperties.getInstance().getPublicFilePath() + "/" + folderName + "/";
		//String uploadPath =Constant.TOMCAT_MAP_PATH + "/uploadfiles/" + folderName + "/";
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		return new FileUploadPathObject(uploadPath, "");
	}
	
//	/**
//	 * 文件上传辅助对象
//	 */
//	public class FileUploadPathObject {
//		private String absoluteFullPath;
//		private String shortPath;
//		
//		public FileUploadPathObject(){
//			
//		}
//		
//		public FileUploadPathObject(String fullPath, String shortPath) {
//			this.absoluteFullPath = fullPath;
//			this.shortPath = shortPath;
//		}
//
//		public String getAbsoluteFullPath() {
//			return absoluteFullPath;
//		}
//
//		public void setAbsoluteFullPath(String absoluteFullPath) {
//			this.absoluteFullPath = absoluteFullPath;
//		}
//
//		public String getShortPath() {
//			return shortPath;
//		}
//
//		public void setShortPath(String shortPath) {
//			this.shortPath = shortPath;
//		}
//	}
	//允许上传的文件扩展名数组
		public static String[] _strAllowdFileExts = {};
	/**
	 * 上传文件到服务器
	 * @param folderName 保存该文件的文件夹名称
	 * @param myFile 要上传的文件
	 * @return
	 * @throws Exception
	 */
	public static FileUploadPathObject uploadProjectLocal(String folderName, File myFile, String fileName) throws Exception {
		if (myFile == null) {
			_strAllowdFileExts = new String[]{};
			return null;
		}
		if (myFile.length() == 0) {
			_strAllowdFileExts = new String[]{};
			throw new Exception("不可以上传内容为空的文件！");
		}
		if (myFile.length() > 500 * 1024 * 1024) {
			_strAllowdFileExts = new String[]{};
			throw new Exception("最大只可以上传500M大小的文件！");
		}
		FileUploadPathObject uploadPathObject = createUploadPathProjectLocal(folderName);
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置上传文件目录
		String uploadPath = uploadPathObject.getAbsoluteFullPath();
		// 设置目标文件
		File toFile = createTargetFile(uploadPath, fileName, -1);
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		// 设置缓存
		byte[] buffer = new byte[1024];
		int length = 0;
		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		// 关闭输入流
		is.close();
		// 关闭输出流
		os.close();
		_strAllowdFileExts = new String[]{};
		uploadPathObject.setAbsoluteFullPath(toFile.getAbsolutePath());
		uploadPathObject.setShortPath("/" + folderName + "/" + toFile.getName());
		return uploadPathObject;
	}
	
	/**
	 * 创建目标文件
	 * @param uploadPath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static File createTargetFile(String uploadPath, String fileName, int index) throws Exception {
		File nFile = new File(uploadPath, (index == -1 ? "" : index + "") + fileName);
		if (nFile.exists() && nFile.isFile()) {
			nFile = createTargetFile(uploadPath, fileName, index == -1 ? 1 : index + 1);
		}
		return nFile;
	}
	
	/**
	 * 上传文件到服务器
	 * @param folderName 保存该文件的文件夹名称
	 * @param myFile 要上传的文件
	 * @return
	 * @throws Exception
	 */
	public FileUploadPathObject uploadProject(String folderName, File myFile, String fileName) throws Exception {
		if (myFile == null) {
			_strAllowdFileExts = new String[]{};
			return null;
		}
		if (myFile.length() == 0) {
			_strAllowdFileExts = new String[]{};
			throw new Exception("不可以上传内容为空的文件！");
		}
		if (myFile.length() > 500 * 1024 * 1024) {
			_strAllowdFileExts = new String[]{};
			throw new Exception("最大只可以上传500M大小的文件！");
		}
		FileUploadPathObject uploadPathObject = createUploadPathProject(folderName);
		// 基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(myFile);
		// 设置上传文件目录
		String uploadPath = uploadPathObject.getAbsoluteFullPath();
		// 设置目标文件
		File toFile = createTargetFile(uploadPath, fileName, -1);
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		// 设置缓存
		byte[] buffer = new byte[1024];
		int length = 0;
		// 读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		// 关闭输入流
		is.close();
		// 关闭输出流
		os.close();
		_strAllowdFileExts = new String[]{};
		uploadPathObject.setAbsoluteFullPath(toFile.getAbsolutePath());
		uploadPathObject.setShortPath(folderName + "/" + toFile.getName());
		return uploadPathObject;
	}

	private static final String TOMCAT_MAP_PATH = DeployProperties.getInstance().getPublicFilePath();
	
	public FileUploadPathObject createUploadPathProject(String folderName) throws Exception {
		String uploadPath = TOMCAT_MAP_PATH + "/" + folderName + "/";
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		
		return new FileUploadPathObject(uploadPath, "");
	}
}