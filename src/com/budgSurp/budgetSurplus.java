package com.budgSurp;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class budgetSurplus {
	public static void percGraph(double perc){
		for (int i=1;i<=perc;i++){
			System.out.print("|");
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i=1;i<(100-perc);i++){
			System.out.print("-");
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
//		System.out.println(args[0]);
		if (args[0].equals("-c")){
			configWrite.write();
		} else {
			Double grocRem=0.0, otherRem=0.0, grocBudg=0.0, otherBudg=0.0, grocAll=0.0, otherAll=0.0, grocDaily=0.0, otherDaily=0.0, grocPerc=0.0, otherPerc=0.0;
			long daysRem=0;
			long daysInMonth=0;
			double daysPerc=0;
			int days=0;
	//		configRead.read();
			String[] configs = (String[]) configRead.read().toArray(new String[0]);
	//		configs = configRead.read();
	//		for (int i=0;i<configs.length;i++){
	//			System.out.println(configs[i]);
	//		}
	//		grocBudg = Double.parseDouble(configs[6]);
			otherBudg = Double.parseDouble(configs[7]);
	//		System.out.println(""+grocBudg+"\n"+otherBudg);
			
			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			String inputString1 = configs[3]+" "+configs[4]+" "+configs[5];
			String inputString2 = configs[0]+" "+configs[1]+" "+configs[2];
	
			try {
			    Date targDate = myFormat.parse(inputString1);
			    Date curDate = new Date();
			    Date startDate = myFormat.parse(inputString2);
			    long diff = targDate.getTime() - curDate.getTime();
			    long diff2 = targDate.getTime() - startDate.getTime();
			    daysRem=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;
			    daysInMonth=TimeUnit.DAYS.convert(diff2, TimeUnit.MILLISECONDS);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
//			System.out.println("How much remaining for groceries?");
//			grocRem = input.nextDouble();
			System.out.println("How much remaining to spend this month?");
			otherRem = input.nextDouble();
			daysInMonth+=1;
//			System.out.println(daysRem + " days till " + inputString1+"\n"+daysInMonth+" days in month.");
//			grocDaily=grocBudg/daysInMonth;
			otherDaily=otherBudg/daysInMonth;
//			grocAll=(grocBudg/daysInMonth)+(grocRem-(grocBudg/daysInMonth*daysRem));
			otherAll=(otherBudg/daysInMonth)+(otherRem-(otherBudg/daysInMonth*daysRem));
			System.out.println(/*"________________________\n\nFor groceries today: "+grocAll.intValue()+*/"\nTo spend today: "+otherAll.intValue()+"\n________________________\n\n\n\n\n\n\n\n\n\n\n\n"
					+ /*"(norm for groceries is "+grocDaily.intValue()+" per day, norm for other stuff is*/"(+ "+otherDaily.intValue()+" per day)\n\n");
			daysPerc=((daysInMonth-daysRem)/((double) (daysInMonth))*100);
//			grocPerc=((grocBudg-grocRem)/grocBudg)*100;
			otherPerc=((otherBudg-otherRem)/otherBudg)*100;
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		System.out.println(daysPerc+"% of month gone,\n"+grocPerc+"% of grocery budget gone,\n"+otherPerc+"% of other budget gone");
	//		System.out.println("||||||----\n|||-------\n||||||||--");
			System.out.print("Month    : [");
			percGraph(daysPerc);
			System.out.println("]\n");
			
//			System.out.print("Groceries: [");
//			percGraph(grocPerc);
//			System.out.println("]\n");
			
			System.out.print("Budget   : [");
			percGraph(otherPerc);
			System.out.println("]\n");
		}
	}

}
