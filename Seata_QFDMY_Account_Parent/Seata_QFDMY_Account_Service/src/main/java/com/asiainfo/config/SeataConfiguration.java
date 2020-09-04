package com.asiainfo.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;

/**
 * Seata需要代理数据源才能使TC通知到RM进行提交或者回滚
 *
 * @author zhangzhiwang
 * @date Sep 4, 2020 11:13:48 PM
 */
@Configuration
public class SeataConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")// @ConfigurationProperties作用在方法上有两个条件（该注解的官方注释有说明）：一个是该方法必须标注@Bean注解，另一个是该方法所在类必须有@Configuration注解。
	// @ConfigurationProperties写在方法上的作用就是给返回的对象（bean）属性赋值，值的来源在配置文件
	public DataSource hikariDataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		return hikariDataSource;
	}
	
	@Bean
	@Primary// @Primary注解的意思是当按类型注入bean时，发现Spring容器中有多个相同类型（class）的bean，到底注入哪个呢？如果某一个bean标注了@Primary，那么优先注入改bean
	public DataSourceProxy dataSource(DataSource hikariDataSource) {// DataSourceProxy是io.seata.rm.datasource包下的，意味着只有seata对数据源进行代理才能使TC通知到RM进行提交或者回滚
		return new DataSourceProxy(hikariDataSource);
	}
	
//	@Bean
//	public GlobalTransactionScanner globalTransactionScanner() {
//		return new GlobalTransactionScanner("Seata-QFDMY-User-Service", "zzw_seata_group");
//	}
}
