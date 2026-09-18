package com.campus.expense;
import java.time.LocalDate;import java.util.*;
public class ExpenseService {private final ExpenseRepository repo;public ExpenseService(ExpenseRepository r){repo=r;}
 public Expense add(String d,double a,Category c,LocalDate date){InputValidator.text(d);InputValidator.positiveAmount(a);InputValidator.date(date);if(c==null)throw new IllegalArgumentException("Category is required.");int id=repo.findAll().stream().mapToInt(Expense::getId).max().orElse(0)+1;Expense e=new Expense(id,d.trim(),a,c,date);repo.save(e);AppLogger.info("Created expense "+id);return e;}
 public List<Expense> list(){return repo.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).toList();}
 public List<Expense> search(String key){String k=InputValidator.text(key).toLowerCase();return list().stream().filter(e->e.getDescription().toLowerCase().contains(k)||e.getCategory().name().toLowerCase().contains(k)).toList();}
 public void update(int id,String d,double a,Category c,LocalDate date){if(id<=0)throw new IllegalArgumentException("ID must be positive.");InputValidator.text(d);InputValidator.positiveAmount(a);InputValidator.date(date);if(c==null)throw new IllegalArgumentException("Category is required.");repo.update(new Expense(id,d.trim(),a,c,date));AppLogger.info("Updated expense "+id);}
 public void delete(int id){if(id<=0)throw new IllegalArgumentException("ID must be positive.");if(repo.findAll().stream().noneMatch(e->e.getId()==id))throw new IllegalArgumentException("Expense ID not found.");repo.delete(id);AppLogger.info("Deleted expense "+id);}}
