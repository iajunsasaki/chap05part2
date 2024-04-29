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
		
		// 演習１のワンモアマイル：CarクラスやPriusクラスに変数やメソッドを定義して、ファイルに書き込んでください。
		//   他のクラスも定義して読み書きしてみてください。
		Car firstCar = new Car();
		firstCar.setMake("Honda");
		firstCar.setMilage(20000);
		
		// Priusのコンストラクタの中ではメーカー情報が自動的に設定される
		Car secondCar = new Prius();
		secondCar.setMilage(50000);
		
		// 車２台分のデータ（CarとPrius）の情報をファイルに書き込む
		writeTwoCarsToFile("twocars.obj", firstCar, secondCar);
		
		// 先ほどファイルに書き込んだデータをJavaのオブジェクトに作り直す
		readTwoCarsToFile("twocars.obj");

		// 演習２以降はStringUtilityクラスへ！
	}
	
	public static void writeTwoCarsToFile(String path, Car firstCar, Car secondCar) {
		// Javaのクラスにはそれぞれ「役割」があります。「役割」を意識すると覚えやすく、コードが読みやすくなる
		// ObjectOutputStreamはオブジェクトをどこかに出力するクラス。
		// FileOutputStreamはファイルに書き込むために使用するクラス。
		try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(path))) {
			objectStream.writeObject(firstCar);
			objectStream.writeObject(secondCar);
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void readTwoCarsToFile(String path) {
		// Javaのクラスにはそれぞれ「役割」があります。「役割」を意識すると覚えやすく、コードが読みやすくなる
		// ObjectInputStreamはオブジェクトをどこかから読み出すクラス。
		// FileInputStreamはファイルから読み出すために使用するクラス。
		try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(path))) {
			// 一台目を読みだす
			Car first = (Car)objectStream.readObject();
			// 二台目を読みだす
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
