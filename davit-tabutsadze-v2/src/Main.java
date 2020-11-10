package pkg;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\OPS\\Desktop\\BTU_DOCUMENT");
        new myThreadCounter(f).start();
        new myThreadFinder(f).start();
    }


}

class myThreadCounter extends Thread{

    private int filesNum;
    private File startPath;

    public myThreadCounter(File Path) {
        this.filesNum = 0;
        this.startPath = Path;
    }

    @Override
    public void run() {
        travel(this.startPath);
        System.out.println("Counted " + this.filesNum + " Files excluding directories.");
    }

    private void travel(File Path){
        try {
            File[] files = Path.listFiles();
            for(File currentFile : files){
                if(currentFile.isDirectory()) travel(currentFile);
                else {
                    this.filesNum++;
                    System.out.println(currentFile.getName());
                    TimeUnit.SECONDS.sleep(3);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class myThreadFinder extends Thread{

    private File startPath;

    public myThreadFinder(File Path) {
        this.startPath = Path;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("შემოიტანე საძიებო სიტყვა :");
            String word = sc.nextLine();
            if(word.equals("")) break;
            findWordbyDir(this.startPath, word);
        }
        System.out.println("დაასრულა");
    }

    private static void findWordbyDir(File Path, String word){
        try {
            File[] files = Path.listFiles();
            for(File currentFile : files){
                if(containsWord(currentFile.getName(),word)) {
                    System.out.println("იპოვა :" + currentFile.getName());
                }
                if(currentFile.isDirectory()) findWordbyDir(currentFile, word);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean containsWord(String word, String toFind){
        int maxIndex = word.length() - toFind.length()+1;
        for(int i = 0; i < maxIndex; i++) {
            String sub = word.substring(i, i+toFind.length());
            if(sub.equals(toFind)) return true;
        }
        return false;

    }
}

