package assignments;
import java.util.logging.*;

class Cycle
{
	final  Logger logger = Logger.getLogger(Cycle.class.getName());
   void balance()
  {
    logger.log(Level.INFO,"balance method");
   }
 }
 
class Unicycle extends Cycle
{
  void balance()
  {
	  logger.log(Level.INFO,"unicycle balance method");
   }
 }

class Bicycle extends Cycle
{
   void balance()
  {
	   logger.log(Level.INFO,"bicycle balance method");
   }
 }

class Tricycle extends Cycle
{
  }
 
class Jass7b
{
  public static void main(String[] args) 
  {
  // upcasting
    Unicycle upcastUni=new Unicycle();
    Bicycle upcastBi=new Bicycle();
    Tricycle upcastTri=new Tricycle();
    Cycle cycle[]= new Cycle[3];
    cycle[0]=upcastUni;
    cycle[1]=upcastBi;
    cycle[2]=upcastTri;
    cycle[0].balance();
    cycle[1].balance();
    cycle[2].balance();
  
  //downcating
  // Cycle c[]=new Cycle[3];
    cycle[0]=new Unicycle();
    cycle[1]=new Bicycle();
    cycle[2]=new Tricycle();
   Unicycle uni=(Unicycle)cycle[0];
   Bicycle bi=(Bicycle)cycle[1];
   Tricycle tri=(Tricycle)cycle[2];
   uni.balance();
   bi.balance();  
   tri.balance();
  
    }
  }




















/*
class Jass7b{
   public static void main(String args[]){
     Account obj[] = new Account[2] ;
     obj[0] = new Account();
     obj[1] = new Account();
    obj[0].setData(1,2);
    obj[1].setData(3,4);
    System.out.println("For Array Element 0");
    obj[0].showData();
    System.out.println("For Array Element 1");
     obj[1].showData();
  }
}
class Account{
  int a;
  int b;
 public void setData(int c,int d){
   a=c;
   b=d;
 }
 public void showData(){
   System.out.println("Value of a ="+a);
   System.out.println("Value of b ="+b);
 }
}*/


