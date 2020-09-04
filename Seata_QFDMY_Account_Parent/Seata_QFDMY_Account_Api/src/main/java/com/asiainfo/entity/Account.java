package com.asiainfo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {
	private int accountId;
	private int userId;
	private int accountLast;
}
