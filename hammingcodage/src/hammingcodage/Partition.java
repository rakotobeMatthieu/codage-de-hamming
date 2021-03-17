/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hammingcodage;

/**
 *
 * @author Jessi
 */
public class Partition {
    int longcode;
    int longhamming;
    int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Partition() {
    }

    public Partition(int longcode, int longhamming,int n) {
        this.longcode = longcode;
        this.longhamming = longhamming;
        this.n=n;
    }

    public int getLongcode() {
        return longcode;
    }

    public void setLongcode(int longcode) {
        this.longcode = longcode;
    }

    public int getLonghamming() {
        return longhamming;
    }

    public void setLonghamming(int longhamming) {
        this.longhamming = longhamming;
    }
}
