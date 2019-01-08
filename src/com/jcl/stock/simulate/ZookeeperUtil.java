package com.jcl.stock.simulate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.jcl.stock.common.DeployProperties;
import com.jcl.stock.queue.WorkThread;

/**
* ZooKeeper 使用
*/
public class ZookeeperUtil implements Watcher {

	private static Logger logger = Logger.getLogger(ZookeeperUtil.class);
			
    private final static String ZK_PATH = DeployProperties.getInstance().getZookeeperAddress();
    //private final static ZookeeperUtil zookeeperUtil = new ZookeeperUtil();
     
    private ZooKeeper zk = null;
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private final WorkThread worker; 
    
    public ZookeeperUtil(WorkThread worker){
    	this.worker = worker;
    }
    
    /**
     * 创建ZK连接
     * @param connectString  ZK服务器地址列表
     * @param sessionTimeout   Session超时时间
     */
    public void createConnection( String connectString, int sessionTimeout ) {
        this.releaseConnection();
        try {
            zk = new ZooKeeper( connectString, sessionTimeout, this );
            connectedSemaphore.await();
        } catch ( InterruptedException e ) {
            logger.error("连接创建失败，发生 InterruptedException" );
            e.printStackTrace();
        } catch ( IOException e ) {
            logger.error("连接创建失败，发生 IOException" );
            e.printStackTrace();
        }
    }

    /**
     * 关闭ZK连接
     */
    public void releaseConnection() {
        if (zk != null) {
            try {
                zk.close();
            } catch ( InterruptedException e ) {
                // ignore
                e.printStackTrace();
            }
        }
    }

    /**
     *  创建节点
     * @param path 节点path
     * @param data 初始数据内容
     * @return
     */
    public boolean createPath( String path, String data ) {
        try {
            logger.error("节点创建成功, Path: "
                    + zk.create( path, //
                                              data.getBytes(), //
                                              Ids.OPEN_ACL_UNSAFE, //
                                              CreateMode.EPHEMERAL )
                    + ", content: " + data );
        } catch ( KeeperException e ) {
            logger.error("节点创建失败，发生KeeperException" );
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            logger.error("节点创建失败，发生 InterruptedException" );
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 读取指定节点数据内容
     * @param path 节点path
     * @return
     */
    public String readData() {
        try {
            //logger.error("获取数据成功，path：" + path );
            return new String( zk.getData(ZK_PATH, false, null ) );
        } catch ( KeeperException e ) {
            //logger.error("读取数据失败，发生KeeperException，path: " + path  );
            logger.error("读取数据失败，发生KeeperException，path: " + ZK_PATH);
            return "";
        } catch ( InterruptedException e ) {
            //logger.error("读取数据失败，发生 InterruptedException，path: " + path  );
        	logger.error("读取数据失败，发生 InterruptedException，path: " + ZK_PATH);
            return "";
        }
    }
    
    /**
     * 读取指定节点数据内容集合
     * @param path 节点path
     * @return
     */
    public ArrayList<String> readListData(String path ) {
        try {
        	ArrayList<String> list = new ArrayList<String>();
        	List<String> nodeList = zk.getChildren(path, true);
        	String str = "";
        	for (String node : nodeList) {  
	            str = new String(zk.getData(path + "/" + node, false, null));
	            list.add(str);
        	}
            return list;
        } catch ( KeeperException e ) {
            logger.error( "读取数据失败，发生KeeperException，path: " + path  );
            return null;
        } catch ( InterruptedException e ) {
        	logger.error( "读取数据失败，发生 InterruptedException，path: " + path  );
            return null;
        }
    }

    /**
     * 更新指定节点数据内容
     * @param path 节点path
     * @param data  数据内容
     * @return
     */
    public boolean writeData( String path, String data ) {
        try {
            logger.error("更新数据成功，path：" + path + ", stat: " + zk.setData( path, data.getBytes(), -1 ) );
        } catch ( KeeperException e ) {
            logger.error("更新数据失败，发生KeeperException，path: " + path  );
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            logger.error("更新数据失败，发生 InterruptedException，path: " + path  );
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除指定节点
     * @param path 节点path
     */
    public void deleteNode( String path ) {
        try {
            zk.delete(path, -1);
            //logger.error("删除节点成功，path：" + path );
        } catch ( KeeperException e ) {
            logger.error("删除节点失败，发生KeeperException，path: " + path  );
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            logger.error("删除节点失败，发生 InterruptedException，path: " + path  );
            e.printStackTrace();
        }
    }

    /**
     * 收到来自Server的Watcher通知后的处理。
     */
    @Override
    public void process( WatchedEvent event ) {
        //logger.error("收到事件通知：" + event.getState() +"\n"  );
    	logger.info("收到事件通知：" + event.getState() +"\n");
    	//ProcessThread.serverList = readListData(ZK_PATH);
    	if (Watcher.Event.EventType.NodeChildrenChanged == event.getType() ) {
    		worker.setAddress(readListData(ZK_PATH));
    	}
        if (KeeperState.SyncConnected == event.getState() ) {
            connectedSemaphore.countDown();
        }
    } 
	    
}