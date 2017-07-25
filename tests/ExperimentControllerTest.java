import junit.framework.*;
import java.util.*;

public class ExperimentControllerTest extends TestCase{
  
  
  public void testGroupNumber(){
    
    ExperimentController lab = new ExperimentController();
    
    for(int i =0; i<10000;i++){
      int groupNumber = lab.groupNumber(1,4); 
      //assert that the numbers lie within the range
      System.out.println(groupNumber);
      assertTrue(groupNumber<=4 && groupNumber>=1);
      
      int groupNumber2 = lab.groupNumber(6,7);
      //assert that the numbers can equal the end points of the range
      assertTrue(groupNumber2==6||groupNumber2==7);
      
    }
  }
  
  public void testNormalDistributionGenerator(){
    
    for(int j =0;j<10000;j++){
      
      ExperimentController lab = new ExperimentController();
      
      int sum=0;
      
      for(int i =0; i<10000;i++){
        
        int gaussian = lab.normalDistributionGenerator(20,10); 
        //assert that the number is greater than 0
        assertTrue(gaussian>0);
        sum=sum+gaussian;
        
      }
      //assert that the mean of the sample lies within one standard deviation range
      assertTrue((sum/10000)<=30 && (sum/10000)>=10);
      
    }
  }
  
  
  
  
}