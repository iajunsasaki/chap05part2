package experiment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadWriteObjects {

	public static void main(String[] args) {
		// 演習０：ReadWriteObjectsクラスのコードにコメントを付けてみてください
		
		// 演習１：このプログラムはJavaのオブジェクトをファイルに書き込むものです。
		//   でも例外が出てしまいます。例外が出ずにObjectのデータがファイル出力されるように
		//   修正してください。
		
		// 車２台分のデータ（CarとPrius）の情報をファイルに書き込む
		writeTwoCarsToFile("twocars.obj", new Car(), new Prius());
		
		// 先ほどファイルに書き込んだデータをJavaのオブジェクトに作り直す
		readTwoCarsToFile("twocars.obj");
		
		// 演習１のワンモアマイル：CarクラスやPriusクラスに変数やメソッドを定義して、ファイルに書き込んでください。
		//   他のクラスも定義して読み書きしてみてください。
		
		// 演習２以降はStringUtilityクラスへ！
	}
	
	public static void writeTwoCarsToFile(String path, Car firstCar, Car secondCar) {
		try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(path))) {
			objectStream.writeObject(firstCar);
			objectStream.writeObject(secondCar);
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void readTwoCarsToFile(String path) {
		try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(path))) {
			Car first = (Car)objectStream.readObject();
			Car second = (Car)objectStream.readObject();
			
			System.out.println("読み込み１台目:"+first);
			System.out.println("読み込み２台目:"+second);
		}
		catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
