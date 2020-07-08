package prog;

import java.io.*;

public class FileHandler {
    // writing to file, opens a new file and put the data in the file
    public void writeToFile(MainDriver mainDriver){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("Shopinfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(mainDriver);
            fout.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public MainDriver readFromFle(String filename){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read object
            MainDriver mainDriver = (MainDriver) oi.readObject();

            oi.close();
            fi.close();
            return mainDriver;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
