package spatula.generateDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;



public class GenerateTest {

	public static void main(String[] args) {

		try {
		      InputStream in = new FileInputStream(new File("src/main/resources/template/test.docx"));
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      IContext context = report.createContext();
		      Project project = new Project();
		      project.setName("test name");
		      project.setAddress("test address");
		      context.put("project", project);

		      OutputStream out = new FileOutputStream(new File("src/main/resources/template/test_out.docx"));
		      report.process(context, out);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
	}
}
