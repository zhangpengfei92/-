package com.jcl.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.jcl.util.DbProperties;
import com.jcl.util.DeployProperties;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

@SuppressWarnings("deprecation")
public class MongoUtils {

	private static DB database;

	private static DBCollection collection;
	/*MONGODB HOST、PORT*/
	
	private static final String MONGODB_HOST = DbProperties.getInstance().getMongodbIp();
	private static final int MONGODB_PORT =  DbProperties.getInstance().getMongodbPort();
	/*DB*/
	private static final String MONGODB_DATASTORE = DbProperties.getInstance().getMongodbDataStore();
	static {
		Mongo mongo = null;
		try {
			mongo = new Mongo(MONGODB_HOST, MONGODB_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		database = mongo.getDB(MONGODB_DATASTORE);

	}

	/**
	 * 切换到那个集合
	 * 
	 * @param col
	 */
	public static DBCollection change(String col) {
		collection = !database.collectionExists(col) ? database
				.createCollection(col, new BasicDBObject())
				: database.getCollection(col);	
		//collection = database.getCollection(col);
				System.out.println("切换集合成功");
		return collection;
	}
	



	
	/**
	 * 无条件分页查询
	 * 
	 * @param page
	 * @param limit
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static DBCursor queryPage(Integer page, Integer limit) throws Exception {
		
		DBCursor cursor = collection.find().skip(page).limit(limit);
		
		System.out.println("无条件分页查询成功");
		
		return cursor;
	}

	/**
	 * 条件查询分页
	 * 
	 * @param page--当前页的初始记录数
	 * @param limit--每页显示的记录数
	 * @param t
	 * @param documents
	 * @return
	 * @throws Exception
	 */
	public static DBCursor queryPageByExample(Integer page, Integer limit, DBObject documents) throws Exception {
		DBCursor cursor=null;
		if(page==null&&limit==null) {
		cursor = collection.find(documents);
		}else {
			
	    cursor = collection.find(documents).skip(page).limit(limit);
		}
		
		System.out.println("条件分页查询成功");
		return cursor;
	}
	//分页条件排序查询
	public static DBCursor queryPageByExampleSort(Integer page, Integer limit, DBObject documents,DBObject sortdoc) {
		DBCursor cursor=null;
		if(page==null&&limit==null) {
			cursor = collection.find(documents).sort(sortdoc);
			}else {
				
		    cursor = collection.find(documents).sort(sortdoc).skip(page).limit(limit);
			}
			

			return cursor;
	}
	
	/**
	 * 查询全部数据
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static  DBCursor queryList() throws Exception {
		
		System.out.println("查询所有成功");
		
		return collection.find();
		
	}

	public static DBCursor queryByDBObject(DBObject documents) {
		return collection.find(documents);
	}
	
	public static void deleteDB(DBObject documents) {
		collection.remove(documents);
	}
	/**
	 * 插入一条数据
	 * 
	 * @param documents
	 */
	public static void addOne(DBObject documents) {

		collection.insert(documents);
		System.out.println("插入一条数据成功");
	}
	
	//查询总条数
	public static Long count(DBObject documents) {
		System.out.println("查询总条数成功");
		return collection.count(documents);
	}

}
