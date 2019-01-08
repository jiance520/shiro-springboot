package cn.sm1234.test;

import cn.sm1234.ShiroApplication;
import cn.sm1234.dao.UserMapper;
import cn.sm1234.domain.User;

import javax.annotation.Resource;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//加载启动器类
@SpringBootTest(classes=ShiroApplication.class)
public class UserMapperTest {
	@Resource
	public UserMapper userMapper;
	@Test
	public void testFindByName() {
		User user = userMapper.findByName("eric");
		System.out.println(user);
	}
	@Test
	public void testUpdatePassword() {
		User user = new User();
		user.setId(1);
//		传统MD5在mysql中的值：select MD5("1234");
//		使用shiro的加密工具进行加密,与传统的MD5加密值有区别，source要加密的内容，salt盐，就是加密的修饰(可以根用户名变，也可以是定值)，hashIterations加密次数。
//		Md5Hash md5hash = new Md5Hash(source, salt, hashIterations);
		Md5Hash hash = new Md5Hash("1234", "eric", 2);
		user.setPassword(hash.toString());
		userMapper.updatePassword(user);
		System.out.println(user);
	}
}
