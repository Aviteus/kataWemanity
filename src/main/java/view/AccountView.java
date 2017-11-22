package view;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

import controller.AccountController;

public class AccountView {
	AccountController accountController = new AccountController();

	public void menu() {
		System.out.println("choose an option:");
		System.out.println("1: credit your account");
		System.out.println("2: withdrax money");
		System.out.println("3: check history");
		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {
			
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			System.out.println(1);
			add();
		case 2:
			System.out.println(2);
			substract();
		case 3:
			System.out.println(3);
			check();
		default:
			System.out.println("wrong input");
			menu();
		}
		}

	}

	private void add() {
		System.out.println("enter the amount you want to credit to your account (press q to quit):");

		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {

			if (scan.hasNextBigDecimal()) {
				BigDecimal value = scan.nextBigDecimal();
				BigDecimal result = accountController.add(value);
				if (result != null) {
					System.out.println("you have " + result.toString() + " euros on your account");
				} else {
					System.out.println("this value is negative: not allowed");
					add();
				}
			} else {
				if (scan.next() == "q") {
					menu();
				} else {
					System.out.println("wrong input");
					add();
				}
			}
		}

	}

	private void substract() {
		System.out.println("enter the amount you want to debit from your account (press q to quit):");

		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {
			if (scan.hasNextBigDecimal()) {
				BigDecimal value = scan.nextBigDecimal();
				BigDecimal result = accountController.subtract(value);
				if (result != null) {
					System.out.println("you have " + result.toString() + " euros on your account");
				} else {
					System.out.println("this value is negative: not allowed");
					substract();
				}
			} else {
				if (scan.hasNext()) {

					if (scan.next() == "q") {
						menu();
					} else {
						System.out.println("wrong input");
						substract();
					}
				}
			}
		}
	}

	private void check() {
		System.out.println("(press q to quit):");

		LinkedList<String> result = accountController.getHistory();
		for (int i = 1; i < result.size(); i++) {

			System.out.println(result.get(i));
		}
		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {

			if (scan.next() == "q") {
				menu();
			} else {
				System.out.println("wrong input");
				check();
			}
		}

	}
}
