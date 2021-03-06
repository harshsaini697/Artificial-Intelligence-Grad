import java.io.*;

public class compute_posterior1 {


public static void main(String[] args) throws IOException {
        hypothesis h1=new hypothesis(0.10000,1.00000,0.00000);
        hypothesis h2=new hypothesis(0.20000,0.75000,0.25000);
        hypothesis h3=new hypothesis(0.40000,0.50000,0.50000);
        hypothesis h4=new hypothesis(0.20000,0.25000,0.75000);
        hypothesis h5=new hypothesis(0.10000,0.00000,1.00000);

        if (args.length !=1) {
                System.out.println("Arguments: compute_posterior [Observation String]\n");
                exit_function(0);
           }
    String Observation_string=args[0];
   // String Observation_string="CLLCLCLlcL";
    String[] ary=Observation_string.split("");
File file=new File("result.txt");
BufferedWriter output=new BufferedWriter(new FileWriter(file));
output.write("Initial Given Information:\n");
        output.write("Observation String :\t");
        output.write(Observation_string);
        output.newLine();
        output.write("P(h1 | Q) =\t");
        output.write(String.valueOf(h1.h_prior));
        output.newLine();
        output.write("P(h2 | Q) =\t");
        output.write(String.valueOf(h2.h_prior));
        output.newLine();
        output.write("P(h3 | Q) =\t");
        output.write(String.valueOf(h3.h_prior));
        output.newLine();
        output.write("P(h4 | Q) =\t");
        output.write(String.valueOf(h4.h_prior));
        output.newLine();
        output.write("P(h5 | Q) =\t");
        output.write(String.valueOf(h5.h_prior));
        output.newLine();
        output.write("Probability that the next candy we pick will be Cherry, given Q: 0.5\n");
        output.write("Probability that the next candy we pick will be Lime, given Q: 0.5\n");



        double qC0,qL0=0.0;
        double new_prior=0.0;
        int count_cherry=0;
        int count_lime=0;



   for(int i=1;i<ary.length;i++) {
        //   System.out.println(ary[0]);
//         System.out.println("\n");
           //Observation sequence to string that will go in fil


          // System.out.println(ary[i].charAt(0));

          qC0=((h1.h_prior*h1.h_cherry) + (h2.h_prior*h2.h_cherry) + (h3.h_prior*h3.h_cherry) + (h4.h_prior*h4.h_cherry) + (h5.h_prior*h5.h_cherry));

qL0 = (h1.h_prior*h1.h_lime) + (h2.h_prior*h2.h_lime) + (h3.h_prior*h3.h_lime) + (h4.h_prior*h4.h_lime) + (h5.h_prior*h5.h_lime);
//  System.out.println(qC0);
//System.out.println(qL0);
try {       if(ary[i].charAt(0)=='C'|| ary[i].charAt(0)=='c' )
{
new_prior=((h1.h_cherry*h1.h_prior)/qC0);
h1.h_prior=new_prior;
new_prior=((h2.h_cherry*h2.h_prior)/qC0);
h2.h_prior=new_prior;
new_prior=((h3.h_cherry*h3.h_prior)/qC0);
h3.h_prior=new_prior;
new_prior=((h4.h_cherry*h4.h_prior)/qC0);
h4.h_prior=new_prior;
new_prior=((h5.h_cherry*h5.h_prior)/qC0);
h5.h_prior=new_prior;
count_cherry=count_cherry+1;


}
if(ary[i].charAt(0)=='L' || ary[i].charAt(0) =='l' )
{
new_prior=((h1.h_lime*h1.h_prior)/qL0);
h1.h_prior=new_prior;
new_prior=((h2.h_lime*h2.h_prior)/qL0);
h2.h_prior=new_prior;
new_prior=((h3.h_lime*h3.h_prior)/qL0);
h3.h_prior=new_prior;
new_prior=((h4.h_lime*h4.h_prior)/qL0);
h4.h_prior=new_prior;
new_prior=((h5.h_lime*h5.h_prior)/qL0);
h5.h_prior=new_prior;
count_lime=count_lime+1;


               }}
 catch(Exception e)
       {
//              System.out.println("Inputs either \"C\" or \"L \"or their \"lowercase values\"");
System.out.println();

       }

       qC0=(h1.h_prior*h1.h_cherry) + (h2.h_prior*h2.h_cherry) + (h3.h_prior*h3.h_cherry) + (h4.h_prior*h4.h_cherry) + (h5.h_prior*h5.h_cherry);

       qL0 = (h1.h_prior*h1.h_lime) + (h2.h_prior*h2.h_lime) + (h3.h_prior*h3.h_lime) + (h4.h_prior*h4.h_lime) + (h5.h_prior*h5.h_lime);
   //  round(qC0,5);
       //round(qL0,5);

       try {
               //BufferedWriter output=new BufferedWriter(new FileWriter(file));
               output.newLine();
               output.write("Observation Number:"+i);
               output.newLine();
               output.write("P(h1 | Q) =\t");
               output.write(String.valueOf(round(h1.h_prior,5)));
               output.newLine();
               output.write("P(h2 | Q) =\t");
               output.write(String.valueOf(round(h2.h_prior,5)));
               output.newLine();
               output.write("P(h3 | Q) =\t");
               output.write(String.valueOf(round(h3.h_prior,5)));
               output.newLine();
               output.write("P(h4 | Q) =\t");
               output.write(String.valueOf(round(h4.h_prior,5)));
               output.newLine();
               output.write("P(h5 | Q) =\t");
               output.write(String.valueOf(round(h5.h_prior,5)));
               output.newLine();
               output.write("Probability that the next candy we pick will be Cherry, given Q:"+round(qC0,5)+"\n");
               output.write("Probability that the next candy we pick will be Lime, given Q:"+round(qL0,5)+"\n");

               }

               catch(Exception e){
                       System.out.println("Error Printing in File");
               }


  }
output.close();
System.out.println("Successfullly Computed and Written. ");
}
public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
private static void exit_function(int value) {
        System.out.println("Exiting from Computation");
        System.exit(value);
    }

}
