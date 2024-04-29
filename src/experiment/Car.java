package experiment;

import java.io.Serializable;

/**
 * 車クラス。Serializableを実装することで、ファイルなどへのデータ書き出しが可能に。
 */
public class Car implements Serializable {
	/** メーカー */
	private String make;
	
	/** 走行距離。新車であれば0 */
	private int milage = 0;

	/**
	 * メーカーの取得
	 * @return メーカー
	 */
	public String getMake() {
		return make;
	}

	/**
	 * メーカーを設定
	 * @param make メーカー
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * 走行距離を取得
	 * @return この車の走行距離
	 */
	public int getMilage() {
		return milage;
	}

	/**
	 * 走行距離を設定
	 * @param milage 新しい走行距離
	 */
	public void setMilage(int milage) {
		this.milage = milage;
	}

	@Override
	public String toString() {
		String displayMake = this.getMake() == null ? "" : "メーカー[" + this.getMake() + "] ";
		return "これは車です！ " + displayMake + "走行距離[" + this.getMilage() + "]km";
	}
}
