package TwoProject;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Expression {
	int titleNum; // 定义题目个数
	int parameterRange; // 定义参数范围
	char[] symbol = { '+', '-', '×', '÷' };

	ThreadLocalRandom random = ThreadLocalRandom.current();

	public Expression(int titleNum, int parameterRange) {
		super();
		this.titleNum = titleNum;
		this.parameterRange = parameterRange;
	}

	// 随机生成一个分数
	Fraction createFraction() {
		if (parameterRange == 1) {
			return new Fraction(0, 1);
		} else {
			int a;
			int b;
			if (random.nextInt(3) == 0) {
				return new Fraction(random.nextInt(parameterRange), 1);
			} else if (random.nextInt(3) == 1) {

				b = random.nextInt(1, parameterRange);
				a = random.nextInt(1, parameterRange);
				while (a >= b)
					a = random.nextInt(1, parameterRange);
				return new Fraction(a, b);
			} else {
				b = random.nextInt(1, parameterRange);
				a = random.nextInt(1, parameterRange);
				while (a >= b)
					a = random.nextInt(1, parameterRange);
				return new Fraction(random.nextInt(1, parameterRange) * b + a, b);
			}
		}
	}

	protected String expreGenerate() {
		int n = random.nextInt(1, 4);
		char[] symchar = new char[n];
		char[] symchar1 = new char[n];
		for (int i = 0; i < n; i++) {
			int j = random.nextInt(0, 4);
			symchar[i] = symbol[j];
		}
		for (int i = 0; i < n; i++) {
			if (symchar[i] == '+' || symchar[i] == '-') {
				symchar1[i] = '1';
			}
			if (symchar[i] == '×' || symchar[i] == '÷') {
				symchar1[i] = '2';
			}
		}
		String string = symchar1.toString().trim();
		String s;
		if (n == 1) {
			s = String.format("%s %c %s =", createFraction(), symchar[0], createFraction());
		} else if (n == 2) {
			if (string == "12" || string == "22")
				s = String.format("%s %c %s %c %s =", createFraction(), symchar[0], createFraction(), symchar[1],
						createFraction());
			else {
				s = String.format("%s %c ( %s %c %s ) =", createFraction(), symchar[0], createFraction(), symchar[1],
						createFraction());
			}
		} else {
			if (string == "221" || string == "222")
				s = String.format("%s %c %s %c ( %s %c %s ) =", createFraction(), symchar[0], createFraction(),
						symchar[1], createFraction(), symchar[2], createFraction());
			else if (string == "111" || string == "112")
				s = String.format("%s %c ( %s %c %s ) %c %s =", createFraction(), symchar[0], createFraction(),
						symchar[1], createFraction(), symchar[2], createFraction());
			else if (string == "121" || string == "122")
				s = String.format("( %s %c %s ) %c %s %c %s =", createFraction(), symchar[0], createFraction(),
						symchar[1], createFraction(), symchar[2], createFraction());
			else {
				s = String.format("%s %c %s %c %s %c %s =", createFraction(), symchar[0], createFraction(), symchar[1],
						createFraction(), symchar[2], createFraction());
			}

		}
		return s;
	}

	// 表达式计算
	private Fraction calculate(String symbol, Fraction left, Fraction right) {
		switch (symbol) {
		case "+":
			return left.add(right);
		case "-":
			return left.subtraction(right);
		case "×":
			return left.multiplication(right);
		default:
			return left.division(right);
		}
	}

	// 表达式结果计算方法
	public String getResult() {
		String string = expreGenerate();
		System.out.println(string);
		String[] strings = string.split("\\s+");

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i]);
		}

		if (string.indexOf("(") != -1) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("="))
					break;
				if (list.get(i).equals("(")) {
					list.set(i, calculate(list.get(i + 2), new Fraction(list.get(i + 1)), new Fraction(list.get(i + 3)))
							.toString());
					for (int j = 0; j < 4; j++) {
						list.remove(i + 1);
					}

				}

			}
		}
		if (string.indexOf("×") != -1 || string.indexOf("÷") != -1) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("="))
					break;
				if (list.get(i).equals("×") || list.get(i).equals("÷")) {
					list.set(i - 1, calculate(list.get(i), new Fraction(list.get(i - 1)), new Fraction(list.get(i + 1)))
							.toString());

					for (int j = 0; j < 2; j++) {
						list.remove(i);
					}

					i--;
				}

			}
		}
		if (string.indexOf("+") != -1 || string.indexOf("-") != -1) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("="))
					break;
				if (list.get(i).equals("+") || list.get(i).equals("-")) {
					list.set(i - 1, calculate(list.get(i), new Fraction(list.get(i - 1)), new Fraction(list.get(i + 1)))
							.toString());

					for (int j = 0; j < 2; j++) {
						list.remove(i);
					}

					i--;
				}

			}
		}

		return list.get(0);
	}
}
