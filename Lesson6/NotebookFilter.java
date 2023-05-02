package Lesson6;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotebookFilter {

    public List<Notebook> filterNotebooks(List<Notebook> notebooks, Map<String, Integer> criteria) {
        List<Notebook> filtered = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean passed = true;

            for (Map.Entry<String, Integer> entry : criteria.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                switch (key) {
                    case "ram":
                        if (notebook.getRam() < value) {
                            passed = false;
                        }
                        break;
                    case "storage":
                        if (notebook.getStorage() < value) {
                            passed = false;
                        }
                        break;
                    case "os":
                        if (!notebook.getOs().equals(new String(new char[]{(char) value}))) {
                            passed = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equals(new String(new char[]{(char) value}))) {
                            passed = false;
                        }
                        break;
                }

                if (!passed) {
                    break;
                }
            }

            if (passed) {
                filtered.add(notebook);
            }
        }

        return filtered;
    }
}

