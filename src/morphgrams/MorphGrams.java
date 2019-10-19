/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morphgrams;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class MorphGrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        HashMap<Long,Integer> map=new HashMap();
        for (int i=0;i<n;i++) {
            String word=sc.nextLine();
            long code=getCode(word);
            if (map.containsKey(code)) {
                map.put(code,map.get(code)+1);
            } else
                map.put(code,1);
        }
        int result=0;
        for (Integer num : map.values()) {
           result+=getPairs(num); 
        }
        System.out.println(result);
    }

    private static long getCode(String word) {
        HashMap<Character,Integer> map=new HashMap();
        char[] chars=word.toCharArray();
        int i=0;
        long code=0;
        for (char c:chars) {
            if (map.containsKey(c)) {
                code=code*100+map.get(c);
            } else {
                i++;
                map.put(c, i);
                code=code*100+i;
            } 
        }
        return code;
    }
    
    private static int getPairs(int num) {
        return num*(num-1)/2;
    }
    
}
