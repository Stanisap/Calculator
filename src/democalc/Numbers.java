package democalc;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Numbers {
    protected LinkedHashMap<String, Integer> mapRoman;
    public Numbers() {

    }

    protected Map<String, Integer> creatMap() {
        mapRoman = new LinkedHashMap<String, Integer>();
        mapRoman.put("C", 100);
        mapRoman.put("XC", 90);
        mapRoman.put("L", 50);
        mapRoman.put("XL", 40);
        mapRoman.put("X", 10);
        mapRoman.put("IX", 9);
        mapRoman.put("V", 5);
        mapRoman.put("IV", 4);
        mapRoman.put("I", 1);
        return mapRoman;
    }

    public abstract int doOperation() throws IOException;
}

