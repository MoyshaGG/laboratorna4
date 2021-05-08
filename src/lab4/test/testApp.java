package lab4.test;

import lab4.model.*;
import lab4.store.ProductStore;
import lab4.store.WoodDirectory;

import javax.swing.*;
import java.util.Iterator;
import java.util.ListIterator;

public class testApp {

    private WoodDirectory wd = new WoodDirectory();
    //Каталог для брусів
    private ProductStore ps = new ProductStore();

    public void startApp() throws Exception {

        wd.add(new Wood(0,"Мавпобаобаб",0.3f));
        wd.add(new Wood(1,"Куркодерево",0.6f));
        wd.add(new Wood(2,"Птаходуб",0.9f));

      try {
    ps.add(new Timber(wd.get(0), 5f, 0.5f, 0.4f));
     }
      catch (Exception e)
     {
    JOptionPane.showMessageDialog(null, e.getMessage(),
            "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
     }
        try {
            ps.add(new Timber(wd.get(1),10f,0.6f,0.7f ));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
        }
        try {
            ps.add(new Cylinder(wd.get(2),3f, 0.3f));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
        }
        try {
            ps.add(new Waste(0.025f));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Введення продуктiв" , JOptionPane.ERROR_MESSAGE);
        }
        //Друкуємо перелік продуктів
        System.out.println(wd);
        System.out.println(ps);
        //Обчислюємо вагу продуктів
        System.out.printf("Загальна вага: %1.3f", calcWeight());

        System.out.println();
        System.out.println("Перелік виробів виробів до вилучення");
        Iterator<Object> itr = ps.iterator();
        while(itr.hasNext()){
            IWeight obj = (IWeight) itr.next();
            if (obj.weight()> 54) itr.remove();
        }
        System.out.println("Перелік виробів після вилучення");
        System.out.println(ps.toString());

////////////////////////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Перелік виробів до вилучення");
        System.out.println(ps.toString());
        ListIterator<Object> listItr = ps.listIterator();
        while (listItr.hasNext()){
            IWeight obj = (IWeight) listItr.next();
            if (obj.weight() < 1) listItr.remove();
        }
        System.out.println("Перелік виробів після вилучення");
        System.out.println(ps.toString());



    }

    private float calcWeight(){
        float fullWeight = 0;
        for (Object timber : ps.getArr()){
            fullWeight+=((IWeight)timber).weight();
        }
        return fullWeight;
    }

}
