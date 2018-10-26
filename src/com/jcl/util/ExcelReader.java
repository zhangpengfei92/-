package com.jcl.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author jzq
 */
public class ExcelReader {
	private String filePath = null;

	private int startRowNum = 0;

	private int startColNum = 0;

	private int currentSheetIndex = 0;

	private int maxRows = -1;

	private int maxCols = -1;

	private HashMap<String, String> colPropMap;

	private HashMap<String, String> titleNameMap;

	/**
	 * 构造函数
	 * 
	 * @param filePath
	 *            模板文件的完整路径
	 */
	public ExcelReader(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 判断是否是2003Excel文件格式
	 * 
	 * @param filePath
	 *            文件完整路径
	 * @return
	 * @throws IOException
	 */
	public static boolean isExcelFile(String filePath) throws IOException {
		ExcelReader excelReader = new ExcelReader(filePath);
		return excelReader.isExcelFile();
	}

	/**
	 * 判断是否是2003Excel文件格式
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isExcelFile() throws IOException {
		if (filePath == null || filePath.isEmpty()) {
			return false;
		}
		File fExcelFile = new File(filePath);

		// 得到Excel的工作簿对象
		try {
			Workbook.getWorkbook(fExcelFile);
		} catch (BiffException e) {
			return false;
		} catch (IOException e) {
			throw e;
		} finally {
			fExcelFile = null; 
		}
		return true;
	} 

	/**
	 * 设置当前的sheet页	 * 
	 * @param sheetIndex
	 */
	public void setCurrentSheetIndex(int sheetIndex) {
		this.currentSheetIndex = sheetIndex;
	}

	/**
	 * 设置表格中数据的起始行列数	 * 
	 * @param StartRowNum
	 */
	public void setDataStartRowCol(int startRowNum, int startColNum) {
		this.startRowNum = startRowNum;
		this.startColNum = startColNum;
	}

	/**
	 * 设置能够获取的最大行数	 * 
	 * 该行数不包括的由startRowNum指定的行数。也即实际的数据行数。	 * 
	 * @param maxRows
	 */
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	/**
	 * 设置能够获取的最大列数
	 * 
	 * 该列数不包括的由startColNum指定的列数。也即实际的数据列数。
	 * 
	 * @param maxRows
	 */
	public void setMaxCols(int maxCols) {
		this.maxCols = maxCols;
	}

	/**
	 * 设置表格的列与Bean对象属性的映射关系
	 * 
	 * @param colPropMap
	 */
	public void setColPropMap(HashMap<String, String> colPropMap) {

		this.colPropMap = colPropMap;
	}

	/**
	 * 取得表头名
	 * 
	 * @return
	 */
	public HashMap<String, String> getTitleNameMap() {
		return titleNameMap;
	}

	/**
	 * 返回数据表的列数
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public int getColumnsNum() throws BiffException, IOException {

		File fExcelFile = new File(filePath);

		// 得到Excel的工作簿对象
		Workbook wb = Workbook.getWorkbook(fExcelFile);

		// 取第一个工作表对象
		Sheet st = wb.getSheet(this.currentSheetIndex);

		int iColumns = st.getColumns();

		wb.close();

		// 返回列数
		return iColumns;
	}

	/**
	 * 返回数据表的行数
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public int getRowsNum() throws BiffException, IOException {
		File fExcelFile = new File(filePath);

		// 得到Excel的工作簿对象
		Workbook wb = Workbook.getWorkbook(fExcelFile);

		// 取第一个工作表对象
		Sheet st = wb.getSheet(this.currentSheetIndex);

		int iRows = st.getRows();

		wb.close();

		// 返回列数
		return iRows;
	}

	/**
	 * 返回工作表名称
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public String getSheetName() throws BiffException, IOException {

		File fExcelFile = new File(filePath);

		// 得到Excel的工作簿对象
		Workbook wb = Workbook.getWorkbook(fExcelFile);

		// 取第一个工作表对象
		Sheet st = wb.getSheet(this.currentSheetIndex);

		String stName = st.getName();

		wb.close();

		return stName;
	}

	/**
	 * 将Excel表格的每一行数据读入到指定的Bean对象中，并将每行的Bean添加到List中
	 * 
	 * @param c
	 *            Bean的类型
	 * @return
	 */
	public <E> List<E> readData(Class c) throws Exception {

		List listData = new ArrayList();
		File fExcelFile = new File(filePath);
		try {
			// 得到Excel的工作簿对象
			Workbook wb = Workbook.getWorkbook(fExcelFile);

			// 取第一个工作表对象
			Sheet st = wb.getSheet(this.currentSheetIndex);

			// 重新设置表格的列与Bean对象属性的映射关系
			HashMap<String, String> hmTemp = new HashMap<String, String>();

			for (Entry<String, String> entry : colPropMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				//返回 key 对象内第一次出现此字符串的字符位置
				int idx = key.indexOf("-");
				if (idx == -1) {
					hmTemp.put(key, value);
				} else {
					int iStartNum = Integer.parseInt(key.substring(0, idx));

					String strEndNum = key.substring(idx + 1);

					// “?”代表到最后一列
					if (strEndNum != null && strEndNum.equals("?")) {
						strEndNum = String.valueOf(st.getColumns());
					}

					int iEndNum = Integer.parseInt(strEndNum);

					for (int i = 0; i <= iEndNum - iStartNum; i++) {
						hmTemp.put(String.valueOf(iStartNum + i), value + PropertyUtils.INDEXED_DELIM + i + PropertyUtils.INDEXED_DELIM2);
					}
				}
			}
			this.colPropMap = hmTemp;

			// 得到所有合并单元格
			HashMap<String, String> hmRange = new HashMap<String, String>();
			Range[] ranges = st.getMergedCells();
			for (Range range : ranges) {
				int iTLRow = range.getTopLeft().getRow();
				int iTLColumn = range.getTopLeft().getColumn();
				int iBRRow = range.getBottomRight().getRow();
				int iBRColumn = range.getBottomRight().getColumn();

				// 将合并单元格的跨度坐标放入HashMap
				hmRange.put(iTLRow + "_" + iTLColumn, iBRRow + "_" + iBRColumn);
			}

			titleNameMap = new HashMap<String, String>();

			// 从数据的起始行开始，循环数据
			int iMaxRows = -1;
			if (maxRows == -1 || (maxRows + startRowNum - 1) > st.getRows()) {
				iMaxRows = st.getRows();
			} else {
				iMaxRows = maxRows + startRowNum - 1;
			}
			// 因为每一行的列表可能不相同，所以需要有一个变量保持每一行的最大列数。

			int iMaxCols = -1;
			for (int i = startRowNum; i <= iMaxRows; i++) {

				// 得到一行的所有单元格
				Cell[] cells = st.getRow(i - 1);

				if (cells.length == 0) {
					break;
				}

				// 实例化一个指定的对象
				Object bean = c.newInstance();

				// 循环一行的单元格
				if (maxCols == -1 || (maxCols + startColNum - 1) > cells.length) {
					iMaxCols = cells.length;
				} else {
					iMaxCols = maxCols + startColNum - 1;
				}
				for (int k = startColNum - 1, j = 0; k < iMaxCols; j++) {

					Cell cell = cells[k];

					int iRow = cell.getRow();
					int iColumn = cell.getColumn();

					// 判断是否合并过的单元格，如果是合并的单元格，则跳过合并的范围
					if (hmRange.containsKey(iRow + "_" + iColumn)) {
						String strBottomRight = hmRange.get(iRow + "_" + iColumn);
						int idx = strBottomRight.indexOf("_");
						int iBRColumn = Integer.parseInt(strBottomRight.substring(idx + 1));

						k += iBRColumn - (iColumn - 1);
					} else {
						k++;
					}

					// 取得单元格的值
					String strValue = cell.getContents();

					// 取得该列对应的Bean属性
					String strProperty = colPropMap.get(String.valueOf(j + 1));

					// 取得该属性的类型
					// Class propClass = PropertyUtils.getPropertyType(bean, strProperty);
					//					
					// 将字符串动态转换成相应的数据类型
					// Object objValue = ConstructorUtils.invokeConstructor(propClass, new Object[]{strValue}, new Class[]{String.class});

					if (strProperty != null && !strProperty.equals("")) {
						// 将单元格的值设置到对应的属性delAllSpace
						//BeanUtils.setProperty(bean, strProperty, Util.delSpace(strValue, false));
						BeanUtils.setProperty(bean, strProperty, StringUtil.deleteSpace(strValue, false));
						// BeanUtils.setProperty(bean, strProperty, objValue);
					}

					// 读取各表头名称
					if (i == startRowNum) {
						Cell cellTitle = st.getCell(iColumn, iRow - 1);

						// 取得表头名称
						String strTitleName = cellTitle.getContents();
						titleNameMap.put(String.valueOf(j + 1), strTitleName);
					}
				}

				// 将Bean对象添加到List对象
				listData.add(bean);
			}

			wb.close();
		} catch (BiffException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (InstantiationException e) {
			throw e;
		} catch (IllegalAccessException e) {
			throw e;
		} catch (InvocationTargetException e) {
			throw e;
		}
		return listData;
	}

	/**
	 * 将Excel表格中的每一行数据读入到List中。并将每行List添加到大的List中。
	 * 
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List readData() throws Exception {
		List listData = new ArrayList();
		File fExcelFile = new File(filePath);
		try {
			// 得到Excel的工作簿对象
			Workbook wb = Workbook.getWorkbook(fExcelFile);

			// 取第一个工作表对象
			Sheet st = wb.getSheet(this.currentSheetIndex);

			// 得到所有合并单元格
			HashMap<String, String> hmRange = new HashMap<String, String>();
			Range[] ranges = st.getMergedCells();
			for (Range range : ranges) {
				int iTLRow = range.getTopLeft().getRow();
				int iTLColumn = range.getTopLeft().getColumn();
				int iBRRow = range.getBottomRight().getRow();
				int iBRColumn = range.getBottomRight().getColumn();

				// 将合并单元格的跨度坐标放入HashMap
				hmRange.put(iTLRow + "_" + iTLColumn, iBRRow + "_" + iBRColumn);
			}

			// 从数据的起始行开始，循环数据
			int iMaxRows = -1;
			int iMaxCols = -1;
			if (maxRows == -1 || (maxRows + startRowNum - 1) > st.getRows()) {
				iMaxRows = st.getRows();
			} else {
				iMaxRows = maxRows + startRowNum - 1;
			}
			// 因为每一行的列表可能不相同，所以需要有一个变量保持每一行的最大列数。

			for (int i = startRowNum; i <= iMaxRows; i++) {
				List listRow = new ArrayList();
				// 得到一行的所有单元格
				Cell[] cells = st.getRow(i - 1);
				/*获取日期类型单元格*/
				DateCell[] dateCells = null;
				
				if (cells.length == 0) {
					break;
				}

				// 循环一行的单元格
				if (maxCols == -1 || (maxCols + startColNum - 1) > cells.length) {
					iMaxCols = cells.length;
				} else {
					iMaxCols = maxCols + startColNum - 1;
				}

				String tempRowValues = "";
				for (int k = startColNum - 1, j = 0; k < iMaxCols; j++) {

					Cell cell = cells[k];

					int iRow = cell.getRow();
					int iColumn = cell.getColumn();

					// 判断是否合并过的单元格，如果是合并的单元格，则跳过合并的范围
					if (hmRange.containsKey(iRow + "_" + iColumn)) {
						String strBottomRight = hmRange.get(iRow + "_" + iColumn);
						int idx = strBottomRight.indexOf("_");
						int iBRColumn = Integer.parseInt(strBottomRight.substring(idx + 1));

						k += iBRColumn - (iColumn - 1);
					} else {
						k++;
					}

					// 取得单元格的值
					String strValue = cell.getContents();					if(cell.getType() == CellType.DATE){
						//DateCell dateCell = (DateCell) cells[k];
						Date dateTemp = ((DateCell)cell).getDate();
						int hourTemp = ((DateCell)cell).getDate().getHours();
						if(hourTemp < 8){
							hourTemp = hourTemp + 24 - 8;
						} else {
							hourTemp = hourTemp - 8;
						}
						int minuteTemp = ((DateCell)cell).getDate().getMinutes();
						String temp = DateUtil.dateFormat(dateTemp, "yyyy-MM-dd");
						strValue = temp + " " + hourTemp + ":" + minuteTemp;
					} 
					listRow.add(strValue);

					tempRowValues += strValue;
				}

				// 将Bean对象添加到List对象

				/*if (!Util.isNull(Util.delAllSpace(tempRowValues, true))) {
					listData.add(listRow);
				}*/
				if (!StringUtil.isAnyNullOrEmpty(StringUtil.delAllSpace(tempRowValues, true))) {
					listData.add(listRow);
				}
			}
			wb.close();
		} catch (BiffException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return listData;
	}

	/**
	 * <p>
	 * 获取标题名称
	 * <p>
	 * 
	 * @author meng
	 */
	@SuppressWarnings("unchecked")
	public List getTitleName() throws Exception {
		List titleName = new ArrayList();
		File fExcelFile = new File(filePath);
		try {
			// 得到Excel的工作簿对象
			Workbook wb = Workbook.getWorkbook(fExcelFile);

			// 取第一个工作表对象
			Sheet st = wb.getSheet(this.currentSheetIndex);

			// 得到第一行的所有单元格
			Cell[] cells = st.getRow(0);
			for (int i = this.startColNum - 1; i < cells.length; i++) {
				titleName.add(cells[i].getContents());
			}
			wb.close();
		} catch (BiffException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return titleName;
	}
}
