package com.campus.expense;
import java.time.YearMonth;
public class BudgetService {private final BudgetRepository repo;public BudgetService(BudgetRepository r){repo=r;}public void setBudget(YearMonth m,double a){InputValidator.month(m);InputValidator.positiveAmount(a);repo.saveOrUpdate(new Budget(m,a));AppLogger.info("Budget set for "+m);}public Budget getBudget(YearMonth m){return repo.find(InputValidator.month(m)).orElse(null);}}
