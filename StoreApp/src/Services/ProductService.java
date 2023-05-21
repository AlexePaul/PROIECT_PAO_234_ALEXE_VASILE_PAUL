package Services;

import Models.*;

import java.io.*;
import java.util.List;
import java.util.Objects;

import Utils.*;

public class ProductService implements GenericService<Product>{
    private static ProductService instance = null;

    private ProductService(){}

    public static ProductService getInstance(){
        if(instance == null)
            instance = new ProductService();
        return instance;
    }
    @Override
    public List<Product> GetAll() {
        return null;
    }

    @Override
    public void SaveIntoCSV() {
        try {
            File file = new File("./StoreApp/src/CSV/coffeeMaker.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The coffeeMaker CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/fridge.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The fridge CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/monitor.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The monitor CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/peripheral.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The peripheral CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/personalComputer.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The personalComputer CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/phone.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The phone CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/vacuumCleaner.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The vacuumCleaner CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/washingMachine.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The washingMachine CSV file was created!");
                }
            }
        }
        catch(IOException e){
            System.out.println("Error while creating the CSV files");
        }
        StoreService s = StoreService.getInstance();
        List<Store> stores = s.GetAll();
        for (Store store : stores){
            List<Pair<Integer, Product>> stock = s.GetStockOfAStore(store.getStoreId());
            if(stock == null)
                continue;
            for(Pair<Integer, Product> p : stock){
                String type = p.Second().getProductType();
                try {
                    if (Objects.equals(type, "Coffee Maker")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/coffeeMaker.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Fridge")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/fridge.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Monitor")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/monitor.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Peripheral")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/peripheral.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "PersonalComputer/Laptop")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/personalComputer.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Phone")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/phone.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Vaccum Cleaner")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/vacuumCleaner.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Washing Machine")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/washingMachine.csv", true));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }


                }
                catch(IOException m){
                    System.out.println("Error while saving the date in CSV files");
                }
            }
        }
    }

    @Override
    public void ReadFromCSV() {
        try{
            try {
                File file = new File("./StoreApp/src/CSV/coffeeMaker.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The coffeeMaker CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/fridge.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The fridge CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/monitor.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The monitor CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/peripheral.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The peripheral CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/personalComputer.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The personalComputer CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/phone.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The phone CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/vacuumCleaner.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The vacuumCleaner CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/washingMachine.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The washingMachine CSV file was created!");
                    }
                }
            }
            catch(IOException e){
                System.out.println("Error while creating the CSV files");
            }

            StoreService s = StoreService.getInstance();
            BufferedReader reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/coffeeMaker.csv"));
            String product;

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new CoffeeMaker(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/fridge.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Fridge(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())),Integer.parseInt((product.split(",")[7].trim())),Integer.parseInt((product.split(",")[8].trim())),Boolean.parseBoolean((product.split(",")[9].trim())));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/monitor.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Monitor(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())),Integer.parseInt((product.split(",")[7].trim())),Integer.parseInt((product.split(",")[8].trim())));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/peripheral.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Peripheral(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Boolean.parseBoolean((product.split(",")[5].trim())),
                        (product.split(",")[6].trim()));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/personalComputer.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new PersonalComputer(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())),(product.split(",")[7].trim()),(product.split(",")[8].trim()),(product.split(",")[9].trim()));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/phone.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Phone(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),(product.split(",")[5].trim()),
                        Integer.parseInt((product.split(",")[6].trim())),Integer.parseInt((product.split(",")[7].trim())),Integer.parseInt((product.split(",")[8].trim())),Integer.parseInt((product.split(",")[9].trim())),
                        product.split(",")[10].trim());
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/vacuumCleaner.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new VacuumCleaner(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())),
                        (product.split(",")[6].trim()),Integer.parseInt((product.split(",")[7].trim())));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/washingMachine.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new WashingMachine(Integer.parseInt((product.split(",")[2].trim())),Integer.parseInt((product.split(",")[3].trim())),(product.split(",")[4].trim()),Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())),Integer.parseInt((product.split(",")[7].trim())),Integer.parseInt((product.split(",")[8].trim())));
                s.AddStock(Integer.parseInt(storeId),p,amount);
            }

        }
        catch(IOException m){
            System.out.println("Store Service File Error!" + m);
        }
    }
}
