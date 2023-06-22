package com.nkxgen.spring.jdbc.model;

import java.math.BigDecimal;

public class service {
	static int value = 0;

	public static Customer dotheservice(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setCust_id(customertrail.getId());
		customer.setCust_title(customertrail.getTitle());
		customer.setCust_type(customertrail.getType());
		customer.setCust_caddress(customertrail.getCurrentAddress());
		customer.setCust_capincode(customertrail.getCurrentPINCode());
		customer.setCust_dob(customertrail.getDateOfBirth());
		customer.setCust_mobile1(customertrail.getMobile1());
		customer.setCust_mobile2(customertrail.getMobile2());
		customer.setCust_rphone(customertrail.getResidencePhone());
		customer.setCust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customer changing(Customer customer2, CustomerSub customerSub) {
		customer2.setCust_title(customerSub.getTitle());
		customer2.setCust_mobile1(customerSub.getPhoneNo());
		customer2.setCust_raddress(customerSub.getAddress());
		return customer2;
	}

	public EMIpay changeToEmiObj(LoanAccount account) {
		EMIpay obj1 = new EMIpay();
		obj1.setLoanId(account.getLoanId());
		// obj.setAccountHolder(account.);
		obj1.setLoanType(account.getLoanType());
		obj1.setLoanamount(account.getLoanAmount());
		obj1.setNOI(account.getLoanDuration());
		obj1.setInterestRate(account.getInterestRate());
		obj1.setLoan_pending(account.getdeductionAmt());
		obj1.setRemainMonths(service.calRM(account.getdeductionAmt(), account.getLoanAmount(), account.getLoanDuration()));
		obj1.setEmi(service.calEMI(account.getLoanAmount(), account.getLoanDuration()));
		obj1.setInterest(service.calinterest(account.getLoanAmount(),account.getLoanDuration(), account.getInterestRate()));
		obj1.setTotal(service.total(account.getLoanAmount(),  account.getLoanDuration(), account.getInterestRate(), account.getdeductionAmt()));
//		obj.setPastDue();
		obj1.setComplete(service.complete(account.getLoanDuration(),account.getdeductionAmt(),account.getLoanAmount(), account.getInterestRate()));
        return obj1;
	}

	public static int calRM(double amount, double lamount, int duration) {
		value = (int) (amount / (lamount / duration));
		return value;
	}

	public static int calEMI(double lamount, int duration) {
		value = (int) (lamount / duration);
		return value;
	}

	public  static long calinterest(double lamount, int duration, double ir) {
		long value1 = (long) ((lamount / duration)*(ir) / 1200);
		return value1;
	}
	
	public  static double total(double lamount,int duration, double ir,double damount) {
		long value2 = service.calinterest(lamount, duration, ir)+service.calEMI(lamount, duration);
		return value2;
		
	}
	
	public  static long complete(int duration,double damount,double lamount,double ir) {
		long value2 = (long) (service.calinterest(lamount, duration, ir)+damount);
		return value2;
		
	}
	
	


}

