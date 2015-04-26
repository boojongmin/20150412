package kr.bankspring.study.step01;

public class Main {

	public static void main(String[] args) {
		MagicSystem fireBallBullet = new FireBallBullet();
		Magician magician = new Magician(fireBallBullet);	
		
//		FireBallBullet fireBallBullet = new FireBallBullet();		
//		magician.changeMagicSystem(fireBallBullet);
		
		magician.magic();
		
		MagicSystem iceStormBullet = new IceStormBullet();
		magician.changeMagicSystem(iceStormBullet);
		
		magician.magic();
	}

}
