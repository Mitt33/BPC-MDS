package mds.uvod;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("basic")
public class BasicController {

    @GetMapping
    public String hello(){
        return "<b><h1>Hello world!</h1></b>";
    }

    @GetMapping("list")
    public List<String> testList(){
        return List.of("Hello", "World", "in", "JSON");
    }

    @GetMapping("test1")
    public String testParam1(@RequestParam String name){
        return String.format("Hello %s!!", name);
    }

    @GetMapping("test2")
    public String testParam2(@RequestParam(defaultValue = "user") String name){
        return String.format("Hello %s!!", name);
    }

    @GetMapping("test3")
    public String testParam3(@RequestParam(name = "n", defaultValue = "user") String name){
        return String.format("Hello %s!!", name);
    }

    @GetMapping("test4")
    public String testParam4(@RequestParam(defaultValue = "user") String name,
                                 @RequestParam(defaultValue = "-1") int id){
        return String.format("Hello %s!!Your id is: %d", name, id);
    }

    @GetMapping("test5")
    public String testParam5(@RequestParam List<String> id){
     //   return "all ids are: " +id;
        String w = "";
        for (String s : id){
            w += s + "<br>";
        }
        return w;
    }

 /*   @GetMapping("form")
    public String helloForm(){
        String html =
                "<html>" +
                        "<body>" +
                        "<form>" +
                        "<form method='post' action='text2'/>+" +
                        "<input type='text' name='name'/>+" +
                        "<input type='submit' value='Pozdrav'/>+" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }


    //tady chybi

  /*  List<String> students = new ArrayList<>();
    {
        list nakopirovany
   */



}
