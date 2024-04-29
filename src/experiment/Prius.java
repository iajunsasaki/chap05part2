package experiment;

/**
 * プリウスクラス。
 */
public class Prius extends Car {
	/**
	 * コンストラクタ
	 */
	public Prius() {
		this.setMake("Toyota");
	}
	
	@Override
	public String toString() {
		String displayMake = this.getMake() == null ? "" : "メーカー[" + this.getMake() + "] ";
		return "これはプリウスです！ " + displayMake + "走行距離[" + this.getMilage() + "]km";
	}
}
