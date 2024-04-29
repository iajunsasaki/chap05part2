package stringmethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 簡易なファイルデータ読み込みクラス
 */
public class SimpleFileReader {
	/** 読み込んだデータ */
	private ArrayList<String> lines = new ArrayList<>();

	/**
	 * ファイルを開き、読み込む。
	 * @param path ファイルの場所
	 */
	public void readTextFile(String path) {
		// Javaのクラスにはそれぞれ「役割」があります。「役割」を意識すると
		// BufferedReaderはテキストを効率的に読み込むために使用するクラス。
		// FileReaderはファイルを読み込むために使用するクラス。
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
			String line = bufferedReader.readLine();
			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
			}
		}
		catch (Exception exception) {
			// ファイルを読み込む時、
			// 例外が発生した場所を表示
			exception.printStackTrace();
			// 通常例外処理は必要。今回失敗した場合データをクリアしてみる
			lines.clear();
		}
	}

	/**
	 * ファイルから読み込んだデータを取得する。
	 * @return 読み込んだデータ
	 */
	public ArrayList<String> getLines() {
		return this.lines;
	}

	/**
	 * クラスで読み込んだファイル内のデータを書き出す
	 * @param path 書き出すファイル名
	 */
	public void writeTextFile(String path) {
		// ワンモアマイル。中身を書いてください
		// Javaのクラスにはそれぞれ「役割」があります。「役割」を意識すると
		// BufferedWriterはテキストを効率的に読み込むために使用するクラス。
		// FileWriterはファイルを読み込むために使用するクラス。
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
			for (String line : this.lines) {
				// 一行分のデータをファイルに書き出す
				bufferedWriter.write(line);
				// 改行コードは明示的に書くことを命令
				bufferedWriter.newLine();
			}
		}
		catch (Exception exception) {
			// 例外が発生した場所を表示
			exception.printStackTrace();
		}
	}
}
