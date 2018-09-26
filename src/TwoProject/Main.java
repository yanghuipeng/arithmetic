package TwoProject;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int titleNum; // 定义题目个数
		int parameterRange; // 定义参数范围
		 System.out.println("**** -n [数值]     使用 -n 参数控制生成题目的个数");
		    System.out.println("**** -e <exercisefile>.txt -a <answerfile>.txt  对给定的题目文件和答案文件，判定答案中的对错并进行数量统计");
		    System.out.print("请输入命令：");
		    Scanner s = new Scanner(System.in);
		    String m =s.nextLine();
		    String str[]=m.split("\\s");
		    switch (str[0]){
		        case "-n":
		        	titleNum=Integer.valueOf(str[1].toString());
		            System.out.println("**** -r [数值]     使用 -r 参数控制题目中数值（自然数、真分数）的范围");
		            System.out.print("请输入命令：");
		            Scanner ss = new Scanner(System.in);
		            String n = ss.nextLine();
		            String strr[]=n.split("\\s");
		            parameterRange=Integer.valueOf(strr[1].toString());
		            Function function=new Function(titleNum,parameterRange);
		    		function.outputExercises();
		            break;
		        case "-e":
		          //  answerJudge.Judge(arr[1], arr[3]);
		            break;
		        default:
		            System.out.println("输入的命令有误!");break;
		    }
		    s.close();
					
   }
 
	
}
