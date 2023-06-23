package com.nkxgen.spring.jdbc.Bal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nkxgen.spring.jdbc.model.Account;

public class FDIntrestcaluclation implements Accounts {
	long FDintrstRate;
	double FDAmnt;
	int period;
	int age;
	double Gen;
	double intrstRate;
	List<Account> newlist = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public List<Account> calcIntrst(List<Account> amnt) {

		period = 1;
		for (Account a : amnt) {
			String type = a.getAccountTypeId();
			long amount = a.getBalance();

			FDintrstRate = (amount * 4 / 12) / 100;
			if (a.getCount() == 4) {
				a.setCount(0);
				a.setBalance(a.getIntrest() + FDintrstRate);
				a.setIntrest(0);
				LocalDate currentDate = LocalDate.now();

				String dateString1 = currentDate.toString();
				a.setLastUpdate(dateString1);
			} else {
				a.setIntrest(FDintrstRate);
				a.setCount(1);
				LocalDate currentDate = LocalDate.now();

				String dateString1 = currentDate.toString();
				a.setLastUpdate(dateString1);
			}
			newlist.add(a);

		}
		return newlist;
	}
}