package com.campus.expense;
import java.io.*;import java.nio.file.*;import java.time.YearMonth;import java.util.*;
public class BudgetRepository { private final Path file; public BudgetRepository(String n){file=Paths.get(n);init();}
 private void init(){try{if(file.getParent()!=null)Files.createDirectories(file.getParent());if(!Files.exists(file))Files.writeString(file,"month,amount\n");}catch(IOException e){throw new RuntimeException("Budget storage initialization failed",e);}}
 public List<Budget> findAll(){List<Budget> r=new ArrayList<>();try{List<String> ls=Files.readAllLines(file);for(int i=1;i<ls.size();i++){String[] p=ls.get(i).split(",");if(p.length==2)try{r.add(new Budget(YearMonth.parse(p[0].trim()),Double.parseDouble(p[1].trim())));}catch(RuntimeException ex){AppLogger.warn("Skipped malformed budget line "+(i+1));}}}catch(IOException e){throw new RuntimeException("Budget storage read failed",e);}return r;}
 public void saveOrUpdate(Budget b){List<Budget> all=findAll();boolean f=false;for(Budget x:all)if(x.getMonth().equals(b.getMonth())){x.setAmount(b.getAmount());f=true;}if(!f)all.add(b);try(BufferedWriter w=Files.newBufferedWriter(file)){w.write("month,amount\n");for(Budget x:all)w.write(x.toCsv()+"\n");}catch(IOException e){throw new RuntimeException("Budget storage write failed",e);}}
 public Optional<Budget> find(YearMonth m){return findAll().stream().filter(b->b.getMonth().equals(m)).findFirst();}
}
