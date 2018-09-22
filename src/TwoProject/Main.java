package TwoProject;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int titleNum; // 定义题目个数
		int parameterRange; // 定义参数范围
		while (true) {
			titleNum = -1;
			System.out.println("请输入题目个数指令:");
			InputStream iStream = System.in;
			InputStreamReader inputStreamReader = new InputStreamReader(iStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = bufferedReader.readLine();
			String[] strings = str.split("\\s");
			for (int i = 0; i < strings.length; i++) {
				if (strings[i].equals("-n")) {
					if (i + 1 < strings.length) {
						titleNum = Integer.valueOf(strings[i + 1]);
						// System.out.println(titleNum);
						break;
					} else {
						System.out.println("指令参数没有输入，请重新输入指令。");
						titleNum = -2;
					}
				}
			}
			if (titleNum == -1) {
				System.out.println("指令类型没有输入，请重新输入指令。");
			} else if (titleNum != -2) {
				break;
			}
		}
		while (true) {
			parameterRange = -1;
			System.out.println("请输入参数范围指令:");
			InputStream iStream = System.in;
			InputStreamReader inputStreamReader = new InputStreamReader(iStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = bufferedReader.readLine();
			String[] strings = str.split("\\s");
			for (int i = 0; i < strings.length; i++) {
				if (strings[i].equals("-r")) {
					if (i + 1 < strings.length) {
						parameterRange = Integer.valueOf(strings[i + 1]);
						// System.out.println(parameterRange);
						break;
					} else {
						System.out.println("指令参数没有输入，请重新输入指令。");
						parameterRange = -2;
					}
				}
			}
			if (parameterRange == -1) {
				System.out.println("指令类型没有输入，请重新输入指令。");
			} else if (parameterRange != -2) {
				break;
			}
		}
	}
}
