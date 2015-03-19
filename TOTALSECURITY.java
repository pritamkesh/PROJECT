/* This is source code of Bank Account Registration.
* Source Code written by Pritam Kesh.
* E-mail : pritamkesh.summercode@gmail.com
*
* To report any bugs please send me an e-mail.
* Tips are welcome.
*
*/
import java.io.*;
import java.util.*;
class TotalSecurity
	{
	public static void main(String args[])throws InterruptedException
		{
		
	        System.out.println("******************************************************************");
		System.out.println("           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^              ");
		System.out.println("   <<<<<<<<<<<<<<<<<<<<<<< TOTAL-SECURITY ANTIVIRUS>>>>>>>>>>>>>>>>>>>>>>>>>        ");
		System.out.println("           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^            ");
		System.out.println("                                              -TOTAL-SECURITY © 2014");
		System.out.println("******************************************************************");
		System.out.println();
		System.out.println();
		String s=System.console().readLine("ENTER THE LOCATION YOU WANT TO SCAN :");
		File ob=new File(s);
		System.out.println("--SCANNING-- . . .");
		Thread.sleep(2500);
		File a[]=ob.listFiles(new MyFilter());
		File ob1=new File(s);
		File b[]=ob1.listFiles(new MyFilter1());
		for(File f:a)
		System.out.println(f.getName());
		System.out.println();
		System.out.println("===============================================");
		System.out.println("     NO. OF FILES SCANNED     : "+Global.p); 
		System.out.println("     NO. OF FILES DELETED     : "+Global.del); 
		System.out.println("     NO. OF FILES RECOVERED   : "+Global.Blo); 
		System.out.println("     NO.OF FILES SKIPPED      : "+Global.ski); 
		System.out.println("===============================================");
		System.out.println("***********************************************");
		}
	}
class MyFilter implements FileFilter
	{
	public boolean accept(File f)
		{
		Global.p++;
		int z=1;
		
			if((f.getName().endsWith(".exe"))||(f.getName().endsWith(".bat"))||(f.getName().endsWith(".vb"))||
          (f.getName().endsWith(".ade"))||(f.getName().endsWith(".adp"))||(f.getName().endsWith(".bas"))||
          (f.getName().endsWith(".com"))||(f.getName().endsWith(".cmd"))||(f.getName().endsWith(".chm"))||
          (f.getName().endsWith(".cpl"))||(f.getName().endsWith(".dll"))||(f.getName().endsWith(".scr"))||(f.getName().endsWith(".dat")))
			{
			while(z==1)
				{
				System.out.println("VIRUS FILE FOUND  :  "+f.getName());
				System.out.println("1. DELETE 	\n2. RECOVER \n3. SKIP\n");	
				try
					{
					z=1;
					int i=Integer.parseInt(System.console().readLine("ENTER YOUR CHOICE :  "));
						if((i<1)||(i>3))
							{
							SubException e=new SubException();
							throw e;
							}
							z=0;
							if(i==1)
							{
							boolean suc=f.delete();
							if(suc==true)
								{
								System.out.println("\n--FILE PERMANENTLY DELETED--");
								Global.del++;
								}
							else
								System.out.println("\n--CANNOT DELETE FILE--");
							}
							if(i==2)
							{
							Global.p++;
							String y=f.getName().toString();
							int d=y.lastIndexOf(".");
							String g=y.substring(0,d)+".pdf";
							boolean success=f.renameTo(new File(f.getParentFile(),g));
							if(success==true)
								{
								System.out.println("\n--FILE RECOVERED--");
								Global.Blo++;
								}
							else
							System.out.println("\n--COULD NOT RECOVER THE FILE--");
							}
						if(i==3)
							{
							Global.p++;
							Global.ski++;
							System.out.println("--FILE SKIPPED--");
							}
					

					}
				catch(NumberFormatException e)
					{
					z=1;
					System.out.println("\nPlease Enter a valid Choice");
					}
				catch(SubException e)
					{
					z=1;
					System.out.println("\nPlease Enter a Valid Choice");
					}	
				}
			return true;
			}
			else if(f.isDirectory())
			{
			File ob4=new File(f.getAbsolutePath());
			File d[]=ob4.listFiles(new MyFilter1());
   			return true;
			}
			else
			return false;
		}
	}
class Global
	{
	public static int del=0;
	public static int Blo=0;
	public static int ski=0;
	public static int p=0;
	}
class SubException extends Exception
	{
	}
class MyFilter1 implements FileFilter
	{
	public boolean accept(File f)
		{
		if(f.isDirectory())
			{
			File ob3=new File(f.getAbsolutePath());
 			File c[]=ob3.listFiles(new MyFilter());
			}	
		return false;
		}
	}
