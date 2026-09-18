package com.campus.expense;
import java.util.List;
public interface ExpenseRepository { List<Expense> findAll(); void save(Expense e); void update(Expense e); void delete(int id); }
