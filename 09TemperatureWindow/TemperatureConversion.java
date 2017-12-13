public class TemperatureConversion {
   
   public static double CtoF(double t){
      return t * 1.8 + 32;
   }
   
   public static double FtoC(double t){
      return (t - 32) / 1.8;
   }
   
   public static void main(String[] args) {
      System.out.println(CtoF(-40.0));
      System.out.println(CtoF(100.0));
      System.out.println(FtoC(-40.0));
      System.out.println(FtoC(212.0));
   }
}
