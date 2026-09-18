package com.campus.expense;
import java.io.*; import java.nio.file.*; import java.time.LocalDate; import java.util.*;
public class FileExpenseRepository implements ExpenseRepository {
 private final Path file;
 public FileExpenseRepository(String name){file=Paths.get(name); init();}
 private void init(){try{if(file.getParent()!=null)Files.createDirectories(file.getParent());if(!Files.exists(file))Files.writeString(file,"id,description,amount,category,date\n");}catch(IOException e){throw new RuntimeException("Storage initialization failed",e);}}
 public List<Expense> findAll(){List<Expense> r=new ArrayList<>();try{List<String> ls=Files.readAllLines(file);for(int i=1;i<ls.size();i++){String[] p=ls.get(i).split(",",-1);if(p.length!=5)continue;try{r.add(new Expense(Integer.parseInt(p[0].trim()),p[1].trim(),Double.parseDouble(p[2].trim()),Category.valueOf(p[3].trim()),LocalDate.parse(p[4].trim())));}catch(RuntimeException ex){AppLogger.warn("Skipped malformed expense line "+(i+1));}}}catch(IOException e){throw new RuntimeException("Storage read failed",e);}return r;}
 public void save(Expense e){try{Files.writeString(file,e.toCsv()+"\n",StandardOpenOption.APPEND);}catch(IOException x){throw new RuntimeException("Storage write failed",x);}}
 public void update(Expense e){List<Expense> all=findAll();boolean found=false;for(Expense x:all)if(x.getId()==e.getId()){x.setDescription(e.getDescription());x.setAmount(e.getAmount());x.setCategory(e.getCategory());x.setDate(e.getDate());found=true;}if(!found)throw new IllegalArgumentException("Expense ID not found.");rewrite(all);}
 public void delete(int id){rewrite(findAll().stream().filter(e->e.getId()!=id).toList());}
 private void rewrite(List<Expense> all){try(BufferedWriter w=Files.newBufferedWriter(file)){w.write("id,description,amount,category,date\n");for(Expense e:all)w.write(e.toCsv()+"\n");}catch(IOException e){throw new RuntimeException("Storage rewrite failed",e);}}
}
