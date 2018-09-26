package TwoProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @param titleNum
 *            题目个数
 * @param parameterRange
 *            参数范围
 */
public class Function {
	int titleNum;
	int parameterRange;
	Set<String> set = new HashSet<>();

	public Function(int titleNum, int parameterRange) {
		this.titleNum = titleNum;
		this.parameterRange = parameterRange;
	}

	public void outputExercises() {
		try {
			PrintWriter exercisesWriter = new PrintWriter(new FileWriter("Exercises.txt"));
			PrintWriter answerWriter = new PrintWriter(new FileWriter("Answers.txt"));
			for (int i = 1; i < titleNum + 1;) {
				Expression expression = new Expression(parameterRange);
				String string = expression.getResult();
				if (expression.isWrong == false && !(set.contains(string))) {
					set.add(string);
					exercisesWriter.println(i + ". " + expression.toString());
					answerWriter.println((i + ". " + string));
					i++;
				}
			}
			exercisesWriter.close();
			answerWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("已经生成题目和答案");
	}
}
