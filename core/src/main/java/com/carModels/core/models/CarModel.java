package com.carModels.core.models;

import java.util.List;
import java.util.Map;

public interface CarModel {
    String getTitle();
    String getText();
    String getBottomText();
    List<Map<String, String>> getCarModels();

}
