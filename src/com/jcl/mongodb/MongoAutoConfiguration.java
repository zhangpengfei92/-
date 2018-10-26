package com.jcl.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcl.util.DbProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
public class MongoAutoConfiguration {

	private Morphia morphiaForStock;
	private Datastore dsForStock;

	private MongoClient mongoClient;
	
	
	private static final String MONGODB_HOST = DbProperties.getInstance().getMongodbIp();
	private static final int MONGODB_PORT =  DbProperties.getInstance().getMongodbPort();
	/*DB*/
	private static final String MONGODB_DATASTORE = DbProperties.getInstance().getMongodbDataStore();

	@PreDestroy
	public void close() {
		if (null != mongoClient)
			mongoClient.close();
	}

	@Bean(name = "mongoClient", destroyMethod = "close")
	public MongoClient mongo() throws UnknownHostException {
		ServerAddress server=new ServerAddress(MONGODB_HOST, MONGODB_PORT);
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		seeds.add(server);
		MongoClientOptions.Builder builder = MongoClientOptions.builder();
		builder.socketKeepAlive(true);
		builder.socketTimeout(2000);
		builder.maxWaitTime(2000);
		builder.heartbeatFrequency(2000);// 心跳频率

		mongoClient = new MongoClient(seeds);
		// this.mongo.setReadPreference(ReadPreference.);

		return mongoClient;

	}
	
	@Bean(name = "morphiaForStock")
	public Morphia morphiaForStock() {
		morphiaForStock = new Morphia();
		//morphiaForStock.map(com.jcl.vo.Comment.class);
		//morphiaForTigase.map(cn.xyz.mianshi.vo.Room.class);
		//morphiaForTigase.map(cn.xyz.mianshi.vo.Room.Member.class);
		//morphiaForTigase.map(cn.xyz.mianshi.vo.Room.Notice.class);

		return morphiaForStock;
	}

	public Datastore dsForRead(MongoClient mongoClient) {
		// MONGODB、只读库实现
		return null;
	}

	public Datastore dsForWrite(MongoClient mongoClient) {
		// MONGODB、只写库实现
		return null;
	}

	@Bean(name = "dsForStock")
	public Datastore dsForStock(MongoClient mongoClient) {
		dsForStock = morphiaForStock().createDatastore(mongoClient, MONGODB_DATASTORE);
		dsForStock.ensureIndexes();
		dsForStock.ensureCaps();

		return dsForStock;
	}
	
}
