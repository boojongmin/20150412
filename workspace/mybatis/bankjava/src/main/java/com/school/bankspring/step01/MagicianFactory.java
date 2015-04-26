package com.school.bankspring.step01;

public class MagicianFactory {
	final String fireBall = FireBallBullet.class.getName();
	public Magician getMagician(Class magicSystemName){
		MagicSystem magicSystem ;
		
		String typeName = magicSystemName.getName();
		if(typeName.equals(FireBallBullet.class.getName())){
			magicSystem = new FireBallBullet();
		}else if(typeName.equals(IceStormBullet.class.getName())){
			magicSystem = new IceStormBullet();
		}else if(typeName.equals(LightningBallBullet.class.getName())){
			magicSystem = new LightningBallBullet();
		}else{
			magicSystem = null;
		}
		
		Magician magician = new Magician(magicSystem);
		return magician;
	}

}
