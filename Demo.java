import java.awt.Color;
import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author Fabian Menn & Maurice Wetter & Julian Schmitt
 * @version 21.11.2018
 */
enum Sort 
{ 
    quick, selection, insertion, bubble; 
} 

public class Demo {
    private Bar[] barArr;

    private int yPoint, xPoint;
    public int aufwaende = 0;

    Buntstift meinStift;
    Uhr meineUhr;

    public Demo(Sort option, int xPoint, int yPoint) {

        meineUhr = new Uhr();

        meinStift = new Buntstift();

        this.yPoint = yPoint;
        this.xPoint = xPoint;

        createLengths(20);
        placeSortLable(option);
        if (option == Sort.quick)
            quickSort(barArr, 0, barArr.length-1);
        else if (option == Sort.insertion)
            insertionSort(barArr);
        else if (option == Sort.selection)
            selectionSort(barArr);
        else if (option == Sort.bubble)
            bubbleSort(barArr);

    }

    ////////////////**********  INSERTION SORT **********////////////////

    public void insertionSort(Bar arr[]) {

        arr[0].setColor(Color.GREEN);

        for (int i = 1; i < arr.length; ++i) {
            Bar[] copyArr = dublicateArray(); 

            int temp = arr[i].getLength();
            int j;

            //Bewegt das von Element, welches größer als der Wert von temp um eine Position weiter
            for (j = i-1; j >= 0 && arr[j].getLength() > temp; j--) {
                arr[j + 1].setLength(arr[j].getLength());
                arr[j + 1].setColor(Color.GREEN);
                arr[j].setColor(Color.RED);
                radiereBalken(copyArr);
                zeichneBalken(arr);
                meineUhr.warte(50);
            }
            arr[j + 1].setLength(temp);
            arr[j + 1].setColor(Color.GREEN);

            radiereBalken(copyArr);
            zeichneBalken(arr);
            meineUhr.warte(50);
        }
    }

    ////////////////**********  SELECTION SORT **********////////////////
    public void selectionSort(Bar[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Bar[] copyArr = dublicateArray();
            aufwaende++;
            //Findet das kleinste Element im Array
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                arr[j].setColor(Color.BLUE);
                aufwaende++;
                if (arr[j].getLength() < arr[min].getLength()) {
                    arr[min].setColor(Color.BLACK);
                    min = j;
                    arr[j].setColor(Color.RED);

                }
                radiereBalken(copyArr);
                zeichneBalken(arr);
                meineUhr.warte(50);

                if (arr[j].getColor() == Color.BLUE){
                    arr[j].setColor(Color.BLACK);
                }
            }

            //Vertauscht das kleinste gefundene Element mit dem ersten Element
            int temp = arr[min].getLength();
            arr[min].setLength(arr[i].getLength());
            arr[i].setLength(temp);
            arr[min].setColor(Color.BLACK);
            arr[i].setColor(Color.GREEN);

            if (i == arr.length - 2){
                arr[arr.length - 1].setColor(Color.GREEN);

                radiereBalken(copyArr);
                zeichneBalken(arr);
                meineUhr.warte(50);
            }
        }
    }

    ////////////////**********  BUBBLE SORT **********////////////////
    public void bubbleSort(Bar[] arr) {
        Bar[] copyArr = dublicateArray();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                copyArr = dublicateArray();
                arr[j + 1].setColor(Color.RED);
                if (arr[j].getLength() > arr[j + 1].getLength()) {
                    //Vertauscht temp mit arr[i]
                    int temp = arr[j].getLength();
                    arr[j].setLength(arr[j + 1].getLength());
                    arr[j + 1].setLength(temp);
                }
                arr[j].setColor(Color.BLACK);
                radiereBalken(copyArr);
                zeichneBalken(arr);
                meineUhr.warte(50);
            }

            arr[arr.length - i - 1].setColor(Color.GREEN);

            if (i == arr.length - 2){
                arr[0].setColor(Color.GREEN);
            }
            radiereBalken(copyArr);
            zeichneBalken(arr);
            meineUhr.warte(50);
        }

    }

    ////////////////**********  QUICK SORT **********////////////////
    /*
     * Diese Funktion nimmt das letzte Element als Vorzeigeelement und 
     * platziert dieses an der korrekten Position. Von dort aus werden alle 
     * kleineren Elemente als diese Vorziegelement nach links vom 
     * Vorzeigeelement verschoben und alle größeren auf die rechte Seite 
     */
    private int partition(Bar[] arr, int low, int high) {

        Bar[] copyArr = dublicateArray();

        int pivot = arr[high].getLength();
        arr[high].setColor(Color.RED);

        int i = (low - 1); //Index des kleineren Element
        for (int j = low; j < high; j++) {
            // Wenn das aktuelle Element kleiner oder gleich zum Vorzeigeelement ist
            if (arr[j].getLength() <= pivot) {
                copyArr = dublicateArray();
                i++;

                arr[j].setColor(Color.BLUE);
                arr[i].setColor(Color.CYAN);
                //Vertauscht arr[i] und arr[j]
                int temp = arr[i].getLength();
                arr[i].setLength(arr[j].getLength());
                arr[j].setLength(temp);

                radiereBalken(copyArr);
                zeichneBalken(arr);
                meineUhr.warte(200);
            }

            arr[j].setColor(Color.BLACK);
            if (i >= low)
                arr[i].setColor(Color.BLACK);
        }
        copyArr = dublicateArray();
        //Vertauscht arr[i+1] und arr[high]
        int temp = arr[i + 1].getLength();
        arr[i + 1].setLength(arr[high].getLength()); 
        arr[high].setLength(temp);
        arr[high].setColor(Color.BLACK);

        radiereBalken(copyArr);
        zeichneBalken(arr);
        meineUhr.warte(50);

        return i + 1;

    }

    /*
     * Hauptfunktion für Quicksort
     * low --> erste Index
     * high --> letzte Index
     */
    public void quickSort(Bar[] arr, int low, int high) {
        Bar[] copyArr = dublicateArray();
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pivotIndex = partition(arr, low, high);
            arr[pivotIndex].setColor(Color.GREEN);
            // Sorttiert die Elemente rekursiv von und nach der Trennung
            quickSort(arr, low, pivotIndex - 1);

            quickSort(arr, pivotIndex + 1, high);
        } else {
            if (low == high)
                arr[low].setColor(Color.GREEN);
        }

        radiereBalken(copyArr);
        zeichneBalken(arr);
        meineUhr.warte(50);
    }

    ////////////////**********  Graphics **********////////////////
    public void zeichneBalken(Bar[] drawArr) {
        meinStift.normal();

        meinStift.setzeFuellmuster(1);

        for (int i = drawArr.length - 1; i >= 0; i--) {
            int width = 20;
            int height = (int) drawArr[i].getLength();

            meinStift.bewegeBis(xPoint + (25 * i), yPoint - height);

            meinStift.setzeFarbe(drawArr[i].getColor());

            meinStift.zeichneRechteck(width, height);

        }
    }

    public void radiereBalken(Bar[] copy) {
        meinStift.setzeFuellmuster(1);

        meinStift.radiere();

        for (int i = copy.length - 1; i >= 0; i--) {
            int width =  20;
            int height = (int) copy[i].getLength();

            meinStift.bewegeBis(xPoint + (25 * i), yPoint - height);

            meinStift.zeichneRechteck(width, height);

        }
    }

    public void placeSortLable(Sort option)
    {
        meinStift.bewegeBis(xPoint+200, yPoint-350);
        meinStift.setzeSchriftGroesse(40);

        if (option == Sort.quick)
            meinStift.schreibeText("Quicksort");
        else if (option == Sort.insertion)
            meinStift.schreibeText("Insertionsort");
        else if (option == Sort.selection)
            meinStift.schreibeText("Selectionsort");
        else if (option == Sort.bubble)
            meinStift.schreibeText("Bubblesort");
    }

    ////////////////**********  Side Tasks **********////////////////
    public void createLengths(int size) {
        barArr = new Bar[size];

        for (int i = 0; i < size; i++) {
            int randomLength = (int) (Math.random() * 300 + 10);

            barArr[i] = new Bar(randomLength); // 5*i + 20;
        }
    }

    public Bar[] dublicateArray() {
        Bar[] clonedArr = new Bar[barArr.length];
        for (int i = 0; i < barArr.length; i++) {
            clonedArr[i] = new Bar(barArr[i].getLength());
        }

        return clonedArr;

    }

    public int getAufwaende()
    {
        return aufwaende;
    }
}
