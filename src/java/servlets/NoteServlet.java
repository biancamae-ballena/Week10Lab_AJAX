/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 785284
 */
public class NoteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private Note readNote(HttpServletRequest request) throws IOException {
        String title = "";
        String content = "";

        ArrayList<String> readNote = new ArrayList<>();

        //Getting the path of the file note.txt
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        //Reading the contents inside the note.txt file
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        while (br.ready()) {
            readNote.add(br.readLine());
        }

        title = readNote.get(0);

        for (int i = 1; i < readNote.size(); i++) {
            content = content + readNote.get(i);
        }
        Note note = new Note(title, content);
        br.close();
        return note;
    }

    private Note writeNote(HttpServletRequest request) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        //Getting the path of the file note.txt
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        //Printing the new contents inside the note.txt file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        pw.printf("%s%n", title);
        pw.printf(content);

        //Close the file
        pw.close();

        Note newNote = new Note(title, content);

        return newNote;
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
