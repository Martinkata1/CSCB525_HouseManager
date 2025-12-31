package org.example.utils;

import org.example.entity.Payment;

import java.io.FileWriter;

public class FileUtil {

    public static void save(Payment p) {
        try (FileWriter fw = new FileWriter("payments.txt", true)) {
            fw.write(
                    p.getCompany().getName() + "|" +
                            p.getEmployee().getName() + "|" +
                            p.getBuilding().getAddress() + "|" +
                            p.getApartment().getNumber() + "|" +
                            p.getAmount() + "|" +
                            p.getDate() + "\n"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
