package com.campus.expense;
import java.io.IOException;import java.util.logging.*;
public final class AppLogger {private static final Logger LOG=Logger.getLogger("CampusExpenseManager");static{try{FileHandler h=new FileHandler("data/app.log",true);h.setFormatter(new SimpleFormatter());LOG.addHandler(h);LOG.setUseParentHandlers(false);}catch(IOException e){System.err.println("Logging initialization failed: "+e.getMessage());}}private AppLogger(){}public static void info(String s){LOG.info(s);}public static void warn(String s){LOG.warning(s);}}
