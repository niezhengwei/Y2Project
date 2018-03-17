package MyCollection;

import java.util.*;

/**
 * Created by leon on 2018/3/5.
 */
public class collection {
    public String[] array;
    public List<String> list;
    public Set<String> set;
    public Map<String,String> map;

    public Properties properties;

    public collection() {
        System.out.println("====无参构造===");
    }
    /*   @Override
    public String toString() {
        return "collection{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }*/

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
