package ru.job4j.srp.design;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEmployeesEngineTest {
    @Test
    public void whenTextGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StoreEngine reportEngine = new EmployeesReportEngine(store, new TextReportGenerator());
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() + ";";
        assertThat(reportEngine.generate(em -> true), is(expect));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StoreEngine reportEngine = new EmployeesReportEngine(store, new HTMLReportGenerator());
        String expect = "<html>" + System.lineSeparator() +
                " <head></head>" + System.lineSeparator() +
                " <body>" + System.lineSeparator() +
                "  <employees>" + System.lineSeparator() +
                "   <employee " +   "name=\"" + worker.getName() + "\" " +
                                    "hired=\"" + worker.getHired().getTime() + "\" " +
                                    "fired=\"" + worker.getFired().getTime() + "\" " +
                                    "salary=\"" + worker.getSalary() + "\"" + ">" +
                   "</employee>" + System.lineSeparator() +
                "  </employees>" + System.lineSeparator() +
                " </body>" + System.lineSeparator() +
                "</html>";
        assertThat(reportEngine.generate(em -> true), is(expect));
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker  = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StoreEngine storeEngine = new EmployeesReportEngine(store, new JSONReportGenerator());
        String expect = "{" +
                            "\"employees\":[" +
                                "{" +
                                    "\"name\":\"" + worker.getName() + "\"," +
                                    "\"hired\":{" +
                                        "\"year\":" + worker.getHired().get(Calendar.YEAR) + "," +
                                        "\"month\":" + worker.getHired().get(Calendar.MONTH) + "," +
                                        "\"dayOfMonth\":" + worker.getHired().get(Calendar.DAY_OF_MONTH) + "," +
                                        "\"hourOfDay\":" + worker.getHired().get(Calendar.HOUR_OF_DAY) + "," +
                                        "\"minute\":" + worker.getHired().get(Calendar.MINUTE) + "," +
                                        "\"second\":" + worker.getHired().get(Calendar.SECOND) +
                                    "}," +
                                    "\"fired\":{" +
                                        "\"year\":" + worker.getFired().get(Calendar.YEAR) + "," +
                                        "\"month\":" + worker.getFired().get(Calendar.MONTH) + "," +
                                        "\"dayOfMonth\":" + worker.getFired().get(Calendar.DAY_OF_MONTH) + "," +
                                        "\"hourOfDay\":" + worker.getFired().get(Calendar.HOUR_OF_DAY) + "," +
                                        "\"minute\":" + worker.getFired().get(Calendar.MINUTE) + "," +
                                        "\"second\":" + worker.getFired().get(Calendar.SECOND) +
                                    "}," +
                                    "\"salary\":" + worker.getSalary() +
                                "}" +
                            "]" +
                        "}";
        assertThat(storeEngine.generate(em -> true), is(expect));
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StoreEngine reportEngine = new EmployeesReportEngine(store, new XMLReportGenerator());
        String expect = "<report>" + System.lineSeparator() +
                "  <employees>" + System.lineSeparator() +
                "    <employee>" + System.lineSeparator() +
                "      <name>" + worker.getName() + "</name>" + System.lineSeparator() +
                "      <hired>" +
                            worker.getHired().get(Calendar.DAY_OF_MONTH) + "/" +
                            String.format("%02d", worker.getHired().get(Calendar.MONTH) + 1) + "/" +
                            worker.getHired().get(Calendar.YEAR) +
                        "</hired>" + System.lineSeparator() +
                "      <fired>" +
                            worker.getFired().get(Calendar.DAY_OF_MONTH) + "/" +
                            String.format("%02d", worker.getFired().get(Calendar.MONTH) + 1) + "/" +
                            worker.getFired().get(Calendar.YEAR) +
                        "</fired>" + System.lineSeparator() +
                "      <salary>" + worker.getSalary() + "</salary>" + System.lineSeparator() +
                "    </employee>" + System.lineSeparator() +
                "  </employees>" + System.lineSeparator() +
                "</report>" + System.lineSeparator();
        assertThat(reportEngine.generate(em -> true), is(expect));
    }
}