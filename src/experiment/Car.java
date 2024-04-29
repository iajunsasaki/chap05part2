package experiment;

import java.io.Serializable;

/**
 * 車クラス。Serializableを実装することで、ファイルなどへのデータ書き出しが可能に。
 */
public class Car implements Serializable {
	
	@Override
	public String toString() {
		return "これは車です！";
	}
}
