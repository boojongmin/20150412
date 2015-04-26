package com.school.bankspring.step01;

public class MainFactory {
	
	public static void main(String[] args) {
		MagicianFactory factory = new MagicianFactory();
		
		Magician magician1 = factory.getMagician(FireBallBullet.class);
		Magician magician2 = factory.getMagician(IceStormBullet.class);
		Magician magician3 = factory.getMagician(LightningBallBullet.class);
		
		magician1.magic();
		magician2.magic();
		magician3.magic();
	}

}
