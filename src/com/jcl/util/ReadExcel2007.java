package com.jcl.util;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 读取Excel 2007
 * @author jiangzq
 * 
 */
public class ReadExcel2007 {
	private String filePath = null;
	
	private int startRowNum = 0;

	private int startColNum = 0;
	
	/**
	 * 设置表格中数据的起始行列数
	 * 
	 * @param StartRowNum
	 */
	public void setDataStartRowCol(int startRowNum, int startColNum) {
		this.startRowNum = startRowNum;
		this.startColNum = startColNum;
	}
	
	/**
	 * 构造函数
	 * 
	 * @param filePath
	 *            模板文件的完整路径
	 */
	public ReadExcel2007(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * 读取Excel数据
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public List readData() throws Exception {
		List<List<String>> listData = new ArrayList<List<String>>();
		List<String> rowListData = null;
		File fExcelFile = new File(filePath);

		// 解压Book1.xlsx "D:/excel/扶持工业企业信息.xlsx"
		ZipFile xlsxFile = new ZipFile(fExcelFile);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// 先读取sharedStrings.xml这个文件备用 
		ZipEntry sharedStringXML = xlsxFile.getEntry("xl/sharedStrings.xml");
		InputStream sharedStringXMLIS = xlsxFile.getInputStream(sharedStringXML);
		Document sharedString = (Document) dbf.newDocumentBuilder().parse(sharedStringXMLIS);
		NodeList str = ((org.w3c.dom.Document) sharedString).getElementsByTagName("t");
		String sharedStrings[] = new String[str.getLength()];
		for (int n = 0; n < str.getLength(); n++) {
			Element element = (Element) str.item(n);
			//System.out.println(element.getTextContent());
			sharedStrings[n] = element.getTextContent();
		}
		// 找到解压文件夹里的workbook.xml,此文件中包含了这张工作表中有几个sheet
		ZipEntry workbookXML = xlsxFile.getEntry("xl/workbook.xml");
		InputStream workbookXMLIS = xlsxFile.getInputStream(workbookXML);
		Document doc = dbf.newDocumentBuilder().parse(workbookXMLIS);
		// 获取一共有几个sheet
		NodeList nl = doc.getElementsByTagName("sheet");

		//for (int i = 0; i < nl.getLength(); i++) {
		for (int i = 0; i < 1; i++) {
			// 将node转化为element，用来得到每个节点的属性
			Element element = (Element) nl.item(i);
			//System.out.println(element.getAttribute("name"));// 输出sheet节点的name属性的值
			// 接着就要到解压文件夹里找到对应的name值的xml文件，比如在workbook.xml中有<sheet
			// name="Sheet1" sheetId="1" r:id="rId1" /> 节点
			// 那么就可以在解压文件夹里的xl/worksheets下找到sheet1.xml,这个xml文件夹里就是包含的表格的内容
			ZipEntry sheetXML = xlsxFile.getEntry("xl/worksheets/sheet" + (i + 1) + ".xml");
			//ZipEntry sheetXML = xlsxFile.getEntry("xl/worksheets/sheet" + element.getAttribute("sheetId") + ".xml");
			InputStream sheetXMLIS = xlsxFile.getInputStream(sheetXML);
			Document sheetdoc = dbf.newDocumentBuilder().parse(sheetXMLIS);
			NodeList rowdata = sheetdoc.getElementsByTagName("row");
			for (int j = startRowNum-1; j < rowdata.getLength(); j++) {
			//for (int j = startRowNum-1; j < rowdata.getLength(); j++) {
				rowListData = new ArrayList<String>();
				// 得到每个行   行的格式
				Element row = (Element) rowdata.item(j);
				// 根据行得到每个行中的列
				NodeList columndata = row.getElementsByTagName("c");
				//String tempRowValues = "";
				for (int k = startColNum-1; k < columndata.getLength(); k++) {
					Element column = (Element) columndata.item(k);
					NodeList values = column.getElementsByTagName("v");
					Element value = (Element) values.item(0);
					
					if (value == null) {
						rowListData.add("");
						continue;
					}
					if (column.getAttribute("t") != null && column.getAttribute("t").equals("s")) {
						// 如果是共享字符串则在sharedstring.xml里查找该列的值
						//System.out.print(sharedStrings[Integer.parseInt(value.getTextContent())] + " ");
						rowListData.add(sharedStrings[Integer.parseInt(value.getTextContent())]);
					} else {
						rowListData.add(value.getTextContent());
					}
				}
				listData.add(rowListData);
			}
		}
		
		return listData;
	}
	
	public String ConvertDouble(String str) {
		String strRet = str;
		String temp = "";
		
		if (str == null) {
			return "";
		}
		
		int nPos = str.indexOf(".");
		if (nPos < 0) {
			return str;
		}
		temp = str.substring(nPos);
		
		int nPos2 = temp.indexOf("00000");
		if (nPos2 >= 0) {
			Double d = Double.valueOf(str);
			BigDecimal bd = new BigDecimal(d).setScale(nPos2-1,BigDecimal.ROUND_HALF_UP);
			strRet = String.valueOf(bd);
		}
		
		nPos2 = temp.indexOf("99999");
		if (nPos2 >= 0) {
			Double d = Double.valueOf(str);
			BigDecimal bd = new BigDecimal(d).setScale(nPos2-1,BigDecimal.ROUND_HALF_UP);
			strRet = String.valueOf(bd);
		}
		
		return strRet;
	}
	
	/*public static void main(String[] args) throws Exception {
		ReadExcel2007 readExcel2007 = new ReadExcel2007("D:/excel/扶持工业企业信息.xlsx");
		readExcel2007.readData();
	}*/
	
}