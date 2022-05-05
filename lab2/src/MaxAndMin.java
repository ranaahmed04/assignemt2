public class MaxAndMin {

    public Integer Maximum = null;
    private Integer Minimum= null;

    public Integer find_Max(int x[]) {
        Integer max = null;
        if (x.length != 0) {
            max = x[0];
            for (int i = 1; i < x.length; i++) {
                if (max < x[i]) {
                    max = x[i];
                }
            }
        }
        Maximum = max;
        return max;
    }
    public Integer find_Min(int y[]) {
        Integer min = null;
        if (y.length != 0) {
            min = y[0];
            for (int i = 1; i < y.length; i++) {
                if (min > y[i]) {
                    min = y[i];
                }
            }
        }
        Minimum = min;
        return min;
    }
}
