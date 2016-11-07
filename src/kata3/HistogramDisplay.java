package kata3;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    public HistogramDisplay() {
        super("Histograma");
        setContentPane(createPanel());
        pack();
    }
    //metodo para ejecutar la ventana
    public void execute(){
     setVisible(true);
    }
    
    //ventana PANEL - ChartPanel
    private JPanel createPanel(){
      ChartPanel chartPanel= new ChartPanel(createChart(createDataset()));
      setPreferredSize(new Dimension(500,400));
      return chartPanel;
    }
    
    //Cuadro(con el histograma) CHART-JFreeChart
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        //creamos el histograma y le damos valores
        JFreeChart chart;
        chart = ChartFactory.createBarChart("JfreeChart Histogram", "Dominios email", "Nº de emails",dataSet, PlotOrientation.VERTICAL, false, true, true) ;
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(5,"","gmail.com");
        dataSet.addValue(10,"","ulpgc.es");
        dataSet.addValue(7,"","ull.es");
        dataSet.addValue(2,"","hotmail.com");
        return dataSet;
    }
}
