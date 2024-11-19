package com.edubridge.MicroOven;

import java.util.List;
import java.util.Scanner;

import com.edubridge.MicroOven.model.MicroOven;
import com.edubridge.MicroOven.service.MicroOvenService;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        MicroOvenService service = new MicroOvenService();  // Use MicroOvenService instead of ContactService
        String name, email, mobile;
        name = email = mobile = null;
        int status = 0;

        do {
            System.out.println("Welcome to MicroOven Application");
            System.out.println("==============================");
            System.out.println("1. Add MicroOven");
            System.out.println("2. View All MicroOvens");
            System.out.println("3. Search MicroOven");
            System.out.println("4. Update MicroOven");
            System.out.println("5. Delete MicroOven");
            System.out.println("6. Delete All MicroOvens");
            System.out.println("0. Exit");
            System.out.println("Please choose option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New MicroOven");
                    System.out.println("------------");
                    System.out.println("Enter MicroOven Name: ");
                    name = in.next();
                    System.out.println("Enter MicroOven Email: ");
                    email = in.next();
                    System.out.println("Enter MicroOven Mobile: ");
                    mobile = in.next();

                    MicroOven microOven = new MicroOven();  // Create new MicroOven object
                    microOven.setName(name);
                    microOven.setEmail(email);
                    microOven.setMobile(mobile);

                    service.addMicroOven(microOven);  // Call service to add MicroOven
                    break;

                case 2:
                    System.out.println("View All MicroOvens");
                    System.out.println("-----------------");
                    List<MicroOven> microOvens = service.getAllMicroOvens();  // Fetch all MicroOvens
                    if (microOvens.size() != 0) {
                        for (MicroOven m : microOvens) {
                            System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getEmail() + "\t" + m.getMobile());
                        }
                    } else {
                        System.out.println("No MicroOvens found");
                    }
                    break;

                case 3:
                    System.out.println("Search MicroOven");
                    System.out.println("---------------");
                    System.out.println("Please enter MicroOven id: ");
                    int id = in.nextInt();
                    MicroOven m = service.getMicroOvenById(id);  // Fetch MicroOven by id
                    if (m != null) {
                        System.out.println("MicroOven Name: " + m.getName());
                        System.out.println("MicroOven Email: " + m.getEmail());
                        System.out.println("MicroOven Mobile: " + m.getMobile());
                    } else {
                        System.out.println("No MicroOven found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update MicroOven Details");
                    System.out.println("----------------------");
                    System.out.println("Enter MicroOven Id: ");
                    int microOvenId = in.nextInt();
                    System.out.println("Enter MicroOven Name: ");
                    name = in.next();
                    System.out.println("Enter MicroOven Email: ");
                    email = in.next(); 
                    System.out.println("Enter MicroOven Mobile: ");
                    mobile = in.next();

                    MicroOven updatedMicroOven = new MicroOven();  // Create updated MicroOven object
                    updatedMicroOven.setId(microOvenId);
                    updatedMicroOven.setName(name);
                    updatedMicroOven.setEmail(email);
                    updatedMicroOven.setMobile(mobile);
                    service.updateMicroOven(updatedMicroOven);  // Call service to update MicroOven
                    break;

                case 5:
                    System.out.println("Delete MicroOven");
                    System.out.println("--------------");
                    System.out.println("Please enter MicroOven id: ");
                    int mid = in.nextInt();
                    service.deleteMicroOven(mid);  // Call service to delete MicroOven
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all MicroOvens? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllMicroOvens();  // Call service to delete all MicroOvens
                    }
                    break;

                case 0:
                    System.out.println("Bye!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose the correct option: ");
                    break;
            }

        } while (option != 0);
    }
}
