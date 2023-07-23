package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();


        String searchLine = request.getParameter("search") == null ? "" : request.getParameter("search");
        List<String> companies = getCompanies();
        List<String> sortedCompanies = companies.stream()
                .filter(x -> x.contains(searchLine))
                .toList();
        if(sortedCompanies.isEmpty()) {
            out.println("Companies not found");
            return;
        }
        sortedCompanies.forEach(out::println);
        // END
    }
}
