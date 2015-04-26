package kr.bankspring.study.step01;

public class Magician {
	
	public Magician(MagicSystem magicSystem){
		this.magicSystem = magicSystem;
	}
	
	private MagicSystem magicSystem;
	
	public void magic(){
//		System.out.println("파이어볼 발사!!!");
		magicSystem.magic();
	}
	
	public void changeMagicSystem(MagicSystem magicSystem){		
		this.magicSystem = magicSystem;
	}

}
