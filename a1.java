package a1;

import java.util.Scanner;
public class a1
{
enum units
{
ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE;
}
enum teens
{
ELEVEN,TWELVE,THIRTEEN,FOURTEEN,FIFTEEN,SIXTEEN,SEVENTEEN,EIGHTEEN,NINETEEN;
}
enum tens
{
TEN,TWENTY,THIRTY,FOURTY,FIFTY,SIXTY,SEVENTY,EIGHTY,NINETY;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("enter the number (0-99999):");
int number=sc.nextInt();
if(number<0 || number>99999)
{
System.out.println("Enter a number(0-99999) ");
}
else
{
System.out.println("words: "+convert(number));
}
sc.close();
}

public static String convert(int number)
{
if(number==0)
{
return units.ZERO.name();
}
String words=" ";
if(number/1000>0)
{
words+=convert(number/1000)+" THOUSAND ";
number%=1000;
if(number==0)
{
return words.trim();
}
}
if(number/100>0)
{
words+=units.values()[number/100].name()+" HUNDRED ";
number%=100;
}
if(number>=11 && number<=19)
{
words+=teens.values()[number-11].name()+" ";
}
else
{
if(number/10 > 0)
{
words+=tens.values()[number/10-1].name()+" ";
number%=10;
}
if(number>0)
{
words+=units.values()[number].name()+" ";
}
}
return words.trim();
}
}
