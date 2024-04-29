package stringmethods;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ユーザークラス。
 */
public class User implements Serializable {
	/**
	 * コンストラクタ。
	 * @param id ユーザID
	 * @param name ユーザ名
	 * @param age 年齢
	 * @param email メールアドレス
	 */
	public User(int id, String name, int age, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	/** ID */
	private int id;

	/** 名前 */
	private String name;
	
	/** 年齢 */
	private int age;

	/** メールアドレス */
	private String email;
	
	// newされた日時
	private Date creationDate = new Date();

	@Override
	public String toString() {
		// Dateオブジェクトを文字列に変換するためにはSimpleDateFormatクラスが便利
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return "ユーザ id[" + this.id + "] 名前[" + this.name + "] 年齢[" + this.age + "] email[" + this.email + "] データ生成日[" + format.format(this.creationDate) + "]";
	}
}
