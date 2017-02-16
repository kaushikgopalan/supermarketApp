import com.CheckOut;
import com.ListProviders;

import java.util.Scanner;

/**
 * Created by kaushik on 11-Feb-17.
 */
public class SupermarketMain {
    public static void main(String[] args){

        SupermarketMain sm=new SupermarketMain();
        System.out.println("enter the items to scan as a continuous string of characters");
        Scanner scan=new Scanner(System.in);
        String goods=scan.nextLine();
        System.out.println("the total is: "+sm.calculatePrice(goods));


    }

    public double calculatePrice(String goods) {
        CheckOut co = new CheckOut(ListProviders.getPricingRules());
        for (int i = 0; i < goods.length();i++) {
            co.scan(String.valueOf(goods.charAt(i)));
        }
        return co.total();
    }
}
