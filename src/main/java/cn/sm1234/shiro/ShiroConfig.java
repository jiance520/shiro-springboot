package cn.sm1234.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//shiro配置类，由于不能在xml里配置，只能在类里面配置
@Configuration
public class ShiroConfig {
//	ShrioFilterFactory
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//		关联SecurityManager
		bean.setSecurityManager(securityManager);
		Map<String,String> filterMap = new LinkedHashMap();
//		认证过滤器
		filterMap.put("/**", "authc");
//		添加shiro过滤器
		bean.setFilterChainDefinitionMap(filterMap);
		return bean;
	}
//	创建SecurityManager
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myrealm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//		关联MyRealm
		manager.setRealm(myrealm);
		return manager;
	}
//	创建MyRealm
	@Bean
	public MyRealm myrealm() {
		MyRealm myrealm= new MyRealm();
		return myrealm;
	}
}
