package com.campus.expense;
import java.time.LocalDate;
public class Expense {
 private final int id; private String description; private double amount; private Category category; private LocalDate date;
 public Expense(int id,String description,double amount,Category category,LocalDate date){this.id=id;this.description=description;this.amount=amount;this.category=category;this.date=date;}
 public int getId(){return id;} public String getDescription(){return description;} public double getAmount(){return amount;} public Category getCategory(){return category;} public LocalDate getDate(){return date;}
 public void setDescription(String v){description=v;} public void setAmount(double v){amount=v;} public void setCategory(Category v){category=v;} public void setDate(LocalDate v){date=v;}
 public String toCsv(){return id+","+description.replace(","," ")+","+amount+","+category+","+date;}
 public String toString(){return String.format("#%d | %-22s | %8.2f | %-13s | %s",id,description,amount,category,date);}
}
