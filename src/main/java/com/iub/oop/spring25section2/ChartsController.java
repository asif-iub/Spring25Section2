package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ChartsController
{
    @javafx.fxml.FXML
    private PieChart pieChart;
    @javafx.fxml.FXML
    private XYChart chart;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void load(ActionEvent actionEvent) {
        loadPieChartData();
        loadBarChartData();
    }

    void loadPieChartData() {
        List<PieChart.Data> data = new ArrayList<>();
        data.add(new PieChart.Data("A", 3));
        data.add(new PieChart.Data("B", 5));
        data.add(new PieChart.Data("C", 9));
        data.add(new PieChart.Data("D", 1));
        data.add(new PieChart.Data("E", 2));

        pieChart.getData().addAll(data);
    }

    void loadBarChartData() {
        chart.getData().clear();

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Section 1");
        series1.getData().add(new XYChart.Data<>("A", 3));
        series1.getData().add(new XYChart.Data<>("B", 5));
        series1.getData().add(new XYChart.Data<>("C", 9));
        series1.getData().add(new XYChart.Data<>("D", 1));
        series1.getData().add(new XYChart.Data<>("F", 2));

        chart.getData().add(series1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Section 2");
        series2.getData().add(new XYChart.Data<>("A", 4));
        series2.getData().add(new XYChart.Data<>("B", 6));
        series2.getData().add(new XYChart.Data<>("C", 4));
        series2.getData().add(new XYChart.Data<>("D", 2));
        series2.getData().add(new XYChart.Data<>("F", 3));

        chart.getData().add(series2);
    }
}