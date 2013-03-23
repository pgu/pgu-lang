package pgu.lang.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setHeader("Content-disposition", "attachment; filename=Pgu_jeu.html");

        final String fileUrl = "http://pgu-jeu.appspot.com/Pgu_jeu.html";

        final URL url = new URL(fileUrl);

        final PrintWriter writer = resp.getWriter();
        final BufferedWriter bw = new BufferedWriter(writer);

        final Scanner scanner = new Scanner(url.openStream(), "UTF-8");
        while (scanner.hasNextLine()) {
            bw.write(scanner.nextLine());
            bw.write("\n");
        }

        scanner.close();
        bw.close();

    }

}
