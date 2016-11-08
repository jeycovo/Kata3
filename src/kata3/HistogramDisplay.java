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
    
    private final Histogram <String, Integer> histogram;
    
    public HistogramDisplay(Histogram <String, Integer> histogram) {
        super("Histograma");
        this.histogram = histogram;
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
        for (String key : histogram.KeySet()) {
            dataSet.addValue(histogram.get(key),"",key);
        }
        return dataSet;
    }
}