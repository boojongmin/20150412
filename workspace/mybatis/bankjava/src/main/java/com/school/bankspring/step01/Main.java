package com.school.bankspring.step01;

public class Main {

	public static void main(String[] args) {
		FireBallBullet fireBallBullet = new FireBallBullet();
		Magician magician = new Magician(fireBallBullet);	
		
//		FireBallBullet fireBallBullet = new FireBallBullet();		
//		magician.changeMagicSystem(fireBallBullet);
		
		magician.magic();
		
		IceStormBullet iceStormBullet = new IceStormBullet();
		magician.changeMagicSystem(iceStormBullet);
		
		magician.magic();
	}

}
