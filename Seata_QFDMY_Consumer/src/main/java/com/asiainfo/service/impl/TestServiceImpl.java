package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.entity.Account;
import com.asiainfo.entity.User;
import com.asiainfo.service.ITestService;
import com.asiainfo.service.api.IAccountService;
import com.asiainfo.service.api.IUserService;

import io.seata.spring.annotation.GlobalTransactional;

@Service
//@Transactional// 是本地事务，不能跨进程
@GlobalTransactional// 作为TM角色，@GlobalTransactional注解要放在TM角色的方法上
public class TestServiceImpl implements ITestService {
	@DubboReference
	private IUserService userService;
	@DubboReference
	private IAccountService accountService;

	@Override
	public void test() {
		User user = new User();
		user.setUserName("zhangsan");
		user.setUserAddress("Beijing");
		userService.insertUser(user);
		
		System.out.println("do sth. else...");
		
		Account account = new Account();
		account.setUserId(1);
		account.setAccountLast(100);
		accountService.insertAccount(account);
		int i = 1 / 0;
	}

}
