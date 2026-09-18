package com.campus.expense;
import java.time.YearMonth;import java.util.*;
public class AnalyticsService {private final ExpenseService expenses;private final BudgetService budgets;public AnalyticsService(ExpenseService e,BudgetService b){expenses=e;budgets=b;}
 public double totalForMonth(YearMonth m){return expenses.list().stream().filter(e->YearMonth.from(e.getDate()).equals(m)).mapToDouble(Expense::getAmount).sum();}
 public Map<Category,Double> categoryTotals(YearMonth m){Map<Category,Double> r=new EnumMap<>(Category.class);for(Expense e:expenses.list())if(YearMonth.from(e.getDate()).equals(m))r.merge(e.getCategory(),e.getAmount(),Double::sum);return r;}
 public String budgetStatus(YearMonth m){Budget b=budgets.getBudget(m);if(b==null)return "No budget configured for "+m+".";double s=totalForMonth(m),rem=b.getAmount()-s,p=s/b.getAmount()*100;return rem>=0?String.format("Budget: %.2f | Spent: %.2f | Remaining: %.2f | Used: %.1f%%",b.getAmount(),s,rem,p):String.format("Budget: %.2f | Spent: %.2f | Over budget: %.2f | Used: %.1f%%",b.getAmount(),s,-rem,p);}}
