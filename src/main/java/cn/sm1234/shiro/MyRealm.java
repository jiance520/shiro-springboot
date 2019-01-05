package cn.sm1234.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.sm1234.domain.User;

public class MyRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addStringPermission("product:add");
		return null;
	}
// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证...");
		//模拟数据库数据
		String name = "jack";
		String password = "1234";
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		
		if(!name.equals(token.getUsername())) {
			return null;//login会抛出UnknownAccountException异常。
		}
/*		User dbUser = userService.findByName(token.getUsername());//查询的数据库对象。
		if(dbUser==null) {
			return null;//用户名不存在
		}*/
		User dbUser = new User();
		dbUser.setName(name);
		dbUser.setPassword(password);
		//第一、二个参数可以自己指定返回值。
		return new SimpleAuthenticationInfo(dbUser, dbUser.getPassword(), "");
	}

}
