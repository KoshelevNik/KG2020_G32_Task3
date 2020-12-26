package file_work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {

    public static ArrayList<Integer> getData() {
        ArrayList<Integer> dataInt = new ArrayList<>();
        try {
            File file = new File("files/data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                dataInt.add(scanner.nextInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataInt;
    }
}
