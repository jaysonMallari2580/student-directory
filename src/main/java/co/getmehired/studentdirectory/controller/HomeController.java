package co.getmehired.studentdirectory.controller;

import co.getmehired.studentdirectory.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String form(Model model){
        model.addAttribute("student",new Student());
        return "form";
    }

    @PostMapping("/table")
    public String table(@ModelAttribute Student s, Model model){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(s.getName(),s.getEmail(),s.getPhoneNumber(),s.getPassword(),
                s.getCourseType()));

        students.add(new Student("Jayson Mallari","jmallari@gmh.com","3478041234","Summer2020!",
                "Certificate"));
        students.add(new Student("Peter Griffin","pgriffin@familyguy.com","9298765432","Winter2019!",
                "Master Degree"));
        students.add(new Student("Monkey D. Luffy","mdluffy@onepiece.com","7187654321","3Dx2Yr!",
                "Postgraduate"));
        students.add(new Student("Michael Jordan","mjordan@lastdance.com","9292312450","Pippen1997!",
                "Diploma"));

        model.addAttribute("students",students);
        return "table";
    }
}
