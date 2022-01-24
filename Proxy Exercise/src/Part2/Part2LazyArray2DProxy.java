package Part2;

import java.io.IOException;

public class Part2LazyArray2DProxy implements Part2Array2D {

    Part2Array2D twoD = null;
    String filename;

    public Part2LazyArray2DProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void set(int row, int col, int value) {
        loadObject();
        twoD.set(row, col, value);
    }

    @Override
    public int get(int row, int col) {
        loadObject();
        return twoD.get(row, col);
    }

    private void loadObject() {
        try {
            if (twoD == null) {
                twoD = new Part2Array2DImplementation(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
