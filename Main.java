package org.example;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        get the foldernames from the user
        String[] foldernames =  getUserInputs(sc);
//        create the folders
        createFolder(foldernames, sc);
    }


    public static void createFolder(String[] folders, Scanner sc) throws IOException {
        System.out.println("Enter the name of the directory you want to create folders into");
        String directorypath = sc.nextLine();
        System.out.println(directorypath);

        for (int i = 0; i < folders.length; i++){
            String folderName = directorypath+"/component/"+folders[i];
            File f1 = new File(folderName);
            boolean bool = f1.mkdirs();
            if(bool){
                System.out.println("Folder is created successfully");
                System.out.println("Creating js and css files for "+folders[i]);
                createJSCSSfiles(folderName+"/"+folders[i], folders[i]);
            }else{
                System.out.println("Error Found!");
            }

        }

    }

    public static void createJSCSSfiles(String directoryPath, String filename) throws IOException {

        System.out.println("the directory path is "+directoryPath);
        System.out.println("the filename is"+ filename);
        File myObj = new File(directoryPath+".js");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
        myObj = new File(directoryPath+".css");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }



    }

    public static String[] getUserInputs(Scanner sc){
        System.out.println("Enter number of folders you want inside the component directory");
        int number_of_folders = sc.nextInt();
        String[] folder_names = new String[number_of_folders];
        System.out.println("Enter the name of the folders");
        sc.nextLine();
        for (int i = 0; i < number_of_folders; i++){
            System.out.print("Folder"+(i+1)+" name:");
            folder_names[i] = sc.nextLine();
            System.out.println();

        }
        sc.nextLine();
        return folder_names;
    }
}