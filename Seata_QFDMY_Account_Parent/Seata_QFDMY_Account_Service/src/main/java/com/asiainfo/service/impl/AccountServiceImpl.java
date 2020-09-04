package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import com.asiainfo.entity.Account;
import com.asiainfo.mapper.AccountMapper;
import com.asiainfo.service.api.IAccountService;

@DubboService
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountMapper;

	public int insertAccount(Account account) {
//		int i = 1 / 0;
		return accountMapper.insertAccount(account);
	}
}