package com.codecool.shop.serialization;
import com.codecool.shop.model.Order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialize {

        public static void writeObject(Order order, String fileName) throws FileNotFoundException {

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(
                        String.format("src/main/exportFiles/%s.ser", fileName));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(order);
                objectOutputStream.flush();
                objectOutputStream.close();

            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
