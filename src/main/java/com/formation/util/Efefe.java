package com.formation.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ArticleDAO;

public class Efefe {
	
	public void testss(ArticleDAO dao) {
        // This will create the dataset
        PieDataset dataset = createDataset(dao);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, "Articles vendues");
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application

        try {
			ChartUtilities.saveChartAsPNG(new File("C:\\Users\\Dimi\\git\\LunaJee\\src\\main\\webapp\\css\\img\\stats.png"), chart, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
	
	
	 private  PieDataset createDataset(ArticleDAO dao) {
		 	DefaultPieDataset result = new DefaultPieDataset();
		 	List<String> list = dao.getArticleUtil();
		 	String desi;
		 	int compt=0;
		 	for(int i=0;i<list.size();i++) {
		 		desi=list.get(i);
		 		if(i ==0) {
		 			compt +=1;
		 		}
		 		else if(desi.equals(list.get(i -1))){
		 			compt +=1;
		 		}
		 		else {
		 			result.setValue(list.get(i-1), compt);
		 			compt = 1;
		 		}
		 		
		 	}
	        return result;

	    }
	 
	 private JFreeChart createChart(PieDataset dataset, String title) {

	        JFreeChart chart = ChartFactory.createPieChart3D(
	            title,                  // chart title
	            dataset,                // data
	            true,                   // include legend
	            true,
	            false
	        );

	        PiePlot3D plot = (PiePlot3D) chart.getPlot();
	        plot.setStartAngle(290);
	        plot.setDirection(Rotation.CLOCKWISE);
	        plot.setForegroundAlpha(0.5f);
	        return chart;

	    }
}
