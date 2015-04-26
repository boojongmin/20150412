package com.school.bankspring.step01;

public class IceStormBullet implements MagicSystem {

	@Override
	public void magic() {
		System.out.println("아이스스톰 발사!!!");
	}

	@Override
	public String showMasicName() {
		return "아이스스톰";
	}

}
