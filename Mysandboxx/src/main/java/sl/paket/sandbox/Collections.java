package sl.paket.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serglit on 06.08.16.
 */
public class Collections {
    public static void main (String[] args){
        // 1ый способ объявления массива
   //      String [] lang = new String[4];
  //       lang[0]="java";
        // lang[1]="C#";
        // lang[2]="Python";
        // lang[3]="PHP";

        // 2ой способ объявления массива
        String[] lang = {"Java","C#", "Python", "PHP"};

        // Массив languages типа  список- List,может изменяться в рамерах
       //  List<String> languages = new ArrayList<String>(); -объявляем список
        //    languages.add("Java"); - заполняем список значениями
        //    languages.add("C#");
        //    languages.add("Python");
         //   languages.add("PHP");

        // 2 вариант заполнения данными списка типа List
        List<String> languages = Arrays.asList("Java","C#", "Python", "PHP");


     //   for (int i=0;i<lang.length;i++) {  // 1 способ перебора всех элементов массива, lang.length-дает длину массива
                                             //       lang.size- дает длину списка
     //       System.out.println("Могу выучить легко язык  " + lang[i]);
     //   }
     //       for (String l: lang){// 2 способ перебора всех элементов массива
     //           System.out.println("Могу выучить легко язык  " + l);
     //   }

        for (String l: languages) {// 2 способ перебора всех элементов массива
            System.out.println("Могу выучить легко язык  " + l);
        }
    }
}
