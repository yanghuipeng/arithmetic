package TwoProject;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		int titleNum; // ������Ŀ����
		int parameterRange; // ���������Χ
		System.out.println("**** -n [��ֵ]     ʹ�� -n ��������������Ŀ�ĸ���");
		System.out.println("**** -e <exercisefile>.txt -a <answerfile>.txt  �Ը�������Ŀ�ļ��ʹ��ļ����ж����еĶԴ���������ͳ��");
		System.out.print("���������");
		Scanner s = new Scanner(System.in);
		String m = s.nextLine();
		String str[] = m.split("\\s");
		switch (str[0]) {
		case "-n":
			titleNum = Integer.valueOf(str[1].toString());
			System.out.println("**** -r [��ֵ]     ʹ�� -r ����������Ŀ����ֵ����Ȼ������������ķ�Χ(��ֵӦ����1)");
			System.out.print("���������");
			Scanner ss = new Scanner(System.in);
			String n = ss.nextLine();
			String strr[] = n.split("\\s");
			if (strr[0].equals("-r")) {
				parameterRange = Integer.valueOf(strr[1].toString());
				Function function = new Function(titleNum, parameterRange);
				function.outputExercises();
				break;
			} else {
				System.out.println("�������������!");
				break;
			}
		case "-e":
			Function function0 = new Function();
			String gradePath = "Grade.txt";
			function0.outputGrade(str[1], str[3], gradePath);
			break;
		default:
			System.out.println("�������������!");
			break;
		}
		s.close();

	}

}
