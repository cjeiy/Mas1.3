import java.util.Random;

/**
 * Created by Carl-Johan on 2016-02-25.
 */
public class LongestPath {
    boolean[][] matrice = null;
    int matriceSize = 0;
    int longestPossiblePath=0;
    int longestFoundPath = 0;
    int longesti=0;
    int longestj=0;
    long startTime=0;
    long stopTime=0;


    public LongestPath(int matriceSize) {
        this.matriceSize = matriceSize;
        matrice = new boolean[this.matriceSize][this.matriceSize];


    }

    public void createMatrice() {
        Random random = new Random();

        for (int outerIndex = 0; outerIndex < this.matriceSize; outerIndex++) {
            for (int innerIndex = 0; innerIndex < matrice[outerIndex].length; innerIndex++) {
                if (random.nextDouble() < 0.5) {
                    matrice[outerIndex][innerIndex] = true;
                } else {
                    matrice[outerIndex][innerIndex] = false;
                }
            }
        }

    }


    public void findLongestPath(){
        longestPossiblePath = matriceSize -1;
        int TempLongestFoundPath = 0;
        int i=0;
        int j=1;
        int lastj=1;
        int longestPossiblePathLocal = longestPossiblePath;
        startTime = System.currentTimeMillis();
        boolean longerPossibleLocalPath = longestPossiblePathLocal+TempLongestFoundPath>longestFoundPath;
        boolean longerPossiblePath = longestFoundPath<=longestPossiblePath;
        boolean newLongestPath = TempLongestFoundPath>longestFoundPath;





        while(longestFoundPath<longestPossiblePath){
            jLoop:
            for(j=lastj;j<matriceSize;j++){
                //System.out.println("j: " + j);
                //System.out.println("i: " + i);
                if(longestPossiblePathLocal+TempLongestFoundPath>longestFoundPath){
                    if(matrice[i][j]){
                        TempLongestFoundPath++;

                        if(TempLongestFoundPath>longestFoundPath){
                            longestFoundPath=TempLongestFoundPath;
                        }
                    }else{TempLongestFoundPath=0;}
                }else{break jLoop;}


                longestPossiblePathLocal--;
                i++;


            }
            TempLongestFoundPath = 0;
            longestPossiblePath--;
            longestPossiblePathLocal = longestPossiblePath;
            lastj++;
            j=lastj;
            i=0;





        }

    }

    public void printMatrix(){

        for (int i = 0; i < matriceSize; i++) {
            for (int j = 0; j < matriceSize; j++) {
                if(i>=j){
                    System.out.print(String.format("%-6s" , "null" )  + " ");

                }
                else if(i == longesti && j==longestj){
                    System.out.print(String.format("%-6s", "_TRUE_") + " ");

                }
                else {
                    System.out.print(String.format("%-6s", matrice[i][j]) + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){
        LongestPath lp = new LongestPath(20000);
        lp.createMatrice();
        lp.findLongestPath();
        //System.out.println(lp.longestFoundPath);
        //lp.printMatrix();
        lp.stopTime = System.currentTimeMillis() - lp.startTime;
        System.out.println(lp.stopTime);
        System.out.println(lp.longestFoundPath);

    }
}