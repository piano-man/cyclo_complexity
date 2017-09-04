/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclo_complexity;
import java.util.regex.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author piano-man
 */
public class Cyclo_complexity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("/home/piano-man/NetBeansProjects/pattern_matching/input.txt");
        Scanner scan1 = new Scanner(f);
        Pattern func = Pattern.compile("(public|private|protected){0,1}\\s*(static){0,1}\\s*(void|int|float){1}\\s+\\w*\\(.*\\)");
        int func_count1 = 0;
        int i = -1;
        int flag=0;
        int[] arr = new int[40];
        String l2="";
        String l = scan1.nextLine();
        while(scan1.hasNextLine())
        {
            
            System.out.println(i);
            Matcher m1 = func.matcher(l);
            boolean b1 = m1.matches();
            if(flag==0&&b1==true)
            {
                i++;
                System.out.println("inside if");
                System.out.println(l);
                func_count1++;
                l2 = scan1.nextLine();
                Matcher m2 = func.matcher(l2);
                boolean b2 = m2.matches();
                while(b2==false)
                {
                            //System.out.println("stuck here 2");
                            Pattern cond = Pattern.compile("\\s*(if).*(.*)");
                            Matcher m3 = cond.matcher(l2);
                            boolean b3 = m3.matches();
                            if(b3==true)
                            {
                                System.out.println("match");
                                arr[i]++;
                                
                            }
                            l2 = scan1.nextLine();
                            Matcher m4 = func.matcher(l2);
                            b2 = m4.matches();
                            

                    
                }
                if(b2==true)
                {
                    
                
                flag=1;
                func_count1++;
                }
            }
            else if(flag==1)
            {
                i++;
                System.out.println(l2);
                l2 = scan1.nextLine();
                Matcher m5 = func.matcher(l2);
                boolean b5 = m5.matches();
                while(b5==false&&scan1.hasNextLine())
                {
                            //System.out.println("stuck here 3");
                            Pattern cond = Pattern.compile("\\s*(if).*(.*)");
                            Matcher m3 = cond.matcher(l2);
                            boolean b3 = m3.matches();
                            if(b3==true)
                            {
                                System.out.println("match");

                                arr[i]++;
                                
                            }
                            l2 = scan1.nextLine();
                            Matcher m4 = func.matcher(l2);
                            b5 = m4.matches();
                            

                    
                }
                if(b5==true)
                {
                func_count1++;
                }
                
                
            }
            else
            {
                l=scan1.nextLine();
            }
            
        }
        //lol1: \{([^{}]|(?R))*\}
        System.out.println("function count is :"+func_count1);
        System.out.println(arr[0]+1);
        System.out.println(arr[1]+1);
        System.out.println(arr[2]+1);
        

    }}