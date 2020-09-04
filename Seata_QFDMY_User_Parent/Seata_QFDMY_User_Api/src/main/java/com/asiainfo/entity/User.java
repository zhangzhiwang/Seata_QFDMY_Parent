package com.asiainfo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	private int userId;
	private String userName;
	private String userAddress;
}
