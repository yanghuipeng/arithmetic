package TwoProject;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		int titleNum; // ������Ŀ����
		int parameterRange; // ���������Χ
		while (true) {
			titleNum = -1;
			System.out.println("��������Ŀ����ָ��:");
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
						System.out.println("ָ�����û�����룬����������ָ�");
						titleNum = -2;
					}
				}
			}
			if (titleNum == -1) {
				System.out.println("ָ������û�����룬����������ָ�");
			} else if (titleNum != -2) {
				break;
			}
		}
		while (true) {
			parameterRange = -1;
			System.out.println("�����������Χָ��:");
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
						System.out.println("ָ�����û�����룬����������ָ�");
						parameterRange = -2;
					}
				}
			}
			if (parameterRange == -1) {
				System.out.println("ָ������û�����룬����������ָ�");
			} else if (parameterRange != -2) {
				break;
			}
		}
	}
}
