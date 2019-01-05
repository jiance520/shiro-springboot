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
//		认证过滤器,不是在shiro.ini里配置
		filterMap.put("/product/toAdd", "anon");
//		放行登陆页面
		filterMap.put("/user/login", "anon");
//		授权过滤器
		filterMap.put("/product/toAdd", "perms[product:add]");
		filterMap.put("/product/toUpdate", "perms[product:update]");
		filterMap.put("/**", "authc");//一定要放在filterMap.put("/product/toUpdate", "perms[product:update]")之后！重点。否则授权过滤无效！
//		添加shiro过滤器
		bean.setFilterChainDefinitionMap(filterMap);
//		修改登陆请求
		bean.setLoginUrl("/toLogin");
//		未授权提示页面
		bean.setUnauthorizedUrl("/unAuth");
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
