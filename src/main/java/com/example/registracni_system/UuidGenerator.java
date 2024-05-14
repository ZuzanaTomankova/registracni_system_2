package com.example.registracni_system;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class UuidGenerator {
    public static void main(String[] args) throws IOException {
        List<UUID> uuidList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            UUID uuid = UUID.randomUUID();
            uuidList.add(uuid);

        }
        for (UUID uuid1 : uuidList) {
            System.out.println(uuid1);

            saveUuidToFile(uuidList);


        }

}
    public static void saveUuidToFile(List<UUID> uuidList) throws RuntimeException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/uuidFile.txt")))) {
            for (UUID uuid : uuidList) {
                writer.println(uuid);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor nebyl nalezen!\n"
                    + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException("Chyba výstupu při zápisu do souboru. "
                    +":\n"+ e.getLocalizedMessage());
        }


    }

}