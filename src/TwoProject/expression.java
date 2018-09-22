package TwoProject;

import java.util.concurrent.ThreadLocalRandom;

public class expression {
	int titleNum; // 定义题目个数
	int parameterRange; // 定义参数范围
	char[] symbol = { '+', '-', '×', '÷' };

	ThreadLocalRandom random = ThreadLocalRandom.current();

	public expression(int titleNum, int parameterRange) {
		super();
		this.titleNum = titleNum;
		this.parameterRange = parameterRange;
	}

	// 随机生成一个分数
	private Fraction createFraction(int parameterRange) {
		if (parameterRange == 1) {
			return new Fraction(0, 1);
		} else {
			int a;
			int b;
			if (random.nextBoolean()) {
				return new Fraction(random.nextInt(parameterRange), 1);
			} else {
				if (random.nextBoolean()) {
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

	}

	private String expreGenerate() {
		int n = random.nextInt(1, 4);
		char[] symchar = new char[n];
		for (int i = 0; i < n; i++) {
			int j = random.nextInt(0, 4);
			symchar[i] = symbol[j];
		}
		String string = symchar.toString();
		string = string.replaceAll("+", "1");
		string = string.replaceAll("-", "1");
		string = string.replaceAll("×", "2");
		string = string.replaceAll("÷", "2");
		String s;
		if (string.length()==1) {
			s = String.format("%s%c%s=", createFraction(parameterRange), symchar[0], createFraction(parameterRange));
		} else if (string.length()==2) {
			if(string == "12" || string == "22")
				s = String.format("%s%c%s%c%s=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange));
			else {
				s = String.format("%s%c%(s%c%s)=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange));
			}
		}
		else {
			if(string == "221"||string == "222")
				s = String.format("%s%c%s%c(%sc%s)=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange),symchar[2], createFraction(parameterRange));
			else if(string == "111"||string == "112")
				s = String.format("%s%c%(s%c%s)c%s=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange),symchar[2], createFraction(parameterRange));
			else if(string == "121"||string == "122")
				s = String.format("(%s%c%s%)c%sc%s=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange),symchar[2], createFraction(parameterRange));
			else {
				s = String.format("%s%c%s%c%sc%s=", createFraction(parameterRange), symchar[0], createFraction(parameterRange),
						symchar[1], createFraction(parameterRange),symchar[2], createFraction(parameterRange));
			}
		}
			return s;
		}
		
	
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

}
