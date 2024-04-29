package stringmethods;

import java.util.ArrayList;

public class StringUtility {
	public static void main(String[] args) {
		// ここを行う前にReadWriteObjectsクラスの演習をトライしてください
		// 演習２：Userクラスを定義してくださいid, 名前，メールアドレスを管理できるようにします。
		//   getter, setter, toStringも忘れずに！
		
		// 演習３：users.txtから読み込んだデータをStringクラスの便利メソッド（３．４は他のクラスを利用）
		//    で加工してください。
		// 上手くできたら、最終的にユーザデータが表示されるはずです。
		ArrayList<User> userList = new ArrayList<User>();
		
		// ファイル処理
		SimpleFileReader fileReader = new SimpleFileReader();
		
		// 引数にファイルの場所を指定する。
		// このメソッド内でファイルを開き、読み込みを行う。例外が発生するとすればここが怪しい
		fileReader.readTextFile("users.txt");
		
		// すでにこの時点で読み込みは終了。読み込んだデータをgetterで取得する
		ArrayList<String> lines = fileReader.getLines();
		
		for (String line : lines) {
			// ここで読み込んだファイルを処理
			// 演習３．１：ユーザ一人分のデータを各データ種別に分ける(splitメソッドなどが便利）
			String[] userData = line.split(",");
			// 配列の中に十分な要素数があることを確かめる。
			if (userData.length >= 4) {
				// String型配列から各要素を取り出し、変数を宣言してそれに格納
				// でもどのデータもそのままでは使えない
				// IDデータ：スペースが前後に入っていたら、int型に変換できない
				String rawid = userData[0];
				// 名前データ：スペースが前後に入っていたり、"が混ざっていると良くない
				String rawName = userData[1];
				// 年齢データ：スペースが前後に入っていたら、int型に変換できない
				String rawage = userData[2];
				
				// 演習３．２：名前には"が入ってしまっている。"を除去（例：replaceメソッド？）
				String nameWithoutQuotes = rawName.replace('\"', ' ');
				
				// 演習３．３：更に名前には余分なスペースが入っているひともあり。左右のスペースは取り除いておく（trimメソッド？）
				String name = nameWithoutQuotes.trim();
				
				// 演習３．４：年齢データは取れるがint型ではなくString型になっている。これをint型に変換
				// ここでもtrimを使うと例外を回避できて便利
				int id = Integer.parseInt(rawid.trim());
				int age = Integer.parseInt(rawage.trim());
				
				// 演習３．５：メールアドレスデータも取得する
				String email = userData[3].replace('\"', ' ').trim();
				
				// 演習３．６：Userクラスのオブジェクトに上記で取得＋加工したデータをnewして、userListにadd
				// コンストラクタをオーバーロードするか、setterを使うかはお任せ。
				User user = new User(id, name, age, email);
				// userListに追加
				userList.add(user);
			}
			else {
				System.out.println("データが読み込めませんでした: "+line);
			}
		}

		// 読み込んだユーザーを表示させる
		System.out.println("読み込んだユーザー一覧---START");
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("読み込んだユーザー一覧---END");
		
		// ワンモアマイル：さて、UserクラスにはcreationDateというメンバ変数が定義されていました。
		//   このcreationDate変数の内容を見やすい形で他の項目と一緒に表示できるようにしてください。
		
		// ワンモアマイル２：こちらはStringクラスで公開されているメソッド一覧です
		// https://docs.oracle.com/javase/jp/21/docs/api/java.base/java/lang/String.html#method-summary
		// このうちまだ使用していないメソッドを選び、サンプルコードを書いてみてください。
		// たくさんメソッドがありますので１つだけではなく複数試してみてください
	}
}
