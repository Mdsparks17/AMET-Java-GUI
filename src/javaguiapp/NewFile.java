package javaguiapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewFile {
    File file = null;
    FileWriter fileWriter = null;
    boolean canOverwriteFile = false;

    public NewFile(boolean canOverwriteFile, String fileName) {
        this.canOverwriteFile = canOverwriteFile;

        try {
            file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File Created: " + file.getName());
            } else if (canOverwriteFile){
                file.delete();
                file.createNewFile();
                System.out.println("File ReCreated: " + file.getName());
            } else {
                System.out.println("File Already Exists");
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {

        }
    }

    public File getFile() {
        return file;
    }

    public boolean deleteFile() {
        try {
            file.delete();
            return true;
        } catch (Exception e) {
            System.out.println("No file to delete");
            return false;
        }
    }

    public boolean openWriter() {
        try {
            fileWriter = new FileWriter(file);
            return true;
        } catch (IOException e) {
            System.out.println("File does not exist");
            return false;
        }
    }

    public boolean writeTo(String text) {
        try {
            fileWriter.write(text + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("File writer does not exist");
            return false;
        }
    }

    public boolean closeWriter() {
        try {
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("File Writer does not exist");
            return false;
        }
    }
}