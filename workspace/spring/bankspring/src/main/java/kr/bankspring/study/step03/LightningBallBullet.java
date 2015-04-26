package kr.bankspring.study.step03;

public class LightningBallBullet implements MagicSystem {
  
  @Override
  public void magic() {
    System.out.println("라이트닝 발사!!!");
  }

  @Override
  public String showMasicName() {
    return "라이트닝";
  }

}
