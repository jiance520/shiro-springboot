package cn.sm1234.test;

import cn.sm1234.ShiroApplication;
import cn.sm1234.dao.UserMapper;
import cn.sm1234.domain.User;

import javax.annotation.Resource;
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
}
