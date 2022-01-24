package Part2;

import java.io.*;

public class Part2Array2DImplementation implements Part2Array2D{

    int[][] twoD;
    int cols;
    int rows;

    public Part2Array2DImplementation(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        this.twoD = new int[rows][cols];
    }

    public Part2Array2DImplementation(String filename) throws IOException, ClassNotFoundException {
        this.twoD = load(filename);
    }

    @Override
    public void set(int row, int col, int value) {
        twoD[row][col] = value;
    }

    @Override
    public int get(int row, int col) {
        return twoD[row][col];
    }

    public void save(String filename) throws IOException, ClassNotFoundException {
        FileOutputStream fs = new FileOutputStream(filename);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(this.twoD);
    }

    public int[][] load(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream iis = new ObjectInputStream(fis);
        return (int[][]) iis.readObject();
    }

}
