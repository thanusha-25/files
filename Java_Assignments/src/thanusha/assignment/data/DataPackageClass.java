package thanusha.assignment.data;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataPackageClass
{
  int a;
  char ch;
  final  Logger logger = Logger.getLogger(DataPackageClass.class.getName());
  public void displayUninitializedClassVariables()
  {
	  logger.log(Level.INFO,"Default values for class variables are : for integer is "+a+" "+"and  character is "+ch);
	  }
 
  /* We cant display the uninitialized local variables.It throws an error.
  void displayUninitializedLocalVariables()
 {
    int b;
    char c ;
   System.out.println(b+" "+c);
  }*/
  
} 
