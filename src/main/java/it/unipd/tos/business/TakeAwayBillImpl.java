////////////////////////////////////////////////////////////////////
// [Matteo] [Budai] [1201180]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import java.util.List;

public class TakeAwayBillImpl implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        double total = 0;
         double min = 1000;
        int gelati = 0;
        boolean notBevanda = false;

        if(itemsOrdered == null) {
            throw new TakeAwayBillException("Lista nulla");
        }

        if(itemsOrdered.isEmpty()) {
            throw new TakeAwayBillException("Lista ordini vuota");
        }
        
        //30+ elementi
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Limite ordine superato");
        }

        for (MenuItem item : itemsOrdered) {
            double current = item.getPrice();
            if(!item.getType().equals(ItemType.Bevanda)) {
                notBevanda = true;
                if(item.getType().equals(ItemType.Gelato)) {
                    gelati++;
                }
               }
            if(current<min) {
                min=current;
            }
            total += current;
        }

        //sconto 50%
        if(gelati > 5) {
            total -= 0.5*min;   
        }
        
        //sconto 10%
        if(total>50 && notBevanda) {
            total -= total*0.1;
        }

        return total;
    }
} 
