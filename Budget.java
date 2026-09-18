package com.campus.expense;
import java.time.YearMonth;
public class Budget { private final YearMonth month; private double amount; public Budget(YearMonth m,double a){month=m;amount=a;} public YearMonth getMonth(){return month;} public double getAmount(){return amount;} public void setAmount(double a){amount=a;} public String toCsv(){return month+","+amount;} }
