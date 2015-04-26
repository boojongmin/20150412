package kr.bankspring.study.step03;

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
	
	public void birth(){
	  System.out.println(magicSystem.showMasicName() + ": 응애~");
	}
	
	public void die(){
	  System.out.println(magicSystem.showMasicName() + " : 으악!");
	}

}
